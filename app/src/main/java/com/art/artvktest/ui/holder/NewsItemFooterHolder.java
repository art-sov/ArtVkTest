package com.art.artvktest.ui.holder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

import com.art.artvktest.MyApplication;
import com.art.artvktest.R;
import com.art.artvktest.common.utils.Utils;
import com.art.artvktest.model.view.NewsItemFooterViewModel;
import com.art.artvktest.model.view.counter.CommentCounterViewModel;
import com.art.artvktest.model.view.counter.LikeCounterViewModel;
import com.art.artvktest.model.view.counter.RepostCounterViewModel;

import javax.inject.Inject;


/**
 * Created by Sovalov.AV on 21.03.2018.
 */

public class NewsItemFooterHolder extends BaseViewHolder<NewsItemFooterViewModel> {

    private TextView tvDate;
    private TextView tvLikesCount;
    private TextView tvLikesIcon;
    private TextView tvCommentsIcon;
    private TextView tvCommentsCount;
    private TextView tvRepostsIcon;
    private TextView tvRepostsCount;

    @Inject
    Typeface mGoogleFontTypeface;

    private Resources mResources;
    private Context mContext;

    public NewsItemFooterHolder(View itemView) {
        super(itemView);
        MyApplication.getsApplicationComponent().inject(this);

        mContext = itemView.getContext();
        mResources = mContext.getResources();

        tvDate = (TextView) itemView.findViewById(R.id.tv_date);
        tvLikesIcon = (TextView) itemView.findViewById(R.id.tv_likes_icon);
        tvLikesCount = (TextView) itemView.findViewById(R.id.tv_likes_count);
        tvCommentsIcon = (TextView) itemView.findViewById(R.id.tv_comments_icon);
        tvCommentsCount = (TextView) itemView.findViewById(R.id.tv_comments_count);
        tvRepostsIcon = (TextView) itemView.findViewById(R.id.tv_reposts_icon);
        tvRepostsCount = (TextView) itemView.findViewById(R.id.tv_reposts_count);

        tvLikesIcon.setTypeface(mGoogleFontTypeface);
        tvCommentsIcon.setTypeface(mGoogleFontTypeface);
        tvRepostsIcon.setTypeface(mGoogleFontTypeface);

    }

    @Override
    public void bindViewHolder(NewsItemFooterViewModel item) {
        tvDate.setText(Utils.parseDate(item.getDateLong(), mContext));

        bindLikes(item.getLikes());
        bindComments(item.getComments());
        bindReposts(item.getReposts());

    }

    //метод для установки иконок и счетчиков для комментариев, лайков и репостов
    //в соотвествующие текстовіе поля в футере записи
    private void bindLikes(LikeCounterViewModel likes) {
        tvLikesCount.setText(String.valueOf(likes.getCount()));
        tvLikesCount.setTextColor(mResources.getColor(likes.getTextColor()));
        tvLikesIcon.setTextColor(mResources.getColor(likes.getTextColor()));
    }

    private void bindComments(CommentCounterViewModel comments) {
        tvCommentsCount.setText(String.valueOf(comments.getCount()));
        tvCommentsCount.setTextColor(mResources.getColor(comments.getTextColor()));
        tvCommentsIcon.setTextColor(mResources.getColor(comments.getTextColor()));
    }

    private void bindReposts(RepostCounterViewModel reposts) {
        tvRepostsCount.setText(String.valueOf(reposts.getCount()));
        tvRepostsCount.setTextColor(mResources.getColor(reposts.getTextColor()));
        tvRepostsIcon.setTextColor(mResources.getColor(reposts.getTextColor()));
    }


    @Override
    public void unbindViewHolder() {
        tvDate.setText(null);
        tvLikesCount.setText(null);
        tvCommentsCount.setText(null);
        tvRepostsCount.setText(null);
    }
}
