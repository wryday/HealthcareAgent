package com.edgar.healthcareagent;

import android.app.Application;
import android.util.Log;


public class App extends Application {
    private static final String TAG = App.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();

        Log.v(TAG, "App onCreate");
    }
}
