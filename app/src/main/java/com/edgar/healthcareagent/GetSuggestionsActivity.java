package com.edgar.healthcareagent;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.JsonElement;

import org.json.JSONException;

import java.util.Map;

import ai.api.AIListener;
import ai.api.android.AIConfiguration;
import ai.api.android.AIService;
import ai.api.model.AIError;
import ai.api.model.AIResponse;
import ai.api.model.Result;

import static android.os.Build.VERSION_CODES.KITKAT;
import static com.edgar.healthcareagent.GetApiAiTopicActivity.ApiAiRequest;

public class GetSuggestionsActivity extends AppCompatActivity implements AIListener {
    private static final String TAG = GetSuggestionsActivity.class.getSimpleName();

    public static String token;
    public static String request;
    public static String APIAIchoice;
    public static boolean replyOk = true;

    private String AIAccessCode = "330c83acba834b0f8d904734f56df684";
    private Button speakButton2;
    private AIService aiService;
    private String suggestion_list;
    public SuggestionAndResponseModel suggestionAndResponse =
            new SuggestionAndResponseModel(token, this);
    private TextToSpeechModel tts;

    Intent intent;

    public GetSuggestionsActivity() throws JSONException {
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tts = new TextToSpeechModel(this);
        setContentView(R.layout.activity_getsuggestions);
        final AIConfiguration config = new AIConfiguration(AIAccessCode,
                AIConfiguration.SupportedLanguages.English,
                AIConfiguration.RecognitionEngine.System);
        aiService = AIService.getService(this, config);
        aiService.setListener(this);
        final TokenRequest tokenRequest = new TokenRequest();
        speakButton2 = (Button) findViewById(R.id.speakButton2);

        //Get the access token and the suggestions from HW API
        //ASYNCHRONOUSLY!!!

        new Thread(new Runnable() {
            @RequiresApi(api = KITKAT)
            @Override
            public void run() {
                try {
                    token = tokenRequest.getToken();

                    //this is what the bot will say after suggestionSearch is done:
                    //"Which one will you choose?"
                    suggestion_list = suggestionAndResponse.suggestionSearch(token, ApiAiRequest);

                    /*this is the response from the bot with user's choice
                    This response will be taken to the search model where
                    we find the info about the topic through several searches*/
                    tts.speakOut(suggestion_list);

                    if (!replyOk) {
                        intent = new Intent(getBaseContext(), GetApiAiTopicActivity.class);
                        startActivity(intent);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    public void onResult(AIResponse result) {
        //Right here is where I've pressed the button again and made my choice
        Result responseResult = result.getResult();

        // Get my choice back to send to the search activity
        String parameterString = "";

        if (responseResult.getParameters() != null && !responseResult.getParameters().isEmpty()) {
            for (final Map.Entry<String, JsonElement> entry : responseResult.getParameters().entrySet()) {
                parameterString += "(" + entry.getKey() + ", " + entry.getValue() + ") ";
            }
        } else {
            Log.e(TAG, "result parameters were null or empty");
        }

        ApiAiRequest = responseResult.getResolvedQuery();//this is the condition I've finally chosen
        //This is ApiAiRequest with '+' separating words for the url
        APIAIchoice = ApiAiRequest.replace(' ', '+');

        if (!replyOk) {
            intent = new Intent(getBaseContext(), GetApiAiTopicActivity.class);
            startActivity(intent);
        } else {
            intent = new Intent(getBaseContext(), SearchActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onError(AIError error) {
        tts.speakOut("I'm sorry I didn't get that. " +
                " Please press button and repeat your choice of topic");
        intent = new Intent(getBaseContext(), GetApiAiTopicActivity.class);
    }

    public void speakButtonOnClick2(final View view) {
        aiService.startListening();
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
