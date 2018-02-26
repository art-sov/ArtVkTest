package com.art.artvktest.di.module;

import com.art.artvktest.common.manager.MyFragmentManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by admin on 26.02.2018.
 */
@Module
public class ManagerModule {

    @Provides
    @Singleton
    public MyFragmentManager provideMyFragmentManager(){
        return new MyFragmentManager();
    }
}
