package com.edgar.healthcareagent.searchSymptom;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchSymptom {

    private Integer status;
    private Versioning versioning;
    private Links links;
    private String schema;
    private List<Item> items = null;
    private Map<String, Object> additionalProperties = new HashMap<>();

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Versioning getVersioning() {
        return versioning;
    }

    public void setVersioning(Versioning versioning) {
        this.versioning = versioning;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "SearchSymptom{" +
                "status=" + status +
                ", versioning=" + versioning +
                ", links=" + links +
                ", schema='" + schema + '\'' +
                ", items=" + items +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
