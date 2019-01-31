package com.shreyaghoshal.twopointo.ui.activity.splashscreen;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.shreyaghoshal.twopointo.R;
import com.shreyaghoshal.twopointo.ui.activity.dashboard.DashboardActivity;
import com.shreyaghoshal.twopointo.utils.PreferenceAppHelper;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("FCM:", "" + PreferenceAppHelper.getFcmToken());

        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {

                Intent loginIntent = new Intent(SplashScreenActivity.this, DashboardActivity.class);
                loginIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(loginIntent);
                overridePendingTransition(R.anim.enter_right_to_left, R.anim.exit_left_to_right);

            }
        }, 3000);


    }
}
