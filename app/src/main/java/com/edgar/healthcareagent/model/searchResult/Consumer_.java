package com.edgar.healthcareagent.model.searchResult;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Consumer_ {

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

    @Override
    public String toString() {
        return "Consumer_{" +
                "enUs='" + enUs + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
