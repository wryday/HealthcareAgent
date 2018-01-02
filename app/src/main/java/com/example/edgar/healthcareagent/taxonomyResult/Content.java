package com.example.edgar.healthcareagent.taxonomyResult;

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

    /**
     *
     * @return
     * The topicAspects
     */
    public List<TopicAspect> getTopicAspects() {
        return topicAspects;
    }

    /**
     *
     * @param topicAspects
     * The topicAspects
     */
    public void setTopicAspects(List<TopicAspect> topicAspects) {
        this.topicAspects = topicAspects;
    }

    /**
     *
     * @return
     * The articleAspects
     */
    public List<ArticleAspect> getArticleAspects() {
        return articleAspects;
    }

    /**
     *
     * @param articleAspects
     * The articleAspects
     */
    public void setArticleAspects(List<ArticleAspect> articleAspects) {
        this.articleAspects = articleAspects;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}