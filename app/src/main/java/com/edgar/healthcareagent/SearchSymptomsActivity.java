package com.edgar.healthcareagent;

import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

import static com.edgar.healthcareagent.GetApiAiTopicActivity.ApiAiChoice;

public class SearchSymptomsActivity extends AppCompatActivity {

    String id;

    private Context context;
    private String authToken;
    private Button speakButton3;
    private TextToSpeechModel tt1;

    SearchSymptomsModel searchSymptomsModel = new SearchSymptomsModel();

    public SearchSymptomsActivity() throws JSONException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        speakButton3 = findViewById(R.id.speakButton3);

        DatabaseHelper myDbHelper = new DatabaseHelper(this);

        tt1 = new TextToSpeechModel(this);

        try {
            myDbHelper.createDatabase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }

        try {
            myDbHelper.openDatabase();
        } catch (SQLException sqle) {
            throw sqle;
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
            conditionListReply = "I'm sorry. " +
                    "Data on this topic is not available." +
                    " Please choose another topic";
        }
        tt1.speakOut("I really do work");

        Intent goBackToTheBeginning = new Intent(getBaseContext(), GetApiAiTopicActivity.class);
        startActivity(goBackToTheBeginning);
    }

    public void speakButtonOnClick3(final View view) {
    }
}
