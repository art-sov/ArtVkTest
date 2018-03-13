package com.art.artvktest.model.view;


import android.view.View;

import com.art.artvktest.model.WallItem;
import com.art.artvktest.ui.holder.BaseViewHolder;
import com.art.artvktest.ui.holder.NewsItemHeaderHolder;

public class NewsItemHeaderViewModel extends BaseViewModel{

    //переменная для идентификатора
    private int mId;

    //для фото
    private String mProfilePhoto;

    //для имени отправителя
    private String mProfileName;

    //является ли запись репостом
    private boolean mIsRepost;

    //переменная для автора репоста
    private String mRepostProfileName;

    public NewsItemHeaderViewModel(WallItem wallItem) {
        this.mId = wallItem.getId();
        this.mProfilePhoto = wallItem.getSenderPhoto();
        this.mProfileName = wallItem.getSenderName();

        this.mIsRepost = wallItem.haveSharedRepost();

        if (mIsRepost) {
            this.mRepostProfileName = wallItem.getSharedRepost().getSenderName();
        }
    }

    @Override
    public LayoutTypes getType() {
        return LayoutTypes.NewsFeedItemHeader;
    }

    @Override
    protected BaseViewHolder onCreateViewHolder(View view) {
        return new NewsItemHeaderHolder(view);
    }

    public int getId() {
        return mId;
    }

    public String getProfilePhoto() {
        return mProfilePhoto;
    }

    public String getProfileName() {
        return mProfileName;
    }

    public boolean isRepost() {
        return mIsRepost;
    }

    public String getRepostProfileName() {
        return mRepostProfileName;
    }
}
