package com.shreyaghoshal.twopointo.ui.activity.dashboard;

import android.app.Activity;
import android.content.Context;

import com.shreyaghoshal.twopointo.base.BasePresenter;

public class DashboardPresenter extends BasePresenter<DashboardContract.View> implements DashboardContract.Presenter  {


    private Context context;
    private String TAG = "DashboardPresenter";

    DashboardPresenter(Context context) {
        this.context = context;

    }

}
