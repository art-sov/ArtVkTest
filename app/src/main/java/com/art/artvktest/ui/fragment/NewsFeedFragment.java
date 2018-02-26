package com.art.artvktest.ui.fragment;

import android.support.v4.app.Fragment;

import com.art.artvktest.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFeedFragment extends BaseFragment {


    public NewsFeedFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getMainContentLayout() {
        return R.layout.fragment_feed;
    }

    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_news;
    }
}
