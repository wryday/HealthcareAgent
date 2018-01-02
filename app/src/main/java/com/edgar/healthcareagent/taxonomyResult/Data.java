package com.edgar.healthcareagent.taxonomyResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Data {

    private String id;
    private String lang;
    private String label;
    private String clinicalLabel;
    private AlternativeLabels alternativeLabels;
    private Taxonomy taxonomy;
    private List<Relationship> relationships = new ArrayList<Relationship>();
    private List<List<ListedA>> listedAs = new ArrayList<List<ListedA>>();
    private Content content;
    private CodeSystems codeSystems;
    private Keywords keywords;
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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getClinicalLabel() {
        return clinicalLabel;
    }

    public void setClinicalLabel(String clinicalLabel) {
        this.clinicalLabel = clinicalLabel;
    }

    public AlternativeLabels getAlternativeLabels() {
        return alternativeLabels;
    }

    public void setAlternativeLabels(AlternativeLabels alternativeLabels) {
        this.alternativeLabels = alternativeLabels;
    }

    public Taxonomy getTaxonomy() {
        return taxonomy;
    }

    public void setTaxonomy(Taxonomy taxonomy) {
        this.taxonomy = taxonomy;
    }

    public List<Relationship> getRelationships() {
        return relationships;
    }

    public void setRelationships(List<Relationship> relationships) {
        this.relationships = relationships;
    }

    public List<List<ListedA>> getListedAs() {
        return listedAs;
    }

    public void setListedAs(List<List<ListedA>> listedAs) {
        this.listedAs = listedAs;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public CodeSystems getCodeSystems() {
        return codeSystems;
    }

    public void setCodeSystems(CodeSystems codeSystems) {
        this.codeSystems = codeSystems;
    }

    public Keywords getKeywords() {
        return keywords;
    }

    public void setKeywords(Keywords keywords) {
        this.keywords = keywords;
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
                ", label='" + label + '\'' +
                ", clinicalLabel='" + clinicalLabel + '\'' +
                ", alternativeLabels=" + alternativeLabels +
                ", taxonomy=" + taxonomy +
                ", relationships=" + relationships +
                ", listedAs=" + listedAs +
                ", content=" + content +
                ", codeSystems=" + codeSystems +
                ", keywords=" + keywords +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
