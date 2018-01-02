package com.edgar.healthcareagent;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;

import com.edgar.healthcareagent.rest.ApiClient;
import com.edgar.healthcareagent.rest.ApiInterface;
import com.edgar.healthcareagent.searchResult.Concept;
import com.edgar.healthcareagent.searchResult.SearchResult;
import com.edgar.healthcareagent.suggestions.Suggestions;
import com.edgar.healthcareagent.taxonomyResult.TaxonomyResult;
import com.edgar.healthcareagent.taxonomyResult.Topic;
import com.edgar.healthcareagent.taxonomyResult.TopicAspect;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ai.api.AIListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//import static com.edgar.healthcareagent.GetSuggestionsActivity.replyOk;

public class MainActivity extends AppCompatActivity implements AIListener {
    private static final String TAG = MainActivity.class.getSimpleName();

    private String ClientId = "4488c302a1be4a6ca430b63661843c43";
    private String ClientSecret = "qOGnt7wlB0eQo0pbaEcoXw==";

    public static String token = "";

    String contentID = "angina";
    String search_BASE_URL = "https://search.healthwise.net/v1/";
    String auth_BASE_URL = "https://auth.healthwise.net/v1/oauth2/";
    //String taxonomy_BASE_URL = "https://taxonomy.healthwise.net/v1";
    String content_BASE_URL = "https://content.healthwise.net/v1/topics/" +
            contentID + "/en-us";
    String request = "angina";
    Boolean replyOk = true;

    public static String reply = "";

    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

        /*TokenRequest2 tokenRequest2 = new TokenRequest2();
        tokenRequest2.execute();
        while(token.isEmpty()){}
        tokenRequest2.cancel(true);
        Log.d("TOKEN2", token);
        ApiInterface searchApi =
                ApiClient.getClient(search_BASE_URL, token).create(ApiInterface.class);
        String taxonomyUrl = getSearchTopic(searchApi, contentID); */

        new Thread(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void run() {
                TokenRequest tokenRequest = new TokenRequest();
                String authToken = tokenRequest.getToken();
                ApiInterface searchApi =
                        ApiClient.getClient(search_BASE_URL, authToken).create(ApiInterface.class);
                String taxonomyUrl = getSearchTopic(searchApi, contentID);
                contentID = contentID.toLowerCase();
            }
        }).start();
        /*
        ApiInterface suggestionApi =
                ApiClient.getClient(search_BASE_URL, token).create(ApiInterface.class);
        getSuggestionList(suggestionApi, "angina");
        ApiInterface searchApi =
                ApiClient.getClient(search_BASE_URL, token).create(ApiInterface.class);
        contentID = contentID.toLowerCase();
        String taxonomyUrl = getSearchTopic(searchApi, contentID);
        ApiInterface taxonomyApi =
                ApiClient.getClient(taxonomyUrl, token).create(ApiInterface.class);
        String contentUrl = getTaxonomyTopic(taxonomyApi);  */
    }

    public void getSuggestionList(ApiInterface apiService, String request) {
        Map<String, String> data = new HashMap<>();
        data.put("top", String.valueOf(2));
        data.put("content", "content=(article+topic)");
        data.put("fq", "types:(HWCV_10000+HWCV_10002+HWCV_10003)");
        data.put("q", request);

        Call<Suggestions> call = apiService.getSuggestions(data);
        String what = call.request().toString();
        call.enqueue(new Callback<Suggestions>() {
            @Override
            public void onResponse(Call<Suggestions> call, Response<Suggestions> response) {
                Log.d("RETRO", "Entering onResponse");
                List labels = response.body().getItems();
                Log.d("RETRO", "Got the list of labels");
                if (!labels.isEmpty()) {
                    String item = "";
                    reply = "The suggested list of topics are ";
                    for (int i = 0; i < labels.size(); i++) {
                        item = response.body().getItems().get(i).getLabel();
                        reply = reply + item;
                        if (i < labels.size() - 1) {
                            reply += " and ";
                        }
                    }
                    reply += ". Please press the button and make your choice?";
                    replyOk = true;
                } else {
                    reply = "I'm sorry. Information on this topic is not available." +
                            "Please press the button and choose another topic";
                    replyOk = false;
                }
            }

            @Override
            public void onFailure(Call<Suggestions> call, Throwable t) {
                Log.e(TAG, t.toString());
                t.printStackTrace();
                Log.d("RETRO", "Entered onFailure");
                reply = "I'm sorry. Information on this topic is not available." +
                        "Please press the button and choose another topic";
                replyOk = false;
            }
        });
    }

    public String getSearchTopic(ApiInterface apiService, String APIAIchoice) {
        Log.d(TAG, "Entering getSearchTopic");
//        ApiAiChoice = result.getFulfillment().getSpeech();
//        ApiAiRequest = ApiAiChoice.replace(' ', '+');/
//        String searchUrl = "https://search.healthwise.net/v1/search?q="
//                        + ApiAiRequest + "&top=5&skip=12&num_concepts=12";

        Map<String, String> searchData = new HashMap<>();
        searchData.put("num_concepts", String.valueOf(12));
        searchData.put("skip", String.valueOf(12));
        searchData.put("top", String.valueOf(5));
        searchData.put("q", APIAIchoice);

        Call<SearchResult> call = apiService.getSearchResults(searchData);
        final String[] taxonomyUrl = {""};
        call.enqueue(new Callback<SearchResult>() {
            @Override
            public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
                String concept = "";
                List<Concept> concepts = response.body().getConcepts();
                for (int i = 0; i < concepts.size(); i++) {
                    concept = concepts.get(i).getLabel().toLowerCase();
                    if (concept.equals(APIAIchoice)) {
                        taxonomyUrl[0] = concepts.get(i).getHref();
                        Log.d("HEALTHCARE", "Got the Taxonomy url");
                        break;
                    } else {
                        Log.d("SEARCHAPI", "Couldn't find Taxonomy url");
                    }
                }
            }

            @Override
            public void onFailure(Call<SearchResult> call, Throwable t) {
                t.printStackTrace();
                Log.d("HEALTHCARE", "Didn't get the Taxonomy url");
            }
        });

        while (taxonomyUrl[0].isEmpty()) {
        }

        return taxonomyUrl[0];
    }

    public String getTaxonomyTopic(ApiInterface apiService) {
        final String[] contentUrl = {""};

        Map<String, String> taxData = new HashMap<>();

        Call<TaxonomyResult> call = apiService.getTaxonomyResults(taxData);
        call.enqueue(new Callback<TaxonomyResult>() {
            @Override
            public void onResponse(Call<TaxonomyResult> call, Response<TaxonomyResult> response) {
                List<TopicAspect> aspects = response.body().getData().getContent().getTopicAspects();
                List<Topic> topics = null;
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
                if (topics != null) {
                    //make everything lowercase to avoid problems
                    for (int i = 0; i < topics.size(); i++) {
                        //title = topics.get(i).getTitle().toLowerCase();
                        try {
                            if (topics.get(i).getDetailLevel().equals("mainPoint") //||
                                /*topics.get(i).getDetailLevel().equals("summary")) &&
                                (topics.get(i).getTitle().toLowerCase()).equals(requestToCompare)*/) {
                                contentId = topics.get(i).getId();
                                contentUrl[0] = topics.get(i).getHref() + "/en-us";
                                //contentUrl += "/en-us";
                                //contentUrl = "https://content.healthwise.net/v1/topics/" +
                                //contentId + "/en-us";
                                Log.d("HEALTHCARE", "Got the content url");
                                break;
                            }
                        }
                        //for some reason some of the detail levels are null
                        catch (NullPointerException e) {
                            continue;
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<TaxonomyResult> call, Throwable t) {

            }
        });
        return contentUrl[0];
    }

    public void getContentResult(ApiInterface apiService, String contentID) {
        /*contentUrl = "https://content.healthwise.net/v1/topics/ + contentId + "/en-us";*/
    }

    private String getEncodedAuthCode() {
        String code = ClientId + ":" + ClientSecret;
        String result;
        Log.v("OKHTTP3", "Encoding: " + code);
        byte[] code2 = code.getBytes();
        String finalCode = Base64.encodeToString(code2, Base64.URL_SAFE | Base64.NO_WRAP);
        result = String.format("Basic " + finalCode);
        return result;
    }

    @Override
    public void onResult(AIResponse result) {

    }

    @Override
    public void onError(AIError error) {

    }

    @Override
    public void onAudioLevel(float level) {

    }

    @Override
    public void onListeningStarted() {

    }

    @Override
    public void onListeningCanceled() {

    }

    @Override
    public void onListeningFinished() {

    }
}
