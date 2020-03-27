package com.example.slience.mvpandokhttp.network;

import com.example.slience.mvpandokhttp.utils.SharedPreferencesUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by PeiShanqing on 2020/3/26 20:31.
 */
public class HeaderInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        builder.addHeader("token", SharedPreferencesUtils.getInstance().getToken());
        builder.addHeader("Content-Type" , "application/json");

        return chain.proceed(builder.build());
    }
}
