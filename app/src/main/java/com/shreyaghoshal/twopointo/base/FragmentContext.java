package com.shreyaghoshal.twopointo.base;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
@PerFragmentScope
public class FragmentContext {

    private Context context;

    public FragmentContext(Context context) {
        this.context = context;
    }

    @Provides
    @PerFragmentScope
    public Context getContext() {
        return context;
    }
}
