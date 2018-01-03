
package com.edgar.healthcareagent.model.symptomSearchObject;

import java.util.HashMap;
import java.util.Map;

public class Concept {

    private String id;
    private String label;
    private Map<String, Object> additionalProperties = new HashMap<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Concept{" +
                "id='" + id + '\'' +
                ", label='" + label + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
