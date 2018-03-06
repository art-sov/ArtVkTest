package com.art.artvktest.rest.api;

import com.art.artvktest.rest.model.response.GetWallResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Формат запроса
 *
 */

public interface WallApi {

    @GET(ApiMethods.WALL_GET)
    Call<GetWallResponse> get(@QueryMap Map<String, String> map);
}
