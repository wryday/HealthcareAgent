package com.edgar.healthcareagent;

import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;

import com.edgar.healthcareagent.ui.MainActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class TokenRequest2 extends AsyncTask<Void, Void, String> {
    private static final String TAG = TokenRequest2.class.getSimpleName();

    //public static String token;
    private String ClientId = "4488c302a1be4a6ca430b63661843c43";
    private String ClientSecret = "qOGnt7wlB0eQo0pbaEcoXw==";

    private String getEncodedAuthCode() {
        String code = ClientId + ":" + ClientSecret;
        String result;

        Log.v(TAG, "Encoding: " + code);

        byte[] code2 = code.getBytes();
        String finalCode = Base64.encodeToString(code2, Base64.URL_SAFE | Base64.NO_WRAP);
        result = String.format("Basic " + finalCode);

        return result;
    }

    @Override
    protected String doInBackground(Void... params) {
        OkHttpClient client = new OkHttpClient();

        String ClientId = "4488c302a1be4a6ca430b63661843c43";
        String ClientSecret = "qOGnt7wlB0eQo0pbaEcoXw==";

        String authCode = getEncodedAuthCode();
        String url = "https://auth.healthwise.net/v1/oauth2/token";

        String body = "{{'grant_type' : 'client_credentials', 'scope' : '*', 'expires_in' : '3600'}}";

        Log.d(TAG, "Client created");

        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("grant_type", "client_credentials");
            jsonObject.put("scope", "content.api search.api taxonomy.api");
            jsonObject.put("expiration", "86400'");
        } catch (JSONException e) {
            Log.e(TAG, "JSONException building request", e);
        }

        RequestBody jsonBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"),
                jsonObject.toString());

        Request newRequest = new Request.Builder()
                .url(url)
                .addHeader("Authorization", authCode)
                .addHeader("Content-Type", "application/json")
                .post(jsonBody)
                .build();
        String jsonData = null;
        JSONObject jobject = null;

        try {
            Response response = client.newCall(newRequest).execute();
            jsonData = response.body().string();
            jobject = new JSONObject(jsonData);

            MainActivity.token = jobject.getString("access_token");

            return jobject.getString("access_token");
        } catch (IOException e) {
            Log.e(TAG, "IOException while doing request", e);
        } catch (JSONException e) {
            Log.e(TAG, "JSONException in task", e);
        }

        return "couldn't get the server";
    }

    @Override
    protected void onPostExecute(String result) {
        Log.d(TAG, "Entered OnPostExecute");
    }
}
