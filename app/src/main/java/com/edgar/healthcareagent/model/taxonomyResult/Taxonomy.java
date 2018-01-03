package com.edgar.healthcareagent.model.taxonomyResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Taxonomy {

    private List<Child> children = new ArrayList<Child>();
    private List<Parent> parents = new ArrayList<Parent>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
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
                "children=" + children +
                ", parents=" + parents +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
