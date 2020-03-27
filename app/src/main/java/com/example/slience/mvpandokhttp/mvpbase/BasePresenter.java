package com.example.slience.mvpandokhttp.mvpbase;

import java.lang.ref.WeakReference;

/**
 * Created by PeiShanqing on 2020/3/26 19:56.
 */
public class BasePresenter<V extends IBaseView> implements IBasePresenter<V> {

    //待绑定的View
    private WeakReference<V> weakReference;

    //初始化时绑定View
    @Override
    public void attachView(V view) {
        weakReference = new WeakReference<>(view);
    }

    //销毁时断开View
    @Override
    public void detachView() {
        if(weakReference != null){
            weakReference.clear();
            weakReference = null;
        }
    }

    //是否与View建立连接
    //判空操作，防止空指针异常
    public boolean isViewAttached(){
        return weakReference.get() != null;
    }

    //获取View
    public V getView(){
        return weakReference.get();
    }


    //检查View和Persenter是否连接
    public void checkViewAttach(){
        if(!isViewAttached()){
            throw new BaseViewNotAttachedException();
        }
    }

    //自定义异常
    public static class BaseViewNotAttachedException extends RuntimeException{
        public BaseViewNotAttachedException(){
            super("请求数据前请先调用attachView方法与view建立连接");
        }
    }
}
