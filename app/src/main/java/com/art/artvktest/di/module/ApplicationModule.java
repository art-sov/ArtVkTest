package com.art.artvktest.di.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by admin on 26.02.2018.
 */

@Module
@Singleton
public class ApplicationModule {

    private Application mApplication;

    public ApplicationModule(Application application){
        mApplication = application;
    }


    //private Context appContext;

    @Singleton
    @Provides
    public Context provideContext(){
        return mApplication;
    }
}
