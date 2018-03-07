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
import com.art.artvktest.model.WallItem;
import com.art.artvktest.model.view.NewsItemBodyViewModel;
import com.art.artvktest.rest.api.WallApi;
import com.art.artvktest.rest.model.request.WallGetRequestModel;
import com.art.artvktest.rest.model.response.GetWallResponse;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsFeedFragment extends BaseFragment {

    @Inject
    WallApi mWallApi;

    RecyclerView mRecyclerView;
    BaseAdapter mAdapter;


    public NewsFeedFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setUpRecyclerView(view);
        setUpAdapter(mRecyclerView);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyApplication.getsApplicationComponent().inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mWallApi.get(new WallGetRequestModel(-23213239).toMap())
                .enqueue(new Callback<GetWallResponse>() {

                    @Override
                    public void onResponse(Call<GetWallResponse> call, Response<GetWallResponse> response) {

                        //создаем список и в цикле добавляем в него ViewModel, используя для их наполнения ответ сервера
                        List<NewsItemBodyViewModel> list = new ArrayList<>();
                        for (WallItem item: response.body().response.getItems()) {
                            list.add(new NewsItemBodyViewModel(item));
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
    protected int getMainContentLayout() {
        return R.layout.fragment_feed;
    }

    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_news;
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
}
