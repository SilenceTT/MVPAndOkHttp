package com.example.slience.mvpandokhttp;

import com.example.slience.mvpandokhttp.bean.BasicResponseBean;
import com.example.slience.mvpandokhttp.mvpbase.IBaseView;

/**
 * Created by PeiShanqing on 2020/3/27 15:59.
 */
public interface IMainView extends IBaseView {

    void showRes(BasicResponseBean bean);

}
