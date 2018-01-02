package com.example.edgar.healthcareagent.searchSymptom;

/**
 * Created by Edgar on 3/27/2017.
 */

import java.util.HashMap;
import java.util.Map;

public class Versioning {

    private String xHWVersion;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

}