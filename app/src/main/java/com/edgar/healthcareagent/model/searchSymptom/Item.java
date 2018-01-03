package com.edgar.healthcareagent.model.searchSymptom;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Item {

    private String id;
    private String href;
    private List<String> languages = null;
    private Map<String, Object> additionalProperties = new HashMap<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", href='" + href + '\'' +
                ", languages=" + languages +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
