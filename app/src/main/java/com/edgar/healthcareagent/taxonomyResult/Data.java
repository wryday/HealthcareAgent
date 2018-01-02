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
     * The label
     */
    public String getLabel() {
        return label;
    }

    /**
     *
     * @param label
     * The label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     *
     * @return
     * The clinicalLabel
     */
    public String getClinicalLabel() {
        return clinicalLabel;
    }

    /**
     *
     * @param clinicalLabel
     * The clinicalLabel
     */
    public void setClinicalLabel(String clinicalLabel) {
        this.clinicalLabel = clinicalLabel;
    }

    /**
     *
     * @return
     * The alternativeLabels
     */
    public AlternativeLabels getAlternativeLabels() {
        return alternativeLabels;
    }

    /**
     *
     * @param alternativeLabels
     * The alternativeLabels
     */
    public void setAlternativeLabels(AlternativeLabels alternativeLabels) {
        this.alternativeLabels = alternativeLabels;
    }

    /**
     *
     * @return
     * The taxonomy
     */
    public Taxonomy getTaxonomy() {
        return taxonomy;
    }

    /**
     *
     * @param taxonomy
     * The taxonomy
     */
    public void setTaxonomy(Taxonomy taxonomy) {
        this.taxonomy = taxonomy;
    }

    /**
     *
     * @return
     * The relationships
     */
    public List<Relationship> getRelationships() {
        return relationships;
    }

    /**
     *
     * @param relationships
     * The relationships
     */
    public void setRelationships(List<Relationship> relationships) {
        this.relationships = relationships;
    }

    /**
     *
     * @return
     * The listedAs
     */
    public List<List<ListedA>> getListedAs() {
        return listedAs;
    }

    /**
     *
     * @param listedAs
     * The listedAs
     */
    public void setListedAs(List<List<ListedA>> listedAs) {
        this.listedAs = listedAs;
    }

    /**
     *
     * @return
     * The content
     */
    public Content getContent() {
        return content;
    }

    /**
     *
     * @param content
     * The content
     */
    public void setContent(Content content) {
        this.content = content;
    }

    /**
     *
     * @return
     * The codeSystems
     */
    public CodeSystems getCodeSystems() {
        return codeSystems;
    }

    /**
     *
     * @param codeSystems
     * The codeSystems
     */
    public void setCodeSystems(CodeSystems codeSystems) {
        this.codeSystems = codeSystems;
    }

    /**
     *
     * @return
     * The keywords
     */
    public Keywords getKeywords() {
        return keywords;
    }

    /**
     *
     * @param keywords
     * The keywords
     */
    public void setKeywords(Keywords keywords) {
        this.keywords = keywords;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}