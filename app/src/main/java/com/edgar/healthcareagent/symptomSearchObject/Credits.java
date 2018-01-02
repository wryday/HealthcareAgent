package com.edgar.healthcareagent.symptomSearchObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Credits {

    private Author author;
    private List<PrimaryReviewer> primaryReviewers = null;
    private List<SecondaryReviewer> secondaryReviewers = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<PrimaryReviewer> getPrimaryReviewers() {
        return primaryReviewers;
    }

    public void setPrimaryReviewers(List<PrimaryReviewer> primaryReviewers) {
        this.primaryReviewers = primaryReviewers;
    }

    public List<SecondaryReviewer> getSecondaryReviewers() {
        return secondaryReviewers;
    }

    public void setSecondaryReviewers(List<SecondaryReviewer> secondaryReviewers) {
        this.secondaryReviewers = secondaryReviewers;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}