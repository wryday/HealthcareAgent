package com.edgar.healthcareagent.model.symptomSearchObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Topic {

    private String id;
    private String version;
    private String hash;
    private String certifiedDate;
    private String lang;
    private String type;
    private Title title;
    private Legal legal;
    private Boolean navigable;
    private Credits credits;
    private String html;
    private List<Taxonomy> taxonomy = null;
    private String aspect;
    private String detailLevel;
    private Map<String, Object> additionalProperties = new HashMap<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getCertifiedDate() {
        return certifiedDate;
    }

    public void setCertifiedDate(String certifiedDate) {
        this.certifiedDate = certifiedDate;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Legal getLegal() {
        return legal;
    }

    public void setLegal(Legal legal) {
        this.legal = legal;
    }

    public Boolean getNavigable() {
        return navigable;
    }

    public void setNavigable(Boolean navigable) {
        this.navigable = navigable;
    }

    public Credits getCredits() {
        return credits;
    }

    public void setCredits(Credits credits) {
        this.credits = credits;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public List<Taxonomy> getTaxonomy() {
        return taxonomy;
    }

    public void setTaxonomy(List<Taxonomy> taxonomy) {
        this.taxonomy = taxonomy;
    }

    public String getAspect() {
        return aspect;
    }

    public void setAspect(String aspect) {
        this.aspect = aspect;
    }

    public String getDetailLevel() {
        return detailLevel;
    }

    public void setDetailLevel(String detailLevel) {
        this.detailLevel = detailLevel;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id='" + id + '\'' +
                ", version='" + version + '\'' +
                ", hash='" + hash + '\'' +
                ", certifiedDate='" + certifiedDate + '\'' +
                ", lang='" + lang + '\'' +
                ", type='" + type + '\'' +
                ", title=" + title +
                ", legal=" + legal +
                ", navigable=" + navigable +
                ", credits=" + credits +
                ", html='" + html + '\'' +
                ", taxonomy=" + taxonomy +
                ", aspect='" + aspect + '\'' +
                ", detailLevel='" + detailLevel + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
