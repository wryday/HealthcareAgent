package com.example.edgar.healthcareagent.suggestions;

/**
 * Created by Edgar on 11/15/2016.
 */

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

/**
 * Created by Edgar on 11/11/2016.
 */
/*public class Suggestions {

    @SerializedName("status")
    public int status;

    @SerializedName("links")
    public List<String> links;
    public String self;

    @SerializedName("schema")
    public String schema;

    @SerializedName("items")
    public List<item> items;

    public Suggestions(){

    }
}*/

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "status",
        "links",
        "schema",
        "items"
})
public class Suggestions {

    @JsonProperty("status")
    private Integer status;
    @JsonProperty("links")
    private Links links;
    @JsonProperty("schema")
    private String schema;
    @JsonProperty("items")
    private List<Item> items = new ArrayList<Item>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The status
     */
    @JsonProperty("status")
    public Integer getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    @JsonProperty("status")
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     *
     * @return
     * The links
     */
    @JsonProperty("links")
    public Links getLinks() {
        return links;
    }

    /**
     *
     * @param links
     * The links
     */
    @JsonProperty("links")
    public void setLinks(Links links) {
        this.links = links;
    }

    /**
     *
     * @return
     * The schema
     */
    @JsonProperty("schema")
    public String getSchema() {
        return schema;
    }

    /**
     *
     * @param schema
     * The schema
     */
    @JsonProperty("schema")
    public void setSchema(String schema) {
        this.schema = schema;
    }

    /**
     *
     * @return
     * The items
     */
    @JsonProperty("items")
    public List<Item> getItems() {
        return items;
    }

    /**
     *
     * @param items
     * The items
     */
    @JsonProperty("items")
    public void setItems(List<Item> items) {
        this.items = items;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

