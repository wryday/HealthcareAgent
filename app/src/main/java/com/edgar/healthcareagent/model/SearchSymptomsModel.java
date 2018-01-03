package com.edgar.healthcareagent.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import static com.edgar.healthcareagent.util.SuggestionAndResponseModel.reply;

public class SearchSymptomsModel {

    private String request;
    private String concept;
    private Context context;
    private String choice = reply; //import reply from suggestions search
    private List<String> conditionsThatMatchSymptoms = new ArrayList<>();

    public SearchSymptomsModel() {
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public List<String> getConditionsThatMatchSymptoms() {
        return conditionsThatMatchSymptoms;
    }

    public void setConditionsThatMatchSymptoms(List<String> conditionsThatMatchSymptoms) {
        this.conditionsThatMatchSymptoms = conditionsThatMatchSymptoms;
    }

    @Override
    public String toString() {
        return "SearchSymptomsModel{" +
                "request='" + request + '\'' +
                ", concept='" + concept + '\'' +
                ", context=" + context +
                ", choice='" + choice + '\'' +
                ", conditionsThatMatchSymptoms=" + conditionsThatMatchSymptoms +
                '}';
    }
}
