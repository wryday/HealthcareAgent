package com.edgar.healthcareagent.searchResult;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getDoctype() {
        return doctype;
    }

    public void setDoctype(String doctype) {
        this.doctype = doctype;
    }

    public Localizations getLocalizations() {
        return localizations;
    }

    public void setLocalizations(Localizations localizations) {
        this.localizations = localizations;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Abstract getAbstract() {
        return _abstract;
    }

    public void setAbstract(Abstract _abstract) {
        this._abstract = _abstract;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
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
                "id='" + id + '\'' +
                ", lang='" + lang + '\'' +
                ", type='" + type + '\'' +
                ", doctype='" + doctype + '\'' +
                ", localizations=" + localizations +
                ", title=" + title +
                ", _abstract=" + _abstract +
                ", duration=" + duration +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
