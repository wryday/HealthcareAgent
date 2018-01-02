package com.example.edgar.healthcareagent.taxonomyResult;

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

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The label
     */
    public String getLabel() {
        return label;
    }

    /**
     *
     * @param label
     * The label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     *
     * @return
     * The relatedConcepts
     */
    public List<RelatedConcept> getRelatedConcepts() {
        return relatedConcepts;
    }

    /**
     *
     * @param relatedConcepts
     * The relatedConcepts
     */
    public void setRelatedConcepts(List<RelatedConcept> relatedConcepts) {
        this.relatedConcepts = relatedConcepts;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}