package com.art.artvktest.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.art.artvktest.R;
import com.art.artvktest.common.BaseAdapter;

public class BaseFeedFragment extends BaseFragment {

    RecyclerView mRecyclerView;
    BaseAdapter mAdapter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setUpRecyclerView(view);
        setUpAdapter(mRecyclerView);
    }

    //методы для инициализации RecyclerView и адаптера
    private void setUpRecyclerView(View rootView){
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.rv_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void setUpAdapter (RecyclerView recyclerView) {
        mAdapter = new BaseAdapter();
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    protected int getMainContentLayout() {
        return R.layout.fragment_feed;
    }

    @Override
    public int onCreateToolbarTitle() {
        return 0;
    }
}
