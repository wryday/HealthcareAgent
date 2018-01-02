package com.edgar.healthcareagent.contentResult;

import java.util.HashMap;
import java.util.Map;

public class Topic {

    private String id;
    private String version;
    private String certifiedDate;
    private String lang;
    private String type;
    private Title title;
    private Legal legal;
    private Boolean navigable;
    private Credits credits;
    private String html;
    private String aspect;
    private String detailLevel;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The version
     */
    public String getVersion() {
        return version;
    }

    /**
     *
     * @param version
     * The version
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     *
     * @return
     * The certifiedDate
     */
    public String getCertifiedDate() {
        return certifiedDate;
    }

    /**
     *
     * @param certifiedDate
     * The certifiedDate
     */
    public void setCertifiedDate(String certifiedDate) {
        this.certifiedDate = certifiedDate;
    }

    /**
     *
     * @return
     * The lang
     */
    public String getLang() {
        return lang;
    }

    /**
     *
     * @param lang
     * The lang
     */
    public void setLang(String lang) {
        this.lang = lang;
    }

    /**
     *
     * @return
     * The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     * The title
     */
    public Title getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(Title title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The legal
     */
    public Legal getLegal() {
        return legal;
    }

    /**
     *
     * @param legal
     * The legal
     */
    public void setLegal(Legal legal) {
        this.legal = legal;
    }

    /**
     *
     * @return
     * The navigable
     */
    public Boolean getNavigable() {
        return navigable;
    }

    /**
     *
     * @param navigable
     * The navigable
     */
    public void setNavigable(Boolean navigable) {
        this.navigable = navigable;
    }

    /**
     *
     * @return
     * The credits
     */
    public Credits getCredits() {
        return credits;
    }

    /**
     *
     * @param credits
     * The credits
     */
    public void setCredits(Credits credits) {
        this.credits = credits;
    }

    /**
     *
     * @return
     * The html
     */
    public String getHtml() {
        return html;
    }

    /**
     *
     * @param html
     * The html
     */
    public void setHtml(String html) {
        this.html = html;
    }

    /**
     *
     * @return
     * The aspect
     */
    public String getAspect() {
        return aspect;
    }

    /**
     *
     * @param aspect
     * The aspect
     */
    public void setAspect(String aspect) {
        this.aspect = aspect;
    }

    /**
     *
     * @return
     * The detailLevel
     */
    public String getDetailLevel() {
        return detailLevel;
    }

    /**
     *
     * @param detailLevel
     * The detailLevel
     */
    public void setDetailLevel(String detailLevel) {
        this.detailLevel = detailLevel;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}