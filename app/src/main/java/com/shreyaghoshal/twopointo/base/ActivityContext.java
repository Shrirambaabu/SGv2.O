package com.shreyaghoshal.twopointo.base;


import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
@PerActivityScope
public class ActivityContext {

    private Context context;

    public ActivityContext(Context context) {
        this.context = context;
    }

    @PerActivityScope
    @Provides
    public Context getContext() {
        return context;
    }
}
