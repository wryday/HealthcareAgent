package com.edgar.healthcareagent.ui;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.edgar.healthcareagent.util.DatabaseHelper;
import com.edgar.healthcareagent.R;
import com.edgar.healthcareagent.util.TokenRequest;
import com.edgar.healthcareagent.util.SearchModel;
import com.edgar.healthcareagent.util.TextToSpeechModel;

public class SearchActivity extends AppCompatActivity {
    private static final String TAG = SearchActivity.class.getSimpleName();

    private String authToken;

    private String query;

    private SearchModel searchModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        if (getIntent().getExtras() != null) {
            query = getIntent().getStringExtra("query");
        }

        Button searchButton = findViewById(R.id.button_search);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        final TextToSpeechModel tts = new TextToSpeechModel(this);
        final DatabaseHelper myDbHelper = new DatabaseHelper(this);

        searchModel = new SearchModel();

        new Thread(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void run() {
                TokenRequest tokenRequest = new TokenRequest();
                authToken = tokenRequest.getToken();
                String finalReply = searchModel.getReply(authToken, myDbHelper, query);
                   /*if(finalReply.equals("I'm sorry.  " +
                            "Data on this topic is not available" +
                            "Please choose another topic")){
                        finalReply = "";
                        Intent proceedWithSymptomSearch = new Intent(getBaseContext(),
                                SearchSymptomsActivity.class);
                        startActivity(proceedWithSymptomSearch);
                    }*/

                tts.speakOut(finalReply);
            }
        }).start();
    }
}
