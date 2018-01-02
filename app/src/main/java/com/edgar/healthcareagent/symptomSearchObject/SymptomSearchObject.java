package com.edgar.healthcareagent.symptomSearchObject;

import java.util.HashMap;
import java.util.Map;

public class SymptomSearchObject {

    private Integer status;
    private Versioning versioning;
    private Links links;
    private String schema;
    private Data data;
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

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "SymptomSearchObject{" +
                "status=" + status +
                ", versioning=" + versioning +
                ", links=" + links +
                ", schema='" + schema + '\'' +
                ", data=" + data +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
