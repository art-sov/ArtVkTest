package com.art.artvktest.di.module;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

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

    //метод для внедрения шрифта
    //Typeface нужен для того, чтобы тексвью понимал какой стиль шрифта ему использовать
    @Singleton
    @Provides
    Typeface provideGoogleTypeface(Context context){
        return Typeface.createFromAsset(context.getAssets(), "MaterialIcons-Regular.ttf");
    }
}
