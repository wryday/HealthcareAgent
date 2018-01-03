package com.edgar.healthcareagent.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.edgar.healthcareagent.R;
import com.edgar.healthcareagent.SuggestionAndResponseModel;
import com.edgar.healthcareagent.TokenRequest;
import com.edgar.healthcareagent.model.TextToSpeechModel;
import com.google.gson.JsonElement;

import java.util.Map;

import ai.api.AIListener;
import ai.api.android.AIConfiguration;
import ai.api.android.AIService;
import ai.api.model.AIError;
import ai.api.model.AIResponse;
import ai.api.model.Result;

import static android.os.Build.VERSION_CODES.KITKAT;
import static com.edgar.healthcareagent.ui.GetTopicActivity.ApiAiRequest;

public class GetSuggestionsActivity extends AppCompatActivity implements AIListener {
    private static final String TAG = GetSuggestionsActivity.class.getSimpleName();

    public static boolean replyOk = true;

    public static String token;
    public static String request;
    public static String APIAIchoice;

    private AIService aiService;
    private String suggestion_list;

    public SuggestionAndResponseModel suggestionAndResponse =
            new SuggestionAndResponseModel(token, this);

    private TextToSpeechModel tts;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_suggestions);

        tts = new TextToSpeechModel(this);

        final AIConfiguration config = new AIConfiguration(
                getString(R.string.ai_client_access_token),
                AIConfiguration.SupportedLanguages.English,
                AIConfiguration.RecognitionEngine.System);

        aiService = AIService.getService(this, config);
        aiService.setListener(this);

        final TokenRequest tokenRequest = new TokenRequest();

        Button suggestionsButton = findViewById(R.id.button_suggestions);
        suggestionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aiService.startListening();
            }
        });

        //Get the access token and the suggestions from HW API
        //ASYNCHRONOUSLY!!!

        new Thread(new Runnable() {
            @RequiresApi(api = KITKAT)
            @Override
            public void run() {
                token = tokenRequest.getToken();

                suggestion_list = suggestionAndResponse.suggestionSearch(token, ApiAiRequest);

                tts.speakOut(suggestion_list);

                if (!replyOk) {
                    Intent intent = new Intent(getBaseContext(), GetTopicActivity.class);
                    startActivity(intent);
                }
            }
        }).start();
    }

    @Override
    public void onResult(AIResponse result) {
        //Right here is where I've pressed the button again and made my choice
        Result responseResult = result.getResult();

        // Get my choice back to send to the search activity
        StringBuilder parameterString = new StringBuilder();

        if (responseResult.getParameters() != null && !responseResult.getParameters().isEmpty()) {
            for (final Map.Entry<String, JsonElement> entry : responseResult.getParameters().entrySet()) {
                parameterString
                        .append("(")
                        .append(entry.getKey())
                        .append(", ")
                        .append(entry.getValue())
                        .append(") ");
            }
        } else {
            Log.e(TAG, "result parameters were null or empty");
        }

        Toast.makeText(this, "Parameters: " + parameterString.toString(), Toast.LENGTH_SHORT).show();

        //this is the condition I've finally chosen
        ApiAiRequest = responseResult.getResolvedQuery();

        //This is ApiAiRequest with '+' separating words for the url
        APIAIchoice = ApiAiRequest.replace(' ', '+');

        Intent intent = new Intent(getBaseContext(),
                replyOk
                        ? SearchActivity.class
                        : GetTopicActivity.class);
        startActivity(intent);
    }

    @Override
    public void onError(AIError error) {
        tts.speakOut("I'm sorry I didn't get that. Please press button and repeat your request.");
    }

    @Override
    public void onAudioLevel(float level) {
        Log.v(TAG, "onAudioLevel");
    }

    @Override
    public void onListeningStarted() {
        Log.v(TAG, "onListeningStarted");
    }

    @Override
    public void onListeningCanceled() {
        Log.v(TAG, "onListeningCanceled");
    }

    @Override
    public void onListeningFinished() {
        Log.v(TAG, "onListeningFinished");
    }
}
