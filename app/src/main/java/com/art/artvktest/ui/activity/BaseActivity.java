package com.art.artvktest.ui.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.art.artvktest.MyApplication;
import com.art.artvktest.R;
import com.art.artvktest.common.manager.MyFragmentManager;
import com.art.artvktest.ui.fragment.BaseFragment;

import javax.inject.Inject;

/**
 * Created by Sovalov.AV on 14.02.2018.
 */

public abstract class BaseActivity extends MvpAppCompatActivity{

    @Inject
    MyFragmentManager myFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyApplication.getsApplicationComponent().inject(this);
        setContentView(R.layout.activity_base);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FrameLayout parent = (FrameLayout) findViewById(R.id.main_wrapper);
        getLayoutInflater().inflate(getMainContentLayout(), parent);
    }

    @LayoutRes
    protected abstract int getMainContentLayout();

    //вызывается при смене фрагмента, чтобы менять заголовок тулбара и видимость кнопки ФАБ
    public void fragmentOnScreen(BaseFragment fragment){
        setToolbarTitle(fragment.createToolbarTitle(this));
    }

    //метод установки заголовка тулбара
    public void setToolbarTitle(String title){
        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle(title);
        }
    }

    //методы добавления.удаления фрагментов
    //метод для установки корневого фрагмента
    public void setContent(BaseFragment fragment){
        myFragmentManager.setFragment(this, fragment, R.id.main_wrapper);
    }

    //метод для установки дополнительных фрагментов
    public void addContent(BaseFragment fragment) {
        myFragmentManager.addFragment(this, fragment, R.id.main_wrapper);
    }

    //методы для удаления фрагмента
    public boolean removeCurrentFragment(){
        return myFragmentManager.removeCurrentFragment(this);
    }
    public boolean removeFragment (BaseFragment fragment){
        return myFragmentManager.removeFragment(this, fragment);
    }

    @Override
    public void onBackPressed() {
        removeCurrentFragment();    }
}
