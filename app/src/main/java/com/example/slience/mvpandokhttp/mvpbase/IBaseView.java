package com.example.slience.mvpandokhttp.mvpbase;

/**
 * Created by PeiShanqing on 2020/3/26 19:54.
 */
public interface IBaseView {

    //显示LoadingView
    void showLoading();

    //隐藏LoadingView
    void hideLoading();

    //显示提示
    void showToast(String msg);

    //显示错误
    void showErr(String msg);

}
