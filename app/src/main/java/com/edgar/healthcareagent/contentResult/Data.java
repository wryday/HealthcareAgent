package com.edgar.healthcareagent.contentResult;

import com.edgar.healthcareagent.model.Topic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data {

    private List<Topic> topics = null;
    private Map<String, Object> additionalProperties = new HashMap<>();

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Data{" +
                "topics=" + topics +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
