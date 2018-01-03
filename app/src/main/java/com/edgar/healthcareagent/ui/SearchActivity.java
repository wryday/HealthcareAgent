package com.edgar.healthcareagent.ui;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.edgar.healthcareagent.DatabaseHelper;
import com.edgar.healthcareagent.R;
import com.edgar.healthcareagent.model.SearchModel;
import com.edgar.healthcareagent.model.TextToSpeechModel;
import com.edgar.healthcareagent.TokenRequest;

import org.json.JSONException;

public class SearchActivity extends AppCompatActivity {
    private static final String TAG = SearchActivity.class.getSimpleName();

    private String authToken;

    private SearchModel searchModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Button searchButton = findViewById(R.id.button_search);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        final TextToSpeechModel tts = new TextToSpeechModel(this);
        final DatabaseHelper myDbHelper = new DatabaseHelper(this);

        try {
            searchModel = new SearchModel();
        } catch (JSONException e) {
            Log.e(TAG, "JSONException instantiating search model");
            Toast.makeText(this, "Error creating search model", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

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
                    Log.e(TAG, "JSONException in thread", e);
                }
            }
        }).start();
    }
}
