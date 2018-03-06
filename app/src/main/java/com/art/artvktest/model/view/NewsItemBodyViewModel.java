package com.art.artvktest.model.view;

import android.view.View;

import com.art.artvktest.model.WallItem;
import com.art.artvktest.ui.holder.BaseViewHolder;
import com.art.artvktest.ui.holder.NewsItemBodyHolder;

public class NewsItemBodyViewModel extends BaseViewModel {

    private int mId;
    private String mText;

    public NewsItemBodyViewModel(WallItem wallItem) {
        this.mId = wallItem.getId();
        this.mText = wallItem.getText();
    }

    @Override
    public LayoutTypes getType() {
        return LayoutTypes.NewsFeedItemBody;
    }

    @Override
    protected BaseViewHolder onCreateViewHolder(View view) {
        return new NewsItemBodyHolder(view);
    }

    public int getId() {
        return mId;
    }

    public String getText() {
        return mText;
    }
}
