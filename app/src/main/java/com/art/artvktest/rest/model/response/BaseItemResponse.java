package com.art.artvktest.rest.model.response;


import java.util.ArrayList;
import java.util.List;

/**
 * JSON
 * {
 *     "response":{
 *         "count":1067,
 *         "items":[...],
 *         "profiles" : [...],
 *         "groups" : [...]
 *     }
 * }
 * @param <T>
 */
public class BaseItemResponse<T>{

    public Integer count;
    public List<T> items = new ArrayList<>();

    public Integer getCount() {
        return count;
    }

    public List<T> getItems() {
        return items;
    }
}
