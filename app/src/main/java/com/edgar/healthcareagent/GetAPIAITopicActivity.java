package com.edgar.healthcareagent;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonElement;

import java.util.Map;

import ai.api.AIListener;
import ai.api.android.AIConfiguration;
import ai.api.android.AIService;
import ai.api.model.AIError;
import ai.api.model.AIResponse;
import ai.api.model.Result;

public class GetApiAiTopicActivity extends AppCompatActivity implements AIListener {
    private static final String TAG = GetApiAiTopicActivity.class.getSimpleName();

    private static final String AI_ACCESS_CODE = "330c83acba834b0f8d904734f56df684";

    public static String ApiAiRequest;
    public static String ApiAiChoice;

    public static String reply = "The suggested list of topics are ";

    private Button mSpeechDetectButton;
    private TextView mIntroTextView;

    private AIService aiService;

    private String token = "";

    private TextToSpeechModel tts;

    //TokenRequest tokenRequest = new TokenRequest();
    AiBot aiBot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_topic);

        //AI Chat Bot Setup
        final AIConfiguration config = new AIConfiguration(AI_ACCESS_CODE,
                AIConfiguration.SupportedLanguages.English,
                AIConfiguration.RecognitionEngine.System);

        aiService = AIService.getService(this, config);
        aiService.setListener(this);
        tts = new TextToSpeechModel(this);
        aiBot = new AiBot(this);

        mIntroTextView = findViewById(R.id.intro_text);

        mSpeechDetectButton = findViewById(R.id.speak_button);
        mSpeechDetectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int permissionCheck = ContextCompat.checkSelfPermission(
                        GetApiAiTopicActivity.this,
                        Manifest.permission.RECORD_AUDIO);

                if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
                    listenForTopic();
                } else {
                    requestPermission();
                }
            }
        });


        //resultTextView = (TextView) findViewById(R.id.resultTextView);
        //resultScrollView = (ScrollView) findViewById((R.id.resultScrollView));
        //String ApiAiRequest = aiBot.ApiAiRequest;
    }

    @Override
    public void onResult(AIResponse result) {
        Log.i(TAG, "onResult");

        Result responseResult = result.getResult();

        // Get parameters
        String parameterString = "";

        if (responseResult.getParameters() != null && !responseResult.getParameters().isEmpty()) {
            for (final Map.Entry<String, JsonElement> entry : responseResult.getParameters().entrySet()) {
                parameterString += "(" + entry.getKey() + ", " + entry.getValue() + ") ";
            }
        } else {
            Log.e(TAG, "result parameters were null or empty");
        }

        // Show results in TextView for debugging.
        //resultTextView.setMovementMethod(new ScrollingMovementMethod());

        ApiAiChoice = responseResult.getFulfillment().getSpeech();
        ApiAiRequest = ApiAiChoice.replace(' ', '+');//adds '+' for REST query

        Intent intent = new Intent(getBaseContext(), SearchActivity.class);
        startActivity(intent);
    }

    @Override
    public void onError(AIError error) {
        Log.d(TAG, "Error detecting speech");

        tts.speakOut("I'm sorry.  I didn't get that. Please press button" +
                "again and repeat the topic.");

        String errorString = error.getMessage();

        Toast.makeText(this, "Error: " + errorString, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onListeningStarted() {
        Log.d(TAG, "listening started!");
    }

    @Override
    public void onListeningCanceled() {
        Log.d(TAG, "listening cancelled!");
    }

    @Override
    public void onListeningFinished() {
        Log.d(TAG, "listening finished");
    }

    @Override
    public void onAudioLevel(final float level) {
    }

    private void listenForTopic() {
        aiService.startListening();
    }

    private void requestPermission() {
        Log.i(TAG, "Requesting RECORD_AUDIO permission");

    }
}
