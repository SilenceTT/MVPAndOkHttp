package com.example.slience.mvpandokhttp.network;

import android.accounts.NetworkErrorException;
import android.util.Log;

import com.example.slience.mvpandokhttp.bean.BasicResponseBean;
import com.example.slience.mvpandokhttp.mvpbase.BaseApplication;
import com.example.slience.mvpandokhttp.utils.JsonUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by PeiShanqing on 2020/3/26 20:24.
 */
public class OkHttpApi {

    /**
     * delete请求
     * @param params
     * @param url
     * @param clazz
     * @param callback
     */
    public static void requestDeleteAPI(Map<String , String> params , String url , final Class<?> clazz, final CallBack callback){
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8") , JsonUtils.mapToJson(params));

        OkHttpUtils.delete().url(url).requestBody(requestBody)
                .id(100).tag(BaseApplication.getAppContext()).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                if(e instanceof NetworkErrorException){ //网络错误
                    callback.onError("请检查网络");
                }else if(e instanceof TimeoutException){    //请求超时
                    callback.onError("请求超时，网络不好或服务器不稳定");
                }else if(e instanceof UnknownHostException){       //找不到服务器
                    callback.onError("未发现指定服务器");
                }else if(e instanceof ConnectException){    //连接失败
                    callback.onError("连接失败，请检查网络是否通畅");
                }else{
                    callback.onError("未知错误");
                }
            }

            @Override
            public void onResponse(String response, int id) {
                BasicResponseBean baseResult = JsonUtils.json2Bean(response , BasicResponseBean.class);
                if(baseResult.getCode() == 200){
                    Object result = JsonUtils.json2Bean(response , clazz);
                    callback.onSuccess(result);
                }else{
                    callback.onFailure(baseResult.getMessage());
                }
            }
        });
    }

    /**
     * Map Post请求
     * @param object
     * @param url
     * @param clazz
     * @param callback
     */
    public static void requestPostAPI(Map<String , String> params , String url , final Class<?> clazz ,final CallBack callback){

        String jsonStr = JsonUtils.mapToJson(params);
        Log.i("Main" , jsonStr);
        Log.i("Main" , url);

        OkHttpUtils.postString().url(url)
                .content(JsonUtils.mapToJson(params)).mediaType(MediaType.parse("application/json;charset=utf-8"))
                .id(100).tag(BaseApplication.getAppContext()).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                if(e instanceof NetworkErrorException){ //网络错误
                    callback.onError("请检查网络");
                }else if(e instanceof TimeoutException){    //请求超时
                    callback.onError("请求超时，网络不好或服务器不稳定");
                }else if(e instanceof UnknownHostException){       //找不到服务器
                    callback.onError("未发现指定服务器");
                }else if(e instanceof ConnectException){    //连接失败
                    callback.onError("连接失败，请检查网络是否通畅");
                }else{
                    callback.onError("未知错误");
                }
            }

            @Override
            public void onResponse(String response, int id) {
                BasicResponseBean baseResult = JsonUtils.json2Bean(response , BasicResponseBean.class);
                if(baseResult.getCode() == 200){
                    Object result = JsonUtils.json2Bean(response , clazz);
                    callback.onSuccess(result);
                }else{
                    callback.onFailure(baseResult.getMessage());
                }
            }
        });
    }

    /**
     * Map Get请求
     * @param params
     * @param url
     * @param clazz
     * @param callback
     */
    public static void requestGetApi(Map<String , String> params , String url ,final Class<?> clazz, final CallBack callback){
        OkHttpUtils.get().url(url).params(params)
                .id(100).tag(BaseApplication.getAppContext()).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                if(e instanceof NetworkErrorException){ //网络错误
                    callback.onError("请检查网络");
                }else if(e instanceof TimeoutException){    //请求超时
                    callback.onError("请求超时，网络不好或服务器不稳定");
                }else if(e instanceof UnknownHostException){       //找不到服务器
                    callback.onError("未发现指定服务器");
                }else if(e instanceof ConnectException){    //连接失败
                    callback.onError("连接失败，请检查网络是否通畅");
                }else{
                    callback.onError("未知错误");
                }
            }

            @Override
            public void onResponse(String response, int id) {
                BasicResponseBean baseResult = JsonUtils.json2Bean(response , BasicResponseBean.class);
                if(baseResult.getCode() == 200){
                    Object result = JsonUtils.json2Bean(response , clazz);
                    callback.onSuccess(result);
                }else{
                    callback.onFailure(baseResult.getMessage());
                }
            }
        });
    }

    /**
     * Put请求
     * @param params
     * @param url
     * @param clazz
     * @param callback
     */
    public static void requestPutApi(Map<String , String> params , String url ,final Class<?> clazz, final CallBack callback){

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8") , JsonUtils.mapToJson(params));

        OkHttpUtils.put().url(url).requestBody(requestBody)
                .id(100).tag(BaseApplication.getAppContext()).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                if(e instanceof NetworkErrorException){ //网络错误
                    callback.onError("请检查网络");
                }else if(e instanceof TimeoutException){    //请求超时
                    callback.onError("请求超时，网络不好或服务器不稳定");
                }else if(e instanceof UnknownHostException){       //找不到服务器
                    callback.onError("未发现指定服务器");
                }else if(e instanceof ConnectException){    //连接失败
                    callback.onError("连接失败，请检查网络是否通畅");
                }else{
                    callback.onError("未知错误");
                }
            }

            @Override
            public void onResponse(String response, int id) {
                BasicResponseBean baseResult = JsonUtils.json2Bean(response , BasicResponseBean.class);
                if(baseResult.getCode() == 200){
                    Object result = JsonUtils.json2Bean(response , clazz);
                    callback.onSuccess(result);
                }else{
                    callback.onFailure(baseResult.getMessage());
                }
            }
        });

    }
}
