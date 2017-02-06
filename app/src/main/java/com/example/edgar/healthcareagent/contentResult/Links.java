package com.example.edgar.healthcareagent.contentResult;

import java.util.HashMap;
import java.util.Map;

public class Links {

    private String self;
    private Localizations localizations;
    private Metadata metadata;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The self
     */
    public String getSelf() {
        return self;
    }

    /**
     *
     * @param self
     * The self
     */
    public void setSelf(String self) {
        this.self = self;
    }

    /**
     *
     * @return
     * The localizations
     */
    public Localizations getLocalizations() {
        return localizations;
    }

    /**
     *
     * @param localizations
     * The localizations
     */
    public void setLocalizations(Localizations localizations) {
        this.localizations = localizations;
    }

    /**
     *
     * @return
     * The metadata
     */
    public Metadata getMetadata() {
        return metadata;
    }

    /**
     *
     * @param metadata
     * The metadata
     */
    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}