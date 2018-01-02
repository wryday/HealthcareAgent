package com.edgar.healthcareagent.contentResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Credits {

    private Author author;
    private List<PrimaryReviewer> primaryReviewers = null;
    private List<SecondaryReviewer> secondaryReviewers = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The author
     */
    public Author getAuthor() {
        return author;
    }

    /**
     *
     * @param author
     * The author
     */
    public void setAuthor(Author author) {
        this.author = author;
    }

    /**
     *
     * @return
     * The primaryReviewers
     */
    public List<PrimaryReviewer> getPrimaryReviewers() {
        return primaryReviewers;
    }

    /**
     *
     * @param primaryReviewers
     * The primaryReviewers
     */
    public void setPrimaryReviewers(List<PrimaryReviewer> primaryReviewers) {
        this.primaryReviewers = primaryReviewers;
    }

    /**
     *
     * @return
     * The secondaryReviewers
     */
    public List<SecondaryReviewer> getSecondaryReviewers() {
        return secondaryReviewers;
    }

    /**
     *
     * @param secondaryReviewers
     * The secondaryReviewers
     */
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