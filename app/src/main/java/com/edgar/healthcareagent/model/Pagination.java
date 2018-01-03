package com.edgar.healthcareagent.model;

import java.util.Map;

public class Pagination {

    private Integer count;
    private Integer top;
    private Integer skip;
    private Map<String, Object> additionalProperties;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    public Integer getSkip() {
        return skip;
    }

    public void setSkip(Integer skip) {
        this.skip = skip;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    @Override
    public String toString() {
        return "Pagination{" +
                "count=" + count +
                ", top=" + top +
                ", skip=" + skip +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
