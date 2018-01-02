package com.edgar.healthcareagent.symptomSearchObject;

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

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getCopyrightText() {
        return copyrightText;
    }

    public void setCopyrightText(String copyrightText) {
        this.copyrightText = copyrightText;
    }

    public String getDisclaimerText() {
        return disclaimerText;
    }

    public void setDisclaimerText(String disclaimerText) {
        this.disclaimerText = disclaimerText;
    }

    public String getTermsOfUseUrl() {
        return termsOfUseUrl;
    }

    public void setTermsOfUseUrl(String termsOfUseUrl) {
        this.termsOfUseUrl = termsOfUseUrl;
    }

    public String getPrivacyPolicyUrl() {
        return privacyPolicyUrl;
    }

    public void setPrivacyPolicyUrl(String privacyPolicyUrl) {
        this.privacyPolicyUrl = privacyPolicyUrl;
    }

    public String getMoreInformationUrl() {
        return moreInformationUrl;
    }

    public void setMoreInformationUrl(String moreInformationUrl) {
        this.moreInformationUrl = moreInformationUrl;
    }

    public String getToLearnMoreHtml() {
        return toLearnMoreHtml;
    }

    public void setToLearnMoreHtml(String toLearnMoreHtml) {
        this.toLearnMoreHtml = toLearnMoreHtml;
    }

    public String getYourUseOfThisInformationHtml() {
        return yourUseOfThisInformationHtml;
    }

    public void setYourUseOfThisInformationHtml(String yourUseOfThisInformationHtml) {
        this.yourUseOfThisInformationHtml = yourUseOfThisInformationHtml;
    }

    public String getHtml() {
        return html;
    }

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