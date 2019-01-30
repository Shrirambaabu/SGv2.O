package com.shreyaghoshal.twopointo;


import android.app.Application;

import dagger.Module;
import dagger.Provides;

@Module
@SGScope
public class SGAppModule {


    private Application mApplication;

    SGAppModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    @SGScope
    Application provideApplication() {
        return mApplication;
    }
}
