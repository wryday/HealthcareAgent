package com.edgar.healthcareagent.suggestions;

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

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "id",
        "label",
        "types",
        "synonym"
})
public class Item {

    @JsonProperty("id")
    private String id;
    @JsonProperty("label")
    private String label;
    @JsonProperty("types")
    private List<Type> types = new ArrayList<Type>();
    @JsonProperty("synonym")
    private String synonym;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    @JsonProperty("label")
    public void setLabel(String label) {
        this.label = label;
    }

    @JsonProperty("types")
    public List<Type> getTypes() {
        return types;
    }

    @JsonProperty("types")
    public void setTypes(List<Type> types) {
        this.types = types;
    }

    @JsonProperty("synonym")
    public String getSynonym() {
        return synonym;
    }

    @JsonProperty("synonym")
    public void setSynonym(String synonym) {
        this.synonym = synonym;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", label='" + label + '\'' +
                ", types=" + types +
                ", synonym='" + synonym + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
