package com.example.edgar.healthcareagent;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.edgar.healthcareagent.suggestions.Suggestions;
import com.google.gson.Gson;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.edgar.healthcareagent.GetSuggestionsActivity.replyOk;

/**
 * Created by Edgar on 11/20/2016.
 */

public class SuggestionAndResponseModel extends AppCompatActivity  {

    private String token;
    private String request;
    private TextToSpeech tts;
    private Context context;
    public static Suggestions suggestions;

    SuggestionAndResponseModel(String token, Context context) throws JSONException {

        this.token = token;
        this.request = request;
    }
    public static String reply;

    public String suggestionSearch(String token2, String request) throws JSONException {

        String url = "https://search.healthwise.net/v1/suggestions?q=" + request +
                "&fq=types%3A(HWCV_10000+HWCV_10002+HWCV_10003)" +
                "&content=content%3D(article+topic)&top=2";
        //String url = "https://search.healthwise.net/v1/search?q=diabetes&lang=en-us";

        OkHttpClient client = new OkHttpClient();
        Request newRequest = new Request.Builder()
                .url(url)
                .addHeader("Authorization","Bearer " + token2)
                .build();
        Log.d("HEALTHCARE", "Request Build successful.");

        try {
            Response response = client.newCall(newRequest).execute();
            final Gson gson = new Gson();
            suggestions = gson.fromJson(response.body().charStream(), Suggestions.class);
            response.close();
            List labels = suggestions.getItems();

            if(!labels.isEmpty()) {
                String item = "";
                reply = "The suggested list of topics are ";
                for (int i = 0; i < labels.size(); i++) {
                    item = suggestions.getItems().get(i).getLabel();
                    reply = reply + item;
                    if (i < labels.size() - 1) {
                        reply += " and ";
                    }
                }
                reply += "Please press the button and make your choice?";
                replyOk = true;
            }
            else{
                reply = "I'm sorry. Information on this topic is not available." +
                        "Please press the button and choose another topic";
                replyOk = false;
            }
            Log.d("OKHTTP3", "Got the response");
        } catch (IOException e) {
            Log.d("OKHTTP3", "Exception while doing request");
            e.printStackTrace();
        }
        return reply;
    }
}
