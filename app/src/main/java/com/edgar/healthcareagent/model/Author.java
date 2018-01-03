package com.edgar.healthcareagent.model;

import java.util.Map;

public class Author {

    private String name;
    private Map<String, Object> additionalProperties;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}