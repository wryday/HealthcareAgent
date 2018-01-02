package com.edgar.healthcareagent.searchSymptom;

import java.util.HashMap;
import java.util.Map;

public class Versioning {

    private String xHWVersion;
    private Map<String, Object> additionalProperties = new HashMap<>();

    public String getXHWVersion() {
        return xHWVersion;
    }

    public void setXHWVersion(String xHWVersion) {
        this.xHWVersion = xHWVersion;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Versioning{" +
                "xHWVersion='" + xHWVersion + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
