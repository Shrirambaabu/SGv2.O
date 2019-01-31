package com.shreyaghoshal.twopointo.ui.activity.dashboard;


import android.content.Context;

import com.shreyaghoshal.twopointo.base.ActivityContext;
import com.shreyaghoshal.twopointo.base.PerActivityScope;

import dagger.Module;
import dagger.Provides;

@Module(includes = {ActivityContext.class})
@PerActivityScope
public class DashboardModule {

    @Provides
    @PerActivityScope
    DashboardPresenter dashboardPresenter(Context context) {
        return new DashboardPresenter(context);
    }
}
