package com.example.edgar.healthcareagent.symptomSearchObject;

import java.util.HashMap;
import java.util.Map;

public class Localizations {

    private String enUs;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getEnUs() {
        return enUs;
    }

    public void setEnUs(String enUs) {
        this.enUs = enUs;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}