package com.example.slience.mvpandokhttp.mvpbase;

/**
 * Created by PeiShanqing on 2020/3/26 19:57.
 */
public interface IBasePresenter<V extends IBaseView> {

    //绑定View
    void attachView(V view);

    //解绑View
    void detachView();
}
