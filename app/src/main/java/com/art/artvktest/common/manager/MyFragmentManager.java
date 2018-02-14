package com.art.artvktest.common.manager;

import android.support.v4.app.FragmentTransaction;

import com.art.artvktest.ui.activity.BaseActivity;
import com.art.artvktest.ui.fragment.BaseFragment;

import java.util.Stack;

/**
 * Created by Sovalov.AV on 14.02.2018.
 */

public class MyFragmentManager {

    private static final int EMPTY_FRAGMENT_STACK_SIZE = 1;

    //переменные для стека и текущего фрагмента
    private Stack<BaseFragment> mFragmentStack = new Stack<>();
    private BaseFragment mCurrentFragment;

    private FragmentTransaction createAddTransaction(BaseActivity activity,
                                                     BaseFragment fragment,
                                                     boolean addToBackStack){
        FragmentTransaction fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();

        if (addToBackStack){
            fragmentTransaction.addToBackStack(fragment.getTag());
        }
        return fragmentTransaction;
    }
        //метод, который коммитит в трансакцию добавление фрагмента
    private void commitAddTransaction(BaseActivity activity,
                                      BaseFragment fragment,
                                      FragmentTransaction transaction,
                                      boolean addToBackStack){
        if (transaction != null){
            mCurrentFragment = fragment;

            if(!addToBackStack){
                mFragmentStack = new Stack<>();
            }
            mFragmentStack.add(fragment);
        }
    }

    //метод, который коммитит любые трансакции, независмо от того добавляются фрагменты в бекстек или удаляются
    private void commitTransaction (BaseActivity activity, FragmentTransaction transaction){
        transaction.commit();
        activity.fragmentOnScreen(mCurrentFragment);
    }
}
