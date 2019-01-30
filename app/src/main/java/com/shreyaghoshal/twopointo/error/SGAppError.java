package com.shreyaghoshal.twopointo.error;

import android.util.Log;

import java.io.IOException;

public class SGAppError  extends IOException {
    private static final String TAG = "SGAppError";
    private int responseCode;
    private String message;

    SGAppError(int responseCode, String message) {
        this.responseCode = responseCode;
        this.message = message;
        Log.e(TAG, "BackFourError: " + message + " code " + responseCode);
    }

    public int getResponseCode() {
        return responseCode;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
