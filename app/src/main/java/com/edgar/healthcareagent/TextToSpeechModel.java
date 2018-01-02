package com.edgar.healthcareagent;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.util.Log;

import java.util.Locale;
/**
 * Created by Edgar on 11/20/2016.
 */

public class TextToSpeechModel implements TextToSpeech.OnInitListener {

    private Context context;
    public TextToSpeech tts;

    public TextToSpeechModel(Context context){
        this.context = context;
        tts = new TextToSpeech(context,this);
    }

    @Override
    public void onInit(int status) {

        if (status == TextToSpeech.SUCCESS) {

            int result = tts.setLanguage(Locale.US);

            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {
            }

        } else {
            Log.e("TTS", "Initilization Failed!");
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
