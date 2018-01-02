package com.example.edgar.healthcareagent;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.gson.JsonElement;

import org.json.JSONException;

import java.util.Map;

import ai.api.AIConfiguration;
import ai.api.AIListener;
import ai.api.AIService;
import ai.api.model.AIError;
import ai.api.model.AIResponse;
import ai.api.model.Result;

import static android.os.Build.VERSION_CODES.KITKAT;
import static com.example.edgar.healthcareagent.GetAPIAITopicActivity.APIAIrequest;

/**
 * Created by Edgar on 11/20/2016.
 */

public class GetSuggestionsActivity extends AppCompatActivity implements AIListener {
    private String AIAccessCode = "330c83acba834b0f8d904734f56df684";
    private Button speakButton2;
    private AIService aiService;
    public static String token;
    private String suggestion_list;
    public static String request;
    public static String APIAIchoice;
    public static boolean replyOk = true;
    public SuggestionAndResponseModel suggestionAndResponse =
            new SuggestionAndResponseModel(token, this);
    Intent i;
    private TextToSpeechModel tts;

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
                    suggestion_list = suggestionAndResponse.suggestionSearch(token, APIAIrequest);
                    /*this is the response from the bot with user's choice
                    This response will be taken to the search model where
                    we find the info about the topic through several searches*/
                    tts.speakOut(suggestion_list);
                    if(!replyOk){
                        i = new Intent(getBaseContext(), GetAPIAITopicActivity.class);
                        startActivity(i);
                    }
                }
                catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
    //Right here is where I've pressed the button again and made my choice
    public void onResult(final AIResponse response2) {
        Result result = response2.getResult();

        // Get my choice back to send to the search activity
        String parameterString = "";
        if (result.getParameters() != null && !result.getParameters().isEmpty()) {
            for (final Map.Entry<String, JsonElement> entry : result.getParameters().entrySet()) {
                parameterString += "(" + entry.getKey() + ", " + entry.getValue() + ") ";
            }
        }
        else{

        }
        APIAIrequest = result.getResolvedQuery();//this is the condition I've finally chosen
        //This is APIAIrequest with '+' separating words for the url
        APIAIchoice = APIAIrequest.replace(' ', '+');
        if(!replyOk){
            i = new Intent(getBaseContext(), GetAPIAITopicActivity.class);
            startActivity(i);
        }else{
            i = new Intent(getBaseContext(), SearchActivity.class);
            startActivity(i);
        }
     }

    public void speakButtonOnClick2(final View view) {aiService.startListening();}

    @Override
    public void onError(AIError error) {
        tts.speakOut("I'm sorry I didn't get that. " +
                " Please press button and repeat your choice of topic");
        i = new Intent(getBaseContext(), GetAPIAITopicActivity.class);
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
