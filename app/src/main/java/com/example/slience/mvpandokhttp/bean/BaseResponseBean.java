package com.example.slience.mvpandokhttp.bean;

import java.io.Serializable;

/**
 * Created by PeiShanqing on 2020/3/26 20:44.
 */
public abstract class BaseResponseBean<T> implements Serializable {

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public abstract T getResult();

    @Override
    public String toString() {
        return "BaseResponseBean{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
