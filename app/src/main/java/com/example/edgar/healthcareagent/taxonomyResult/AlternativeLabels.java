package com.example.edgar.healthcareagent.taxonomyResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class AlternativeLabels {

    private List<String> synonyms = new ArrayList<String>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The synonyms
     */
    public List<String> getSynonyms() {
        return synonyms;
    }

    /**
     *
     * @param synonyms
     * The synonyms
     */
    public void setSynonyms(List<String> synonyms) {
        this.synonyms = synonyms;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}