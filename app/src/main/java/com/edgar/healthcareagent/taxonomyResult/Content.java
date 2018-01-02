package com.edgar.healthcareagent.taxonomyResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Content {

    private List<TopicAspect> topicAspects = new ArrayList<TopicAspect>();
    private List<ArticleAspect> articleAspects = new ArrayList<ArticleAspect>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<TopicAspect> getTopicAspects() {
        return topicAspects;
    }

    public void setTopicAspects(List<TopicAspect> topicAspects) {
        this.topicAspects = topicAspects;
    }

    public List<ArticleAspect> getArticleAspects() {
        return articleAspects;
    }

    public void setArticleAspects(List<ArticleAspect> articleAspects) {
        this.articleAspects = articleAspects;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Content{" +
                "topicAspects=" + topicAspects +
                ", articleAspects=" + articleAspects +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
