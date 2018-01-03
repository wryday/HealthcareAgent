package com.edgar.healthcareagent.model.taxonomyResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Icd9cm {

    private List<String> r1 = new ArrayList<String>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<String> getR1() {
        return r1;
    }

    public void setR1(List<String> r1) {
        this.r1 = r1;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Icd9cm{" +
                "r1=" + r1 +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
