package com.edgar.healthcareagent.util;

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
import okhttp3.ResponseBody;

public class TokenRequest {
    private static final String TAG = TokenRequest.class.getSimpleName();

    private static final String TOKEN_CLIENT_ID = "4488c302a1be4a6ca430b63661843c43";
    private static final String TOKEN_CLIENT_SECRET = "qOGnt7wlB0eQo0pbaEcoXw==";

    public String getToken() {
        OkHttpClient client = new OkHttpClient();

        String authCode = getEncodedAuthCode();

        String url = "https://auth.healthwise.net/v1/oauth2/token";

//        String body = "{{'grant_type' : 'client_credentials', 'scope' : '*', 'expires_in' : '3600'}}";

        Log.d(TAG, "Client created");

        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("grant_type", "client_credentials");
            jsonObject.put("scope", "content.api search.api taxonomy.api");
            jsonObject.put("expiration", "86400'");
        } catch (JSONException e) {
            Log.e(TAG, "JSONException in getToken", e);
        }

        RequestBody jsonBody = RequestBody.create(
                MediaType.parse("application/json; charset=utf-8"),
                jsonObject.toString());

        Request newRequest = new Request.Builder()
                .url(url)
                .addHeader("Authorization", authCode)
                .addHeader("Content-Type", "application/json")
                .post(jsonBody)
                .build();

        String authToken = "";

        try {
            Response response = client.newCall(newRequest).execute();
            ResponseBody responseBody = response.body();

            if (responseBody != null) {
                String jsonData = responseBody.string();
                JSONObject responseJsonObject = new JSONObject(jsonData);
                authToken = responseJsonObject.getString("access_token");
            }
        } catch (IOException e) {
            Log.e(TAG, "IOException while doing request", e);
        } catch (JSONException e) {
            Log.e(TAG, "JSONException while doing request", e);
        }

        //sendDataToServer(newRequest, client);
        return authToken;
    }

//    private void sendDataToServer(Request newRequest, OkHttpClient client) {
//        new AsyncTask<Void, Void, String>() {
//            @Override
//            protected String doInBackground(Void... voids) {
//                String jsonData;
//                JSONObject jsonObject;
//
//                try {
//                    Response response = client.newCall(newRequest).execute();
//                    jsonData = response.body().string();
//                    jsonObject = new JSONObject(jsonData);
//
//                    MainActivity.token = jsonObject.getString("access_token");
//
//                    return jsonObject.getString("access_token");
//                } catch (IOException e) {
//                    Log.e(TAG, "IOException while doing request", e);
//                } catch (JSONException e) {
//                    Log.e(TAG, "JSONException while doing request", e);
//                }
//
//                return "Couldn't get the server";
//                //return getServerResponse(newRequest, client);
//            }
//
//            @Override
//            protected void onPostExecute(String result) {
//                Log.i(TAG, "onPostExecute sendDataToServer " + result);
//                MainActivity.token = result;
//               /*try {
//                   token = get();
//               } catch (InterruptedException e) {
//                   e.printStackTrace();
//               } catch (ExecutionException e) {
//                   e.printStackTrace();
//               }*/
//            }
//        }.execute();
//    }

//    private String getServerResponse(Request newRequest, OkHttpClient client) {
//        String jsonData;
//        JSONObject jsonObject;
//
//
//        try {
//            Response response = client.newCall(newRequest).execute();
//            ResponseBody responseBody = response.body();
//
//            if (responseBody != null) {
//                jsonData = responseBody.string();
//                jsonObject = new JSONObject(jsonData);
//                return jsonObject.getString("access_token");
//            }
//        } catch (IOException e) {
//            Log.e(TAG, "IOException while doing request");
//        } catch (JSONException e) {
//            Log.e(TAG, "JSONException while doing request");
//        } catch (NullPointerException e) {
//            Log.e(TAG, "NullPointerException while doing request");
//        }
//
//        return "Couldn't get the server";
//    }

    private String getEncodedAuthCode() {
        String code = TOKEN_CLIENT_ID + ":" + TOKEN_CLIENT_SECRET;
        Log.v(TAG, "Encoding: " + code);

        byte[] code2 = code.getBytes();
        String finalCode = Base64.encodeToString(code2, Base64.URL_SAFE | Base64.NO_WRAP);

        return "Basic " + finalCode;
    }
}
