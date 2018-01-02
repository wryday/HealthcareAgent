package com.edgar.healthcareagent.symptomSearchObject;

import java.util.HashMap;
import java.util.Map;

public class Taxonomy {

    private Aspect aspect;
    private Concept concept;
    private Map<String, Object> additionalProperties = new HashMap<>();

    public Aspect getAspect() {
        return aspect;
    }

    public void setAspect(Aspect aspect) {
        this.aspect = aspect;
    }

    public Concept getConcept() {
        return concept;
    }

    public void setConcept(Concept concept) {
        this.concept = concept;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Taxonomy{" +
                "aspect=" + aspect +
                ", concept=" + concept +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
