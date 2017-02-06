package com.example.edgar.healthcareagent;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;

import com.example.edgar.healthcareagent.contentResult.ContentResult;
import com.example.edgar.healthcareagent.searchResult.Concept;
import com.example.edgar.healthcareagent.searchResult.SearchResult;
import com.example.edgar.healthcareagent.taxonomyResult.TaxonomyResult;
import com.example.edgar.healthcareagent.taxonomyResult.Topic;
import com.example.edgar.healthcareagent.taxonomyResult.TopicAspect;
import com.google.gson.Gson;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.edgar.healthcareagent.GetAPIAITopicActivity.APIAIchoice;
import static com.example.edgar.healthcareagent.GetAPIAITopicActivity.APIAIrequest;
import static com.example.edgar.healthcareagent.SuggestionAndResponseModel.reply;

/**
 * Created by Edgar on 11/20/2016.
 */

public class SearchModel extends AppCompatActivity  {

    private String request;
    private String concept;
    private Context context;
    String choice = reply; //import reply from suggestions search
    SearchModel() throws JSONException {}

    public String getFinalReply(String token) throws JSONException {
        String resultFinal = "";
        String searchUrl = "https://search.healthwise.net/v1/search?q="
                + APIAIrequest + "&top=5&skip=12&num_concepts=12";

        OkHttpClient client = new OkHttpClient();
        Request newRequest1 = new Request.Builder()
                .url(searchUrl)
                .addHeader("Authorization", "Bearer " + token)
                .build();
        String req = newRequest1.toString();
        Log.d("OKHTTP3", "Request Build successful.");
        String finalReply = "I'm sorry.  Data on this topic is not available" +
                "Please choose another topic";
        try {//First search for the Taxonomy url
            Response response = client.newCall(newRequest1).execute();
            final Gson gson = new Gson();
            SearchResult searchResult = gson.fromJson(response.body().charStream(), SearchResult.class);
            String taxonomyUrl = "";
            String concept = "";
            String request = APIAIchoice.toLowerCase();
            List<Concept> concepts = searchResult.getConcepts();
            for(int i = 0; i < concepts.size(); i++) {
                concept = concepts.get(i).getLabel().toLowerCase();
                if (concept.equals(request)) {
                    taxonomyUrl = concepts.get(i).getHref();
                    Log.d("HEALTHCARE", "Got the Taxonomy url");
                    break;
                }else{
                    return finalReply;
                }
            }
            //Second search for the Taxonomy url
            TaxonomyResult taxonomyResult = null;
            if (!taxonomyUrl.isEmpty()) {
                Response response2;
                Request newRequest2 = new Request.Builder()
                        .url(taxonomyUrl)
                        .addHeader("Authorization", "Bearer " + token)
                        .build();
                response2 = client.newCall(newRequest2).execute();
                final Gson gson2 = new Gson();
                taxonomyResult = gson2.fromJson(response2.body().charStream(), TaxonomyResult.class);
                int stop = 0;
            } else {
                return finalReply;
            }
            //Third search for Content url:
            List<TopicAspect> aspects = taxonomyResult.getData().getContent().getTopicAspects();
            List<Topic> topics = null;
            String contentUrl = "";
            String contentId = "";
            String title = "";
            for (int i = 0; i < aspects.size(); i++) {
                if (aspects.get(i).getId().equals("whatIs")) {
                    topics = aspects.get(i).getTopics();
                    Log.d("HEALTHCARE", "Got the topics list");
                    break;
                }
            }
            String requestToCompare = "what is " + request + "?";
            if (topics!=null) {
                //make everything lowercase to avoid problems
                for (int i = 0; i < topics.size(); i++) {
                   //title = topics.get(i).getTitle().toLowerCase();
                    try {
                        if (topics.get(i).getDetailLevel().equals("mainPoint") //||
                                /*topics.get(i).getDetailLevel().equals("summary")) &&
                                (topics.get(i).getTitle().toLowerCase()).equals(requestToCompare)*/) {
                            contentId = topics.get(i).getId();
                            contentUrl = topics.get(i).getHref() + "/en-us";
                            //contentUrl += "/en-us";
                            //contentUrl = "https://content.healthwise.net/v1/topics/" +
                                    //contentId + "/en-us";
                            Log.d("HEALTHCARE", "Got the content url");
                            break;
                        }
                    }
                    //for some reason some of the detail levels are null
                    catch (NullPointerException e){
                        continue;
                    }
                }
            } else {
                return finalReply;
            }

            //This is where we get the final reply
            if (!contentUrl.isEmpty()) {
                ContentResult contentResult = null;
                Response contentResponse;
                Request contentRequest = new Request.Builder()
                        .url(contentUrl)
                        .addHeader("Authorization", "Bearer " + token)
                        .build();
                contentResponse = client.newCall(contentRequest).execute();
                String contentJSON = contentResponse.body().string();
                contentResponse.close();
                contentJSON = contentJSON.replaceAll("[\u0000-\u001f]", "");
                Log.d("HEALTHCARE", "Got the content");
                final Gson gson2 = new Gson();
                contentResult = gson2.fromJson(contentJSON, ContentResult.class);
                finalReply = contentResult.getData().getTopics().get(0).getHtml();
                finalReply = Html.fromHtml(finalReply).toString();
                finalReply += "If you wish, press button to choose another topic.";
                Log.d("OKHTTP3", "Got the response");
            }
            else {
                return finalReply;
            }
        } catch (IOException e) {
            Log.d("HEALTHCARE", "Exception while doing request");
            e.printStackTrace();
        }
        return finalReply;
    }
}
