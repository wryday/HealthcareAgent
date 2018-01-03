package com.edgar.healthcareagent.model;

import com.edgar.healthcareagent.searchResult.Consumer;

import java.util.Map;

public class Title {

    private Consumer consumer;
    private Map<String, Object> additionalProperties;

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    @Override
    public String toString() {
        return "Title{" +
                "consumer=" + consumer +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
