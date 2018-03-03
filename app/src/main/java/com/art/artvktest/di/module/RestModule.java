package com.art.artvktest.di.module;

import com.art.artvktest.rest.RestClient;
import com.art.artvktest.rest.api.WallApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RestModule {

    private RestClient mRestClient;

    public RestModule() {
        mRestClient = new RestClient();
    }

    @Provides
    @Singleton
    public RestClient provideRestClient(){
        return mRestClient;
    }

    @Provides
    @Singleton
    public WallApi provideWallApi(){
        return mRestClient.createService(WallApi.class);
    }
}
