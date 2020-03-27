package com.example.slience.mvpandokhttp;

import android.util.Log;

import com.example.slience.mvpandokhttp.bean.BasicResponseBean;
import com.example.slience.mvpandokhttp.mvpbase.BasePresenter;
import com.example.slience.mvpandokhttp.network.ApiConfig;
import com.example.slience.mvpandokhttp.network.CallBack;
import com.example.slience.mvpandokhttp.network.OkHttpApi;

/**
 * Created by PeiShanqing on 2020/3/27 15:58.
 */
public class MainPresenter extends BasePresenter<IMainView>{

    MainModel mModel;
    IMainView mView;

    public MainPresenter(MainModel mModel){
        this.mModel = mModel;
    }

    public void getNetRes() {
        checkViewAttach();
        mView = getView();

        mModel.getNetResFromMySelf(null, new CallBack<BasicResponseBean>() {
            @Override
            public void onSuccess(BasicResponseBean data) {
                Log.e("TAG" , "success");
                if(data != null)
                    mView.showRes(data);
                else
                    mView.showToast("No message");
            }

            @Override
            public void onFailure(String msg) {
                Log.e("TAG" , msg);
            }

            @Override
            public void onError(String exception) {
                Log.e("TAG" , "error");
            }
        });
    }
}
