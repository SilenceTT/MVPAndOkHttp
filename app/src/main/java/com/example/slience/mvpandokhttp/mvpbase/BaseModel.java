package com.example.slience.mvpandokhttp.mvpbase;

import com.example.slience.mvpandokhttp.network.CallBack;
import com.example.slience.mvpandokhttp.network.OkHttpApi;

import java.util.Map;

/**
 * Created by PeiShanqing on 2020/3/26 20:23.
 */
public class BaseModel{

    public void getPostNetRes(Map<String , String> params, String requestUrl , Class cls , CallBack callback){
        OkHttpApi.requestPostAPI(params , requestUrl , cls , callback);
    }

    public void getGetNetRes(Map<String , String> params , String requestUrl , Class cls , CallBack callback){
        OkHttpApi.requestGetApi(params , requestUrl , cls , callback);
    }

    public void getPutNetRes(Map<String , String> params , String requestUrl , Class cls , CallBack callback){
        OkHttpApi.requestPutApi(params , requestUrl , cls , callback);
    }

    public void getDeleteNetRes(Map<String , String> params , String requestUrl , Class cls , CallBack callback){
        OkHttpApi.requestDeleteAPI(params , requestUrl , cls , callback);
    }

}
