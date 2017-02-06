package com.example.edgar.healthcareagent.searchResult;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Title {

    private Consumer consumer;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The consumer
     */
    public Consumer getConsumer() {
        return consumer;
    }

    /**
     *
     * @param consumer
     * The consumer
     */
    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}