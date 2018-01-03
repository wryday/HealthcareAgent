package com.edgar.healthcareagent.ui;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.edgar.healthcareagent.AiBot;
import com.edgar.healthcareagent.R;
import com.edgar.healthcareagent.model.TextToSpeechModel;
import com.google.gson.JsonElement;

import java.util.Map;

import ai.api.AIListener;
import ai.api.android.AIConfiguration;
import ai.api.android.AIService;
import ai.api.model.AIError;
import ai.api.model.AIResponse;
import ai.api.model.Result;

public class GetTopicActivity extends AppCompatActivity implements AIListener {
    private static final String TAG = GetTopicActivity.class.getSimpleName();

    private static final int PERMISSIONS_REQUEST_RECORD_AUDIO = 1414;

    public static String ApiAiRequest;
    public static String ApiAiChoice;

    public static String reply = "The suggested list of topics are ";

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
        final AIConfiguration config = new AIConfiguration(
                getString(R.string.ai_client_access_token),
                AIConfiguration.SupportedLanguages.English,
                AIConfiguration.RecognitionEngine.System);

        aiService = AIService.getService(this, config);
        aiService.setListener(this);
        tts = new TextToSpeechModel(this);
        aiBot = new AiBot(this);

        Button mSpeechDetectButton = findViewById(R.id.speak_button);
        mSpeechDetectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int permissionCheck = ContextCompat.checkSelfPermission(
                        GetTopicActivity.this,
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
        Toast.makeText(this, "Error: " + error.getMessage(), Toast.LENGTH_LONG).show();
        tts.speakOut(getString(R.string.speak_detect_error));
    }

    @Override
    public void onListeningStarted() {
        Log.v(TAG, "listening started");
    }

    @Override
    public void onListeningCanceled() {
        Log.v(TAG, "listening canceled");
    }

    @Override
    public void onListeningFinished() {
        Log.v(TAG, "listening finished");
    }

    @Override
    public void onAudioLevel(final float level) {
    }

    private void listenForTopic() {
        aiService.startListening();
    }

    private void requestPermission() {
        Log.i(TAG, "Requesting RECORD_AUDIO permission");

        if ((ActivityCompat.shouldShowRequestPermissionRationale(
                this,
                Manifest.permission.RECORD_AUDIO))) {
            showRecordAudioRationale();
        } else {
            requestRecordAudioPermission();
        }
    }

    private void showRecordAudioRationale() {
        new AlertDialog.Builder(this)
                .setTitle("Permission Needed")
                .setMessage("This app requires permission to record audio in order to function")
                .setNegativeButton("No Thanks", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        showNeedsPermissionToast();
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("Sure", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        requestRecordAudioPermission();
                        dialog.dismiss();
                    }
                })
                .show();
    }

    private void requestRecordAudioPermission() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.RECORD_AUDIO},
                PERMISSIONS_REQUEST_RECORD_AUDIO);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSIONS_REQUEST_RECORD_AUDIO:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    listenForTopic();
                } else {
                    showNeedsPermissionToast();
                }

                return;
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void showNeedsPermissionToast() {
        Toast.makeText(
                this,
                "RECORD_AUDIO permission required for speech requests",
                Toast.LENGTH_SHORT)
                .show();
    }
}
