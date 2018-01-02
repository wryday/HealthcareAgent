package com.example.edgar.healthcareagent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.JsonElement;

import java.util.Map;

import ai.api.AIConfiguration;
import ai.api.AIListener;
import ai.api.AIService;
import ai.api.model.AIError;
import ai.api.model.AIResponse;
import ai.api.model.Result;

public class GetAPIAITopicActivity extends AppCompatActivity implements AIListener{
    private String AIAccessCode = "330c83acba834b0f8d904734f56df684";
    private Button speakButton;
    private TextView intro_text;
    private AIService aiService;
    private String token = "";
    public static String APIAIrequest;
    public static String APIAIchoice;
    public static String reply = "The suggested list of topics are ";
    AIBot aiBot;
    private TextToSpeechModel tts;
    //TokenRequest tokenRequest = new TokenRequest();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getapiait);
        //AI Chat Bot Setup
       final AIConfiguration config = new AIConfiguration(AIAccessCode,
                AIConfiguration.SupportedLanguages.English,
                AIConfiguration.RecognitionEngine.System);
        aiService = AIService.getService(this, config);
        aiService.setListener(this);
        tts = new TextToSpeechModel(this);
        aiBot = new AIBot(this);

        intro_text = (TextView) findViewById(R.id.intro_text);
        speakButton = (Button) findViewById(R.id.speakButton);
        String intro = "WELCOME TO THE HEALTHCARE AGENT APP \n" +
                "PLEASE PRESS BUTTON AND MAKE YOUR REQUEST";
        intro_text.setText(intro);
        //resultTextView = (TextView) findViewById(R.id.resultTextView);
        //resultScrollView = (ScrollView) findViewById((R.id.resultScrollView));
        //String APIAIrequest = aiBot.APIAIrequest;
    }
    public void speakButtonOnClick(final View view) {
        aiService.startListening();
    }

   public void onResult(final AIResponse response) {
        Result result = response.getResult();
       Log.d("HEALTHCARE", "have result");
        // Get parameters
        String parameterString = "";
        if (result.getParameters() != null && !result.getParameters().isEmpty()) {
            for (final Map.Entry<String, JsonElement> entry : result.getParameters().entrySet()) {
                parameterString += "(" + entry.getKey() + ", " + entry.getValue() + ") ";
            }
        }
       else{

        }
        // Show results in TextView for debugging.
       //resultTextView.setMovementMethod(new ScrollingMovementMethod());

       APIAIchoice = result.getFulfillment().getSpeech();
       APIAIrequest = APIAIchoice.replace(' ', '+');//adds '+' for REST query

       Intent i = new Intent(getBaseContext(), SearchActivity.class);
       startActivity(i);
   }

    @Override
    public void onError(final AIError error) {
        Log.d("HEALTHCARE", "Didn't detect speech");
        tts.speakOut("I'm sorry.  I didn't get that. Please press button" +
                "again and repeat the topic.");
        Intent i = new Intent(getBaseContext(), GetAPIAITopicActivity.class);
        startActivity(i);
        String err = error.toString();
    }

    @Override
    public void onListeningStarted(){

        Log.d("HEALTHCARE", "listening started!");

    }

    @Override
    public void onListeningCanceled() {
        Log.d("HEALTHCARE", "listening cancelled!");
    }

    @Override
    public void onListeningFinished() {
        Log.d("HEALTHCARE", "listening finished");

    }

    @Override
    public void onAudioLevel(final float level) {
    }



}
