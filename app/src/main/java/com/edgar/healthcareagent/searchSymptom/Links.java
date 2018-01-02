package com.edgar.healthcareagent.searchSymptom;

/**
 * Created by Edgar on 3/27/2017.
 */

import java.util.HashMap;
import java.util.Map;

public class Links {

    private String self;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}