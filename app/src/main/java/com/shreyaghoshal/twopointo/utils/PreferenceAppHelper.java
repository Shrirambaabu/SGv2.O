package com.shreyaghoshal.twopointo.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.shreyaghoshal.twopointo.SGApplication;

public class PreferenceAppHelper {

    private static SharedPreferences mSharedPreferences = null;

    private static final String PREFS_NAME = "ShreyaGhoshal";

    private static final String FCM_TOKEN = "fcm_token";


    public static String getFcmToken() {
        return getSharedPreference().getString(FCM_TOKEN, "");
    }

    public static void setFcmToken(String fcmToken) {
        setStringInPrefs(FCM_TOKEN, fcmToken);
    }


    private static SharedPreferences getSharedPreference() {
        if (mSharedPreferences == null) {
            mSharedPreferences = SGApplication.getAppContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        }
        return mSharedPreferences;
    }

    private static void setStringInPrefs(String key, String value) {
        SharedPreferences.Editor editor = getSharedPreference().edit();
        editor.putString(key, value);
        editor.apply();
    }


}
