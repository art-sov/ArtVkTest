package com.art.artvktest.ui.activity;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.art.artvktest.ui.fragment.BaseFragment;

/**
 * Created by Sovalov.AV on 14.02.2018.
 */

public class BaseActivity extends MvpAppCompatActivity{

    //вызывается при смене фрагмента, чтобы менять заголовок тулбара и видимость кнопки ФАБ
    public void fragmentOnScreen(BaseFragment fragment){

    }
}
