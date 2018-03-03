package com.art.artvktest.di.component;

import com.art.artvktest.di.module.ApplicationModule;
import com.art.artvktest.di.module.ManagerModule;
import com.art.artvktest.di.module.RestModule;
import com.art.artvktest.ui.activity.BaseActivity;
import com.art.artvktest.ui.activity.MainActivity;
import com.art.artvktest.ui.fragment.NewsFeedFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by admin on 26.02.2018.
 */
@Singleton
@Component(modules = {ApplicationModule.class, ManagerModule.class, RestModule.class})
public interface ApplicationComponent {

    //зависимости используются в BaseActivity and MainActivity
    void inject(BaseActivity baseActivity);
    void inject(MainActivity mainActivity);

    //fragments
    void inject(NewsFeedFragment fragment);

}
