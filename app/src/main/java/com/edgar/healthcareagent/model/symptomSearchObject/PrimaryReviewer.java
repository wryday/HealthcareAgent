package com.edgar.healthcareagent.model.symptomSearchObject;

import java.util.HashMap;
import java.util.Map;

public class PrimaryReviewer {

    private String name;
    private Map<String, Object> additionalProperties = new HashMap<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "PrimaryReviewer{" +
                "name='" + name + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
