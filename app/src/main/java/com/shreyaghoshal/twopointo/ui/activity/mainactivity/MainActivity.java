package com.shreyaghoshal.twopointo.ui.activity.mainactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.shreyaghoshal.twopointo.R;
import com.shreyaghoshal.twopointo.utils.PreferenceAppHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("FCM:", "" + PreferenceAppHelper.getFcmToken());
    }

}
