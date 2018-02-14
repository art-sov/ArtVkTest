package com.art.artvktest;

import android.app.Application;

import com.vk.sdk.VKSdk;

/**
 * Created by Sovalov.AV on 13.02.2018.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        VKSdk.initialize(this);
    }
}
