package com.example.edgar.healthcareagent.rest;

import com.example.edgar.healthcareagent.contentResult.ContentResult;
import com.example.edgar.healthcareagent.searchResult.SearchResult;
import com.example.edgar.healthcareagent.suggestions.Suggestions;
import com.example.edgar.healthcareagent.taxonomyResult.TaxonomyResult;
import com.example.edgar.healthcareagent.token.Token;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by Edgar on 1/2/2017.
 */

public interface ApiInterface {

    @GET("suggestions")
    Call<Suggestions> getSuggestions(@QueryMap Map<String, String> options);

    @GET("search")
    Call<SearchResult> getSearchResults(@QueryMap Map<String, String> options);

    @GET("taxonomy")
    Call<TaxonomyResult> getTaxonomyResults(@QueryMap Map<String, String> options);

    @GET()
    Call<ContentResult> getContentResults();

    @POST("token")
    Call<Token>getToken(@Body Map<String, String> parameters);
}
