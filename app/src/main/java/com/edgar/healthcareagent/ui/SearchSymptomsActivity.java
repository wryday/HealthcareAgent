package com.edgar.healthcareagent.ui;

import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.edgar.healthcareagent.util.DatabaseHelper;
import com.edgar.healthcareagent.R;
import com.edgar.healthcareagent.model.SearchSymptomsModel;
import com.edgar.healthcareagent.util.TextToSpeechModel;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

import static com.edgar.healthcareagent.ui.GetTopicActivity.ApiAiChoice;

public class SearchSymptomsActivity extends AppCompatActivity {
    private static final String TAG = SearchSymptomsActivity.class.getSimpleName();

    private String id;
    private String authToken;

    private Context context;
    private TextToSpeechModel tt1;

    SearchSymptomsModel searchSymptomsModel = new SearchSymptomsModel();

    public SearchSymptomsActivity() throws JSONException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptom_search);

        Button symptomSearchButton = findViewById(R.id.button_symptom_search);
        symptomSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SearchSymptomsActivity.this, "Search Symptoms Button clicked", Toast.LENGTH_SHORT).show();
            }
        });

        DatabaseHelper myDbHelper = new DatabaseHelper(this);

        tt1 = new TextToSpeechModel(this);

        try {
            myDbHelper.createDatabase();
        } catch (IOException e) {
            Log.e(TAG, "Unable to create database", e);
            finish();
            return;
        }

        try {
            myDbHelper.openDatabase();
        } catch (SQLException e) {
            Log.e(TAG, "SQLException in Search Symptoms Activity openDatabase call", e);
            finish();
            return;
        }

        //Query the symptomstoconditions database to get the related condition(s)
        List<String> conditionsFromSymptom = myDbHelper.getConditionList(ApiAiChoice);
        String conditionListReply = "";

        if (!conditionsFromSymptom.isEmpty()) {
            conditionListReply = "The suggested list of topics based on the " +
                    "symptom " + ApiAiChoice + "is ";

            for (int i = 0; i < conditionsFromSymptom.size(); i++) {
                conditionListReply += conditionsFromSymptom.get(i) + ", ";
                if (i == conditionsFromSymptom.size() - 2) {
                    conditionListReply += " and ";
                }
            }

            conditionListReply += ". Please choose from the list of topics.";
        } else {
            conditionListReply = "I'm sorry. Data on this topic is not available. Please choose another topic.";
        }

        tt1.speakOut("I really do work");

        Intent getTopicIntent = new Intent(getBaseContext(), GetTopicActivity.class);
        startActivity(getTopicIntent);
    }
}
