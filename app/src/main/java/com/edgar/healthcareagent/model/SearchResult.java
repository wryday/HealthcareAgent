package com.edgar.healthcareagent.model;

import com.edgar.healthcareagent.searchResult.Concept;
import com.edgar.healthcareagent.searchResult.Item;
import com.edgar.healthcareagent.searchResult.Links;

import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class SearchResult {

    private Integer status;
    private Links links;
    private String schema;
    private List<Item> items;
    private Pagination pagination;
    private List<Concept> concepts;
    private Map<String, Object> additionalProperties;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<Concept> getConcepts() {
        return concepts;
    }

    public void setConcepts(List<Concept> concepts) {
        this.concepts = concepts;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "SearchResult{" +
                "status=" + status +
                ", links=" + links +
                ", schema='" + schema + '\'' +
                ", items=" + items +
                ", pagination=" + pagination +
                ", concepts=" + concepts +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
