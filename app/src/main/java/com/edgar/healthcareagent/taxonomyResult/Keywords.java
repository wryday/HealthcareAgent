package com.edgar.healthcareagent.taxonomyResult;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Keywords {

    private En en;
    private Es es;
    private Fr fr;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public En getEn() {
        return en;
    }

    public void setEn(En en) {
        this.en = en;
    }

    public Es getEs() {
        return es;
    }

    public void setEs(Es es) {
        this.es = es;
    }

    public Fr getFr() {
        return fr;
    }

    public void setFr(Fr fr) {
        this.fr = fr;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Keywords{" +
                "en=" + en +
                ", es=" + es +
                ", fr=" + fr +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
