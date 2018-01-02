package com.edgar.healthcareagent;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import org.json.JSONException;

public class SearchActivity extends AppCompatActivity {

    String id;

    private String authToken;
    private Button speakButton3;

    SearchModel searchModel = new SearchModel();

    public SearchActivity() throws JSONException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        speakButton3 = findViewById(R.id.speakButton3);

        final TextToSpeechModel tts = new TextToSpeechModel(this);
        final DatabaseHelper myDbHelper = new DatabaseHelper(this);

        new Thread(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void run() {
                try {
                    TokenRequest tokenRequest = new TokenRequest();
                    authToken = tokenRequest.getToken();
                    String finalReply = searchModel.getReply(authToken, myDbHelper);
                   /*if(finalReply.equals("I'm sorry.  " +
                            "Data on this topic is not available" +
                            "Please choose another topic")){
                        finalReply = "";
                        Intent proceedWithSymptomSearch = new Intent(getBaseContext(),
                                SearchSymptomsActivity.class);
                        startActivity(proceedWithSymptomSearch);
                    }*/

                    tts.speakOut(finalReply);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Intent intent = new Intent(getBaseContext(), GetApiAiTopicActivity.class);
        //tts.onDestroy();
        startActivity(intent);
    }

    public void speakButtonOnClick3(final View view) {
    }
}
