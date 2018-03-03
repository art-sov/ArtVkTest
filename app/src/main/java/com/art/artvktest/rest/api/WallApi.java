package com.art.artvktest.rest.api;

import com.art.artvktest.rest.model.response.BaseItemResponse;
import com.art.artvktest.rest.model.response.Full;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Формат запроса
 *
 */

public interface WallApi {

    @GET(ApiMethods.WALL_GET)
    Call<Full<BaseItemResponse>> get(@Query("ownerId") String ownerId,
                                     @Query("access_token") String accessToken,
                                     @Query("extended") Integer extended,
                                     @Query("v") String version);
}
