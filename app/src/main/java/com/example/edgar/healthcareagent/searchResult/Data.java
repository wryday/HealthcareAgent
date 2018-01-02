package com.example.edgar.healthcareagent.searchResult;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Data {

    private String id;
    private String lang;
    private String type;
    private String doctype;
    private Localizations localizations;
    private Title title;
    private Abstract _abstract;
    private Integer duration;
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
     * The doctype
     */
    public String getDoctype() {
        return doctype;
    }

    /**
     *
     * @param doctype
     * The doctype
     */
    public void setDoctype(String doctype) {
        this.doctype = doctype;
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
     * The _abstract
     */
    public Abstract getAbstract() {
        return _abstract;
    }

    /**
     *
     * @param _abstract
     * The abstract
     */
    public void setAbstract(Abstract _abstract) {
        this._abstract = _abstract;
    }

    /**
     *
     * @return
     * The duration
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     *
     * @param duration
     * The duration
     */
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}