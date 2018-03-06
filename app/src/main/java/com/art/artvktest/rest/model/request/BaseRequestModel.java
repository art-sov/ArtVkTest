package com.art.artvktest.rest.model.request;

import com.art.artvktest.CurrentUser;
import com.art.artvktest.consts.ApiConstants;
import com.google.gson.annotations.SerializedName;
import com.vk.sdk.api.VKApiConst;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseRequestModel {

    //SerialisedName - чтобы ретрофит понимал названия полей
    @SerializedName(VKApiConst.VERSION)
    Double version = ApiConstants.DEFAULT_VERSION;

    @SerializedName(VKApiConst.ACCESS_TOKEN)
    String accessToken = CurrentUser.getAccessToken();

    public Double getVersion() {
        return version;
    }

    public String getAccessToken() {
        return accessToken;
    }

    //преобразование полей класса в массив "ключ-значение"
    public Map<String, String> toMap(){
        Map<String, String> map = new HashMap<>();

        map.put(VKApiConst.VERSION, String.valueOf(getVersion()));
        if (accessToken != null){
            map.put(VKApiConst.ACCESS_TOKEN, getAccessToken());
        }

        onMapCreate(map);
        return map;
    }

    //для передачи создания map в дочерние классы используем абстрактный метод
    public abstract void onMapCreate(Map<String, String> map);
}
