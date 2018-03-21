package com.art.artvktest.model.view.counter;

import com.art.artvktest.model.Likes;

public class LikeCounterViewModel extends CountViewModel {

    private Likes mLikes;
    //вызываем конструктор суперкласса для получения счетчика
    public LikeCounterViewModel(Likes likes) {
        super(likes.getCount());

        this.mLikes = likes;

        if (mLikes.getUserLikes() == 1) {
            setAccentColor();
        }
    }

    public Likes getLikes() {
        return mLikes;
    }
}
