package com.example.edgar.healthcareagent.symptomSearchObject;

import java.util.HashMap;
import java.util.Map;

public class Title {

    private String consumer;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}