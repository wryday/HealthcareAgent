package com.edgar.healthcareagent.model.searchResult;

import com.edgar.healthcareagent.model.Title;

import java.util.Map;

public class Data {

    private String id;
    private String lang;
    private String type;
    private String doctype;
    private Localizations localizations;
    private Title title;
    private Abstract _abstract;
    private Integer duration;
    private Map<String, Object> additionalProperties;

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

    public Abstract get_abstract() {
        return _abstract;
    }

    public void set_abstract(Abstract _abstract) {
        this._abstract = _abstract;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
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
