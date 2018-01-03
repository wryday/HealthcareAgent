package com.edgar.healthcareagent.model.taxonomyResult;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class CodeSystems {

    private Icd10cm icd10cm;
    private Icd9cm icd9cm;
    private Snomedct snomedct;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Icd10cm getIcd10cm() {
        return icd10cm;
    }

    public void setIcd10cm(Icd10cm icd10cm) {
        this.icd10cm = icd10cm;
    }

    public Icd9cm getIcd9cm() {
        return icd9cm;
    }

    public void setIcd9cm(Icd9cm icd9cm) {
        this.icd9cm = icd9cm;
    }

    public Snomedct getSnomedct() {
        return snomedct;
    }

    public void setSnomedct(Snomedct snomedct) {
        this.snomedct = snomedct;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "CodeSystems{" +
                "icd10cm=" + icd10cm +
                ", icd9cm=" + icd9cm +
                ", snomedct=" + snomedct +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
