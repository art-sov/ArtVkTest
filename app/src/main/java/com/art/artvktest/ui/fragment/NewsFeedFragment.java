package com.art.artvktest.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.art.artvktest.MyApplication;
import com.art.artvktest.R;
import com.art.artvktest.common.BaseAdapter;
import com.art.artvktest.common.utils.VkListHelper;
import com.art.artvktest.model.WallItem;
import com.art.artvktest.model.view.BaseViewModel;
import com.art.artvktest.model.view.NewsItemBodyViewModel;
import com.art.artvktest.model.view.NewsItemFooterViewModel;
import com.art.artvktest.model.view.NewsItemHeaderViewModel;
import com.art.artvktest.rest.api.WallApi;
import com.art.artvktest.rest.model.request.WallGetRequestModel;
import com.art.artvktest.rest.model.response.GetWallResponse;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsFeedFragment extends BaseFeedFragment {

    @Inject
    WallApi mWallApi;




    public NewsFeedFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyApplication.getsApplicationComponent().inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //-23213239
        mWallApi.get(new WallGetRequestModel(-23213239).toMap())
                .enqueue(new Callback<GetWallResponse>() {

                    @Override
                    public void onResponse(Call<GetWallResponse> call, Response<GetWallResponse> response) {
                        List<WallItem> wallItems = VkListHelper.getWallList(response.body().response);
                        List<BaseViewModel> list = new ArrayList<>();

                        for (WallItem item: wallItems) {
                            list.add(new NewsItemHeaderViewModel(item));
                            list.add(new NewsItemBodyViewModel(item));
                            list.add(new NewsItemFooterViewModel(item));
                        }

                        mAdapter.addItems(list);

                        //Log.i("response", "response: " + response.body().toString());
                        Toast.makeText(getActivity(), "Likes: " +
                                response.body().response.getItems().get(0).getLikes().getCount(),
                                Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<GetWallResponse> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
    }

    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_news;
    }

}
