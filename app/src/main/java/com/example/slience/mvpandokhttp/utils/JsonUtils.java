package com.example.slience.mvpandokhttp.utils;

import com.google.gson.Gson;

import java.util.Map;

/**
 * Project_name:   EBuiltCould
 * Package_name:   com.aohu.ebuiltcould.utils
 * Document_name:  JsonUtils
 * Creator:        Slience
 * Create_time:    2019/7/31 10:55
 * Description:    Json转换类
 */

public class JsonUtils {

    private static Gson mGson  = null;
    static {
        if(mGson == null){
            mGson = new Gson();
        }
    }

    private JsonUtils(){

    }

    /**
     * Map转Json
     * @param params
     * @return
     */
    public static String mapToJson(Map<String , String> params){
        String jsonStr = null;
        if(mGson != null) {
            jsonStr = mGson.toJson(params);
        }
        return jsonStr;
    }

    public static String object2Json(Object object){
        String jsonStr = null;
        if(mGson != null) {
            jsonStr = mGson.toJson(object);
        }
        return jsonStr;
    }

    /**
     * Json转Bean
     * @param jsonString
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> T json2Bean(String jsonString , Class<T> cls){
        T t = null;
        if(mGson != null){
            t = mGson.fromJson(jsonString , cls);
        }
        return t;
    }

}
