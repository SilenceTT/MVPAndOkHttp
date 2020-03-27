package com.example.slience.mvpandokhttp.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.slience.mvpandokhttp.mvpbase.BaseApplication;

/**
 * Created by PeiShanqing on 2020/3/26 20:33.
 */
public class SharedPreferencesUtils {

    private static volatile SharedPreferencesUtils instance = null;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private SharedPreferencesUtils(){
        sharedPreferences = BaseApplication.getAppContext().getSharedPreferences("userMsg" , Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public static SharedPreferencesUtils getInstance(){
        if(instance == null){
            synchronized (SharedPreferencesUtils.class){
                if(instance == null){
                    instance = new SharedPreferencesUtils();
                }
            }
        }
        return instance;
    }

    /**
     * 存储用户token
     * @param token
     */
    public void setToken(String token){
        editor.putString("token" , token).commit();
    }

    /**
     * 获取用户token
     * @return
     */
    public String getToken(){
        return sharedPreferences.getString("token" , "");
    }
}
