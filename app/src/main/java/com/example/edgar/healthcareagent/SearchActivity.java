package com.example.edgar.healthcareagent;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import org.json.JSONException;
public class SearchActivity extends AppCompatActivity {
    private String authToken;
    private Button speakButton3;
    SearchModel searchModel = new SearchModel();

    public SearchActivity() throws JSONException {
    }
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        speakButton3 = (Button) findViewById(R.id.speakButton3);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        final TextToSpeechModel tts = new TextToSpeechModel(this);
        new Thread(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void run() {
                try {
                    TokenRequest tokenRequest = new TokenRequest();
                    authToken = tokenRequest.getToken();
                    String finalReply = searchModel.getFinalReply(authToken);
                    tts.speakOut(finalReply);
                }
                catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }).start();
        Intent i = new Intent(getBaseContext(), GetAPIAITopicActivity.class);
        startActivity(i);
    }
    public void speakButtonOnClick3(final View view) {}

}

