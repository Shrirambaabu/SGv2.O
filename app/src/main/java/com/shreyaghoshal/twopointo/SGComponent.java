package com.shreyaghoshal.twopointo;


import dagger.Component;

@Component(modules = {RetrofitModule.class, SGAppModule.class})
@SGScope
public interface SGComponent {
    void inject(SGApplication sgApplication);
}
