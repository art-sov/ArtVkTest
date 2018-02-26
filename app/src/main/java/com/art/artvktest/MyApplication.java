package com.art.artvktest;

import android.app.Application;

import com.art.artvktest.di.component.ApplicationComponent;
import com.art.artvktest.di.component.DaggerApplicationComponent;
import com.art.artvktest.di.module.ApplicationModule;
import com.vk.sdk.VKSdk;

/**
 * Created by Sovalov.AV on 13.02.2018.
 */

public class MyApplication extends Application {

    private  static ApplicationComponent sApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initComponent();

        VKSdk.initialize(this);
    }

    //метод для инициализации компонента
    private void initComponent(){
        sApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }
    //метод для получения компонента
    public static ApplicationComponent getsApplicationComponent(){
        return sApplicationComponent;
    }
}
