package com.edgar.healthcareagent.rest;

import com.edgar.healthcareagent.model.contentResult.ContentResult;
import com.edgar.healthcareagent.model.SearchResult;
import com.edgar.healthcareagent.model.suggestions.Suggestions;
import com.edgar.healthcareagent.model.taxonomyResult.TaxonomyResult;
import com.edgar.healthcareagent.model.Token;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface ApiInterface {

    @GET("suggestions")
    Call<Suggestions> getSuggestions(@QueryMap Map<String, String> options);

    @GET("search")
    Call<SearchResult> getSearchResults(@QueryMap Map<String, String> options);

    @GET("taxonomy")
    Call<TaxonomyResult> getTaxonomyResults(@QueryMap Map<String, String> options);

    @GET("content")
    Call<ContentResult> getContentResults(@QueryMap Map<String, String> options);

    @POST("token")
    Call<Token> getToken(@QueryMap Map<String, String> parameters);
}
