package com.example.slience.mvpandokhttp;

import com.example.slience.mvpandokhttp.bean.BasicResponseBean;
import com.example.slience.mvpandokhttp.mvpbase.BaseModel;
import com.example.slience.mvpandokhttp.network.ApiConfig;
import com.example.slience.mvpandokhttp.network.CallBack;

import java.util.Map;

/**
 * Created by PeiShanqing on 2020/3/27 15:59.
 */
public class MainModel extends BaseModel {

    public void getNetResFromMySelf(Map<String , String> params , CallBack<BasicResponseBean> callBack){
        getGetNetRes(params , ApiConfig.BASE_URL, BasicResponseBean.class , callBack);
    }
}
