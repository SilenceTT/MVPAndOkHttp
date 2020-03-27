package com.example.slience.mvpandokhttp.mvpbase;

import android.app.Application;
import android.content.Context;

import com.example.slience.mvpandokhttp.network.HeaderInterceptor;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.cookie.CookieJarImpl;
import com.zhy.http.okhttp.cookie.store.PersistentCookieStore;
import com.zhy.http.okhttp.https.HttpsUtils;
import com.zhy.http.okhttp.log.LoggerInterceptor;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.OkHttpClient;

/**
 * Created by PeiShanqing on 2020/3/26 20:34.
 */
public class BaseApplication extends Application {

    /**系统上下文**/
    private static Context mAppContext;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppContext = getApplicationContext();

        initOkHttp();
    }

    private void initOkHttp(){
        CookieJarImpl cookieJar = new CookieJarImpl(new PersistentCookieStore(getApplicationContext()));//修改成自带的cookie持久化，可以解决程序崩溃时返回到
        //ClearableCookieJar cookieJar1 = new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(getApplicationContext()));
        HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory(null , null , null);//设置可以访问所有的https网站
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(60000L , TimeUnit.MILLISECONDS)
                .readTimeout(60000L , TimeUnit.MILLISECONDS)
                //配置Log，通过设置拦截器实现
                .addInterceptor(new LoggerInterceptor("TAG"))
                //配置请求头
                .addInterceptor(new HeaderInterceptor())
                .cookieJar(cookieJar)
                .hostnameVerifier(new HostnameVerifier() {
                    @Override
                    public boolean verify(String hostname, SSLSession session) {
                        return false;
                    }
                })
                //配置Https
                .sslSocketFactory(sslParams.sSLSocketFactory , sslParams.trustManager)
                .build();
        OkHttpUtils.initClient(okHttpClient);
    }

    public static Context getAppContext() {
        return mAppContext;
    }
}
