package com.edgar.healthcareagent;

import android.content.Context;

import com.google.gson.JsonElement;

import java.util.Map;

import ai.api.AIListener;
import ai.api.android.AIConfiguration;
import ai.api.android.AIService;
import ai.api.model.AIError;
import ai.api.model.AIResponse;
import ai.api.model.Result;

public class AiBot implements AIListener {
    private AIService aiService;
    private Context context = null;
    final AIConfiguration config;
    String APIAIrequest;

    public AiBot(Context context) {
        config = new AIConfiguration("330c83acba834b0f8d904734f56df684",
                AIConfiguration.SupportedLanguages.English,
                AIConfiguration.RecognitionEngine.System);
        this.context = context;
        aiService = AIService.getService(context, config);
        aiService.setListener(this);
    }

    public AIService getAiService() {
        return aiService;
    }

    @Override
    public void onResult(AIResponse response) {
        Result result = response.getResult();

        // Get parameters
        String parameterString = "";
        if (result.getParameters() != null && !result.getParameters().isEmpty()) {
            for (final Map.Entry<String, JsonElement> entry : result.getParameters().entrySet()) {
                parameterString += "(" + entry.getKey() + ", " + entry.getValue() + ") ";
            }
        }
        APIAIrequest = result.getResolvedQuery();
        // Show results in TextView for debugging.
       /* resultTextView.setMovementMethod(new ScrollingMovementMethod());
        resultTextView.setText("Query:" + result.getResolvedQuery() +
                "\nAction: " + result.getAction() +
                "\nParameters: " + parameterString +
                "\nAnswer: " + result.getFulfillment().getSpeech() );
        request = result.getResolvedQuery();*/
    }

    @Override
    public void onError(AIError error) {

    }

    @Override
    public void onAudioLevel(float level) {

    }

    @Override
    public void onListeningStarted() {

    }

    @Override
    public void onListeningCanceled() {

    }

    @Override
    public void onListeningFinished() {

    }
}
