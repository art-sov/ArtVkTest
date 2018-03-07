package com.art.artvktest.rest;

import com.art.artvktest.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
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

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();

        if (BuildConfig.DEBUG)
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();

        mRetrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(okClient)
                .baseUrl(VK_BASE_URL)
                .build();
    }

    //переменные для инициализации REST API сервисов
    public <S> S createService (Class<S> serviceClass) {
        return mRetrofit.create(serviceClass);
    }
}
