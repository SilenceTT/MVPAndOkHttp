package com.example.slience.mvpandokhttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.slience.mvpandokhttp.bean.BasicResponseBean;
import com.example.slience.mvpandokhttp.mvpbase.BaseActivity;

public class MainActivity extends BaseActivity<MainPresenter , IMainView> implements IMainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getNetRes();
            }
        });
    }

    @Override
    protected View getTopBar() {
        return null;
    }

    @Override
    protected void getResFromParent() {

    }

    @Override
    protected void createPresenter() {
        mPresenter = new MainPresenter(new MainModel());
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showToast(String msg) {
        TextView tv = findViewById(R.id.textview);
        tv.setText(msg);
    }

    @Override
    public void showErr(String msg) {

    }

    @Override
    public void showRes(BasicResponseBean bean) {
        TextView tv = findViewById(R.id.textview);
        tv.setText(bean.toString());
    }
}
