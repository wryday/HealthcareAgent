package com.example.edgar.healthcareagent.searchResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class SearchResult {

    private Integer status;
    private Links links;
    private String schema;
    private List<Item> items = new ArrayList<Item>();
    private Pagination pagination;
    private List<Concept> concepts = new ArrayList<Concept>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     *
     * @return
     * The links
     */
    public Links getLinks() {
        return links;
    }

    /**
     *
     * @param links
     * The links
     */
    public void setLinks(Links links) {
        this.links = links;
    }

    /**
     *
     * @return
     * The schema
     */
    public String getSchema() {
        return schema;
    }

    /**
     *
     * @param schema
     * The schema
     */
    public void setSchema(String schema) {
        this.schema = schema;
    }

    /**
     *
     * @return
     * The items
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     *
     * @param items
     * The items
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

    /**
     *
     * @return
     * The pagination
     */
    public Pagination getPagination() {
        return pagination;
    }

    /**
     *
     * @param pagination
     * The pagination
     */
    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    /**
     *
     * @return
     * The concepts
     */
    public List<Concept> getConcepts() {
        return concepts;
    }

    /**
     *
     * @param concepts
     * The concepts
     */
    public void setConcepts(List<Concept> concepts) {
        this.concepts = concepts;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}