package com.shreyaghoshal.twopointo.ui.activity.dashboard;


import com.shreyaghoshal.twopointo.base.PerActivityScope;

import dagger.Component;

@Component(modules = {DashboardModule.class})
@PerActivityScope
public interface DashboardComponent {
    void inject(DashboardActivity dashboardActivity);
}
