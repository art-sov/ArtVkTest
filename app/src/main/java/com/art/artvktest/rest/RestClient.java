package com.art.artvktest.rest;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by admin on 27.02.2018.
 */

public class RestClient {

    private static final String VK_BASE_URL = "https://api.vk.com/method/";
    private Retrofit mRetrofit;

    //инициализируем mRetrofit через конструктор с помощью билдера

    public RestClient() {
        mRetrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(VK_BASE_URL)
                .build();
    }

    //переменные для инициализации REST API сервисов
    public <S> S createService (Class<S> serviceClass) {
        return mRetrofit.create(serviceClass);
    }
}
