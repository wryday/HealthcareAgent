package com.edgar.healthcareagent;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import static com.edgar.healthcareagent.SuggestionAndResponseModel.reply;

/**
 * Created by Edgar on 11/20/2016.
 */

public class SearchSymptomsModel extends AppCompatActivity  {

    private String request;
    private String concept;
    private Context context;
    String choice = reply; //import reply from suggestions search
    SearchSymptomsModel() throws JSONException {}
    public List<String> conditionsThatMatchSymptoms = new ArrayList<>();

    public List<String> getConditionList(String token, String symptom) throws JSONException {
        return null;
    }

}

