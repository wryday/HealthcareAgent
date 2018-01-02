package com.edgar.healthcareagent.taxonomyResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Relationship {

    private String id;
    private String label;
    private List<RelatedConcept> relatedConcepts = new ArrayList<RelatedConcept>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    public List<RelatedConcept> getRelatedConcepts() {
        return relatedConcepts;
    }

    public void setRelatedConcepts(List<RelatedConcept> relatedConcepts) {
        this.relatedConcepts = relatedConcepts;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Relationship{" +
                "id='" + id + '\'' +
                ", label='" + label + '\'' +
                ", relatedConcepts=" + relatedConcepts +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
