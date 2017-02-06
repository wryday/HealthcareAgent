package com.example.edgar.healthcareagent;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.edgar.healthcareagent.rest.ApiClient;
import com.example.edgar.healthcareagent.rest.ApiInterface;
import com.example.edgar.healthcareagent.searchResult.SearchResult;
import com.example.edgar.healthcareagent.suggestions.Suggestions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ai.api.AIListener;
import ai.api.model.AIError;
import ai.api.model.AIResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//import static com.example.edgar.healthcareagent.GetSuggestionsActivity.replyOk;

/**
 * Created by Edgar on 1/2/2017.
 */

public class MainActivity extends AppCompatActivity implements AIListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    String contentID = "angina";
    String search_BASE_URL = "https://search.healthwise.net/v1/";
    String auth_BASE_URL = "https://auth.healthwise.net/v1/";
    String taxonomy_BASE_URL = "https://taxonomy.healthwise.net/v1";
    String content_BASE_URL = "https://content.healthwise.net/v1/topics/" +
                contentID + "/en-us";
    String request = "angina";
    Boolean replyOk = true;
    public static String reply = "";

    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        new Thread(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void run() {
                TokenRequest tokenRequest = new TokenRequest();
                String authToken = tokenRequest.getToken();
                ApiInterface apiService =
                        ApiClient.getClient(search_BASE_URL, authToken).create(ApiInterface.class);
                getSuggestionList(apiService, request);
            }
        }).start();
        //setContentView(R.layout.activity_main);

    }

    public void getToken(ApiInterface apiService, String request){

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
                }
                else {
                    reply = "I'm sorry. Information on this topic is not available." +
                            "Please press the button and choose another topic";
                    replyOk = false;
                }
            }

            @Override
            public void onFailure(Call<Suggestions> call, Throwable t) {
                Log.e(TAG, t.toString());

                Log.d("RETRO", "Entered onFailure");
                reply = "I'm sorry. Information on this topic is not available." +
                        "Please press the button and choose another topic";
                replyOk = false;
            }
        });
    }

    public void getSearchTopic(ApiInterface apiService, String APIAIchoice){

        /* search?q="+ APIAIchoice + "&top=5&skip=12&num_concepts=12*/
        Map<String, String> searchData = new HashMap<>();
        searchData.put("num_concepts", String.valueOf(12));
        searchData.put("skip", String.valueOf(12));
        searchData.put("top", String.valueOf(5));
        searchData.put("q", APIAIchoice);
        Call<SearchResult> call = apiService.getSearchResults(searchData);
        call.enqueue(new Callback<SearchResult>() {

            @Override
            public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {

            }

            @Override
            public void onFailure(Call<SearchResult> call, Throwable t) {

            }
        });
    }

    public void getTaxonomyResult(ApiInterface apiService){
        Map<String, String> data = new HashMap<>();

    }

    public void getContentResult(ApiInterface apiService, String contentID){
        /*contentUrl = "https://content.healthwise.net/v1/topics/ + contentId + "/en-us";*/
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
