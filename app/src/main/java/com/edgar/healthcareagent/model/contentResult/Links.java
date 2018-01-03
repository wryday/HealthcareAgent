package com.edgar.healthcareagent.model.contentResult;

import java.util.HashMap;
import java.util.Map;

public class Links {

    private String self;
    private Localizations localizations;
    private Metadata metadata;
    private Map<String, Object> additionalProperties = new HashMap<>();

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public Localizations getLocalizations() {
        return localizations;
    }

    public void setLocalizations(Localizations localizations) {
        this.localizations = localizations;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Links{" +
                "self='" + self + '\'' +
                ", localizations=" + localizations +
                ", metadata=" + metadata +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
