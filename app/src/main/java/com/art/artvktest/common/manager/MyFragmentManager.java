package com.art.artvktest.common.manager;

import android.support.annotation.IdRes;
import android.support.v4.app.FragmentTransaction;

import com.art.artvktest.ui.activity.BaseActivity;
import com.art.artvktest.ui.fragment.BaseFragment;

import java.util.Stack;

public class MyFragmentManager {

    //в стеке всегда должен оставаться один фрагмент, константа для этого
    private static final int EMPTY_FRAGMENT_STACK_SIZE = 1;

    //переменные для стека и текущего фрагмента
    private Stack<BaseFragment> mFragmentStack = new Stack<>();
    private BaseFragment mCurrentFragment;


    //метод, который будет отображать корневой фрагмент, который будет отображать основное содержимое окна,
    //в нем будут отображать заголовки тулбара и втидимость кнопки ФАБ
    public void setFragment(BaseActivity activity, BaseFragment fragment, @IdRes int containerId){
        if (activity != null && !activity.isFinishing() && !isAlreadyContains(fragment)){
            FragmentTransaction transaction = createAddTransaction(activity, fragment, false);
            transaction.replace(containerId, fragment);
            commitAddTransaction(activity, fragment, transaction,false);
        }
    }

    //метод, который добавляет фрагменты поверх корневого
    public void addFragment(BaseActivity activity, BaseFragment fragment, @IdRes int currentId){
        if (activity != null && !activity.isFinishing() && !isAlreadyContains(fragment)){
            FragmentTransaction transaction = createAddTransaction(activity, fragment, true);
            transaction.add(currentId, fragment);
            commitAddTransaction(activity, fragment, transaction, true);
        }
    }

    //поскольку не все фрагменты нужны в стеке, метод возвращает FragmentTransaction в
    //зависимости от параметра addToBackStag будет добавлять/не доюбавлять фрагмент в стек
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
            commitTransaction(activity, transaction);
        }
    }

    //метод удаления текущего фрагмента
    public boolean removeCurrentFragment(BaseActivity activity){
        return removeFragment(activity, mCurrentFragment);
    }
    //метод для удаления фрагмента
    public boolean removeFragment (BaseActivity activity, BaseFragment fragment){
        boolean canRemove = fragment != null && mFragmentStack.size() > EMPTY_FRAGMENT_STACK_SIZE;

        if (canRemove){
            FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();

            mFragmentStack.pop();
            mCurrentFragment = mFragmentStack.lastElement();

            transaction.remove(fragment);
            commitTransaction(activity, transaction);
        }
        return canRemove;
    }

    //метод, который коммитит любые трансакции, независмо от того, добавляются фрагменты в бекстек или удаляются
    private void commitTransaction (BaseActivity activity, FragmentTransaction transaction){
        transaction.commit();
        activity.fragmentOnScreen(mCurrentFragment);
    }

    //метод проверки существования в стеке фрагмента
    private boolean isAlreadyContains (BaseFragment baseFragment){
        if (baseFragment == null)
            return false;

        return mCurrentFragment != null
                && mCurrentFragment.getClass().getName().equals(baseFragment.getClass().getName());
    }
}
