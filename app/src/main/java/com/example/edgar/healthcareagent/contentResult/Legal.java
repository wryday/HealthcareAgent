package com.example.edgar.healthcareagent.contentResult;

import java.util.HashMap;
import java.util.Map;

public class Legal {

    private String logoUrl;
    private String copyrightText;
    private String disclaimerText;
    private String termsOfUseUrl;
    private String privacyPolicyUrl;
    private String moreInformationUrl;
    private String toLearnMoreHtml;
    private String yourUseOfThisInformationHtml;
    private String html;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The logoUrl
     */
    public String getLogoUrl() {
        return logoUrl;
    }

    /**
     *
     * @param logoUrl
     * The logoUrl
     */
    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    /**
     *
     * @return
     * The copyrightText
     */
    public String getCopyrightText() {
        return copyrightText;
    }

    /**
     *
     * @param copyrightText
     * The copyrightText
     */
    public void setCopyrightText(String copyrightText) {
        this.copyrightText = copyrightText;
    }

    /**
     *
     * @return
     * The disclaimerText
     */
    public String getDisclaimerText() {
        return disclaimerText;
    }

    /**
     *
     * @param disclaimerText
     * The disclaimerText
     */
    public void setDisclaimerText(String disclaimerText) {
        this.disclaimerText = disclaimerText;
    }

    /**
     *
     * @return
     * The termsOfUseUrl
     */
    public String getTermsOfUseUrl() {
        return termsOfUseUrl;
    }

    /**
     *
     * @param termsOfUseUrl
     * The termsOfUseUrl
     */
    public void setTermsOfUseUrl(String termsOfUseUrl) {
        this.termsOfUseUrl = termsOfUseUrl;
    }

    /**
     *
     * @return
     * The privacyPolicyUrl
     */
    public String getPrivacyPolicyUrl() {
        return privacyPolicyUrl;
    }

    /**
     *
     * @param privacyPolicyUrl
     * The privacyPolicyUrl
     */
    public void setPrivacyPolicyUrl(String privacyPolicyUrl) {
        this.privacyPolicyUrl = privacyPolicyUrl;
    }

    /**
     *
     * @return
     * The moreInformationUrl
     */
    public String getMoreInformationUrl() {
        return moreInformationUrl;
    }

    /**
     *
     * @param moreInformationUrl
     * The moreInformationUrl
     */
    public void setMoreInformationUrl(String moreInformationUrl) {
        this.moreInformationUrl = moreInformationUrl;
    }

    /**
     *
     * @return
     * The toLearnMoreHtml
     */
    public String getToLearnMoreHtml() {
        return toLearnMoreHtml;
    }

    /**
     *
     * @param toLearnMoreHtml
     * The toLearnMoreHtml
     */
    public void setToLearnMoreHtml(String toLearnMoreHtml) {
        this.toLearnMoreHtml = toLearnMoreHtml;
    }

    /**
     *
     * @return
     * The yourUseOfThisInformationHtml
     */
    public String getYourUseOfThisInformationHtml() {
        return yourUseOfThisInformationHtml;
    }

    /**
     *
     * @param yourUseOfThisInformationHtml
     * The yourUseOfThisInformationHtml
     */
    public void setYourUseOfThisInformationHtml(String yourUseOfThisInformationHtml) {
        this.yourUseOfThisInformationHtml = yourUseOfThisInformationHtml;
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

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}