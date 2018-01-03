package com.edgar.healthcareagent.model;

import com.edgar.healthcareagent.contentResult.PrimaryReviewer;
import com.edgar.healthcareagent.contentResult.SecondaryReviewer;
import com.edgar.healthcareagent.model.Author;

import java.util.List;
import java.util.Map;

public class Credits {

    private Author author;
    private List<PrimaryReviewer> primaryReviewers;
    private List<SecondaryReviewer> secondaryReviewers;
    private Map<String, Object> additionalProperties;

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
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    @Override
    public String toString() {
        return "Credits{" +
                "author=" + author +
                ", primaryReviewers=" + primaryReviewers +
                ", secondaryReviewers=" + secondaryReviewers +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
