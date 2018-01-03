package com.edgar.healthcareagent.util;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.util.Log;

import com.edgar.healthcareagent.model.suggestions.Suggestions;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.edgar.healthcareagent.ui.GetSuggestionsActivity.replyOk;

public class SuggestionAndResponseModel {
    private static final String TAG = SuggestionAndResponseModel.class.getSimpleName();

    public static Suggestions suggestions;
    public static String reply;

    private String token;
    private String request;
    private TextToSpeech tts;

    private Context context;

    public SuggestionAndResponseModel(String token, Context context) {
        this.token = token;
        this.request = request;
    }

    public String suggestionSearch(String token2, String request) {
        String url = "https://search.healthwise.net/v1/suggestions?q=" + request +
                "&fq=types%3A(HWCV_10000+HWCV_10002+HWCV_10003)" +
                "&content=content%3D(article+topic)&top=2";
        //String url = "https://search.healthwise.net/v1/search?q=diabetes&lang=en-us";

        OkHttpClient client = new OkHttpClient();
        Request newRequest = new Request.Builder()
                .url(url)
                .addHeader("Authorization", "Bearer " + token2)
                .build();

        Log.d(TAG, "Request Build successful");

        try {
            Response response = client.newCall(newRequest).execute();

            final Gson gson = new Gson();

            suggestions = gson.fromJson(response.body().charStream(), Suggestions.class);

            response.close();

            List labels = suggestions.getItems();

            if (!labels.isEmpty()) {
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
            } else {
                reply = "I'm sorry. Information on this topic is not available. Please press the button and choose another topic";
                replyOk = false;
            }

            Log.d(TAG, "Got the response");
        } catch (IOException e) {
            Log.e(TAG, "Exception while doing request", e);
        }

        return reply;
    }
}
