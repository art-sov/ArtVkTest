package com.art.artvktest.rest.model.response;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Корневой уровень пришедшего ответа, он содержит в себе response.
 * Он будет отвечать за парсинг секции ответа "response"
 * @param <T>
 */
public class Full<T> {

    @SerializedName("response")
    @Expose
    public T response;
}
