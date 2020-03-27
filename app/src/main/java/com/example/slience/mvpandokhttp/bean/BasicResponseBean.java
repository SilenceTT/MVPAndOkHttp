package com.example.slience.mvpandokhttp.bean;

/**
 * Created by PeiShanqing on 2020/3/26 20:44.
 */
public class BasicResponseBean extends BaseResponseBean<Object> {

    Object result;

    @Override
    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "BasicResponseBean{" +
                "result=" + result +
                '}';
    }

}
