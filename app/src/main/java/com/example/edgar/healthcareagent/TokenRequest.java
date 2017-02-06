package com.example.edgar.healthcareagent;

/**
 * Created by Edgar on 11/15/2016.
 */

import android.util.Base64;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class TokenRequest {

    public static String token;
    private String ClientId = "4488c302a1be4a6ca430b63661843c43";
    private String ClientSecret = "qOGnt7wlB0eQo0pbaEcoXw==";

    public String getToken() {
        OkHttpClient client = new OkHttpClient();
        String authCode = getEncodedAuthCode();
        String url = "https://auth.healthwise.net/v1/oauth2/token";

        String body = "{{'grant_type' : 'client_credentials', 'scope' : '*', 'expires_in' : '3600'}}";
        Log.d("OKHTTP3", "Client created");
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("grant_type", "client_credentials");
            jsonObject.put("scope", "content.api search.api taxonomy.api");
            jsonObject.put("expiration", "86400'");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody jsonBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"),
                jsonObject.toString());

        Request newRequest = new Request.Builder()
                .url(url)
                .addHeader("Authorization", authCode)
                .addHeader("Content-Type", "application/json")
                .post(jsonBody)
                .build();

        try{
            Response response = client.newCall(newRequest).execute();
            String jsonData = response.body().string();
            JSONObject jobject = new JSONObject(jsonData);
            token = jobject.getString("access_token");
        } catch (IOException e) {
            Log.d("OKHTTP3", "Exception while doing request");
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return token;
    }

    private String getEncodedAuthCode() {
        String code = ClientId + ":" + ClientSecret;
        String result;
        Log.v("OKHTTP3", "Encoding: " + code);
        byte[] code2 = code.getBytes();
        String finalCode = Base64.encodeToString(code2, Base64.URL_SAFE | Base64.NO_WRAP);
        result = String.format("Basic " + finalCode);
        return result;
    }
}
