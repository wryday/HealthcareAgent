package com.edgar.healthcareagent.model;

import com.edgar.healthcareagent.contentResult.Legal;
import com.edgar.healthcareagent.contentResult.Title;
import com.edgar.healthcareagent.model.Credits;

import java.util.Map;

public class Topic {

    private String id;
    private String version;
    private String certifiedDate;
    private String lang;
    private String type;
    private com.edgar.healthcareagent.contentResult.Title title;
    private Legal legal;
    private Boolean navigable;
    private Credits credits;
    private String html;
    private String aspect;
    private String detailLevel;
    private Map<String, Object> additionalProperties;

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

    public com.edgar.healthcareagent.contentResult.Title getTitle() {
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
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id='" + id + '\'' +
                ", version='" + version + '\'' +
                ", certifiedDate='" + certifiedDate + '\'' +
                ", lang='" + lang + '\'' +
                ", type='" + type + '\'' +
                ", title=" + title +
                ", legal=" + legal +
                ", navigable=" + navigable +
                ", credits=" + credits +
                ", html='" + html + '\'' +
                ", aspect='" + aspect + '\'' +
                ", detailLevel='" + detailLevel + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
