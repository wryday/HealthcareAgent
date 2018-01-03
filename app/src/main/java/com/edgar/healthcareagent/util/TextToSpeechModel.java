package com.edgar.healthcareagent.util;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.util.Log;

import java.util.Locale;

public class TextToSpeechModel implements TextToSpeech.OnInitListener {
    private static final String TAG = TextToSpeechModel.class.getSimpleName();

    private Context context;

    public TextToSpeech tts;

    public TextToSpeechModel(Context context) {
        this.context = context;
        tts = new TextToSpeech(context, this);
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int result = tts.setLanguage(Locale.US);

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e(TAG, "This Language is not supported");
            } else {
                Log.i(TAG, "Language supported...");
            }
        } else {
            Log.e(TAG, "Initialization Failed!");
        }
    }

    public void speakOut(String reply) {
        tts.speak(reply, TextToSpeech.QUEUE_FLUSH, null);
    }

    public void onDestroy() {
        // Don't forget to shutdown tts!

        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
    }
}
