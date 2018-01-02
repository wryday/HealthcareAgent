package com.example.edgar.healthcareagent.searchResult;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Pagination {

    private Integer count;
    private Integer top;
    private Integer skip;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The count
     */
    public Integer getCount() {
        return count;
    }

    /**
     *
     * @param count
     * The count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     *
     * @return
     * The top
     */
    public Integer getTop() {
        return top;
    }

    /**
     *
     * @param top
     * The top
     */
    public void setTop(Integer top) {
        this.top = top;
    }

    /**
     *
     * @return
     * The skip
     */
    public Integer getSkip() {
        return skip;
    }

    /**
     *
     * @param skip
     * The skip
     */
    public void setSkip(Integer skip) {
        this.skip = skip;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}