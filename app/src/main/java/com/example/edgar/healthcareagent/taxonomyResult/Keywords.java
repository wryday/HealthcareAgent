package com.example.edgar.healthcareagent.taxonomyResult;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Keywords {

    private En en;
    private Es es;
    private Fr fr;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The en
     */
    public En getEn() {
        return en;
    }

    /**
     *
     * @param en
     * The en
     */
    public void setEn(En en) {
        this.en = en;
    }

    /**
     *
     * @return
     * The es
     */
    public Es getEs() {
        return es;
    }

    /**
     *
     * @param es
     * The es
     */
    public void setEs(Es es) {
        this.es = es;
    }

    /**
     *
     * @return
     * The fr
     */
    public Fr getFr() {
        return fr;
    }

    /**
     *
     * @param fr
     * The fr
     */
    public void setFr(Fr fr) {
        this.fr = fr;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}