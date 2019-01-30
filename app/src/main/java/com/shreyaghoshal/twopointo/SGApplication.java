package com.shreyaghoshal.twopointo;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;

import com.google.gson.Gson;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class SGApplication  extends Application {
    private static Context context;

    private SGComponent sgComponent;


    public static final String BASE_URL ="https://www.backfour.in/";

    @Inject
    Gson gson;
    @Inject
    SharedPreferences sharedPreferences;

    @Inject
    OkHttpClient okHttpClient;

    @Inject
    Retrofit retrofit;

    public static Context getAppContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // LeakCanary.install(this);
        // JodaTimeAndroid.init(this);

        context = this;

        sgComponent = DaggerSGComponent.builder()
                .contextModule(new ContextModule(context))
                .sGAppModule(new SGAppModule(this))
                .build();

        sgComponent.inject(this);
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public Gson getGson() {
        return gson;
    }

}
