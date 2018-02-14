package com.art.artvktest.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.art.artvktest.mvp.view.MainView;
import com.art.artvktest.CurrentUser;

/**
 * Created by Sovalov.AV on 13.02.2018.
 */

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {
     public void checkAuth(){
         if (!CurrentUser.isAuthorized()){
             getViewState().startSignIn();
         } else {
             getViewState().signedId();
         }
     }
}
