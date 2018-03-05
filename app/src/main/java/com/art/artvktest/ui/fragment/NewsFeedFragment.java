package com.art.artvktest.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.art.artvktest.CurrentUser;
import com.art.artvktest.MyApplication;
import com.art.artvktest.R;
import com.art.artvktest.rest.api.WallApi;
import com.art.artvktest.rest.model.request.WallGetRequestModel;
import com.art.artvktest.rest.model.response.WallGetResponse;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsFeedFragment extends BaseFragment {

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

        mWallApi.get(new WallGetRequestModel(-86529522).toMap())
                .enqueue(new Callback<WallGetResponse>() {

                    @Override
                    public void onResponse(Call<WallGetResponse> call, Response<WallGetResponse> response) {

                        //Log.i("response", "response: " + response.body().toString());
                        Toast.makeText(getActivity(), "Likes: " +
                                response.body().response.getItems().get(0).getLikes().getCount(),
                                Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<WallGetResponse> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
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
