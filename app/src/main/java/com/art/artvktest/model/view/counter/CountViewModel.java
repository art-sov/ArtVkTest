package com.art.artvktest.model.view.counter;

import com.art.artvktest.R;

/**
 * Содержит цвета и количества для заполнения вью-счетчика
 */

public class CountViewModel {

    protected int mCount;
    protected int mIconColor = R.color.colorIconDis;
    protected int mTextColor = R.color.colorIconDis;

    public CountViewModel(int count) {
        this.mCount = count;
        if (mCount > 0) {
            setDefaultColor();
        } else {
            setDisabledColor();
        }
    }

    private void setDisabledColor() {
        mIconColor = R.color.colorIconDis;
        mTextColor = R.color.colorIconDis;
    }

    private void setDefaultColor() {
        mIconColor = R.color.colorIcon;
        mTextColor = R.color.colorIcon;
    }

    protected void setAccentColor(){
        mIconColor = R.color.colorAccent;
        mTextColor = R.color.colorAccent;
    }

    public int getCount() {
        return mCount;
    }

    public int getIconColor() {
        return mIconColor;
    }

    public int getTextColor() {
        return mTextColor;
    }
}
