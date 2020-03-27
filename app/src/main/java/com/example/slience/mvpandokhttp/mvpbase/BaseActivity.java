package com.example.slience.mvpandokhttp.mvpbase;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;

import com.example.slience.mvpandokhttp.R;
import com.example.slience.mvpandokhttp.utils.StatusBarUtils;

/**
 * Created by PeiShanqing on 2020/3/26 20:12.
 */
public abstract class BaseActivity<P extends BasePresenter<V> , V extends IBaseView> extends AppCompatActivity implements IBaseView{

    protected P mPresenter;

    protected Context mContext;

    /**头布局**/
    private FrameLayout baseTop;
    /**内容布局**/
    private FrameLayout baseContent;
    /**底部布局**/
    private FrameLayout baseBottom;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = this;

        /**去掉系统的TitleBar**/
        this.getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        /**初始化Content的View**/
        initContentView(R.layout.activity_base);

        createPresenter();
        if(mPresenter != null){
            mPresenter.attachView((V) this);
        }

        getResFromParent();

    }

    private void initContentView(int layoutResId){
        /**得到窗口的根布局**/
        ViewGroup group = findViewById(android.R.id.content);
        /**首先移除在根布局上的组件**/
        group.removeAllViews();
        /**添加上我们的布局**/
        LayoutInflater.from(this).inflate(layoutResId , group , true);
    }

    @Override
    public void setContentView(int layoutContentID) {
//        super.setContentView(view);
        baseTop = findViewById(R.id.base_top);
        baseContent = findViewById(R.id.base_content);
        baseBottom = findViewById(R.id.base_bottom);
        if(StatusBarUtils.isAllScreenDevice(this)){
            baseBottom.setVisibility(View.GONE);
        } else {
            baseBottom.setVisibility(View.VISIBLE);
        }


        /**将子类内容布局添加到基类的内容布局**/
        LayoutInflater.from(this).inflate(layoutContentID , baseContent , true);

        /**将子类实现的标题，添加到基类的标题布局中**/
        if(getTopBar() != null){
            baseTop.addView(getTopBar());
            baseTop.setVisibility(View.VISIBLE);
        }else{
            baseTop.setVisibility(View.GONE);
        }

    }

    /**
     * 子类必须实现，返回一个写好了的 topbar,如果不需要标题，实现方法后返回null就行，
     * @return
     */
    protected abstract View getTopBar();

    protected abstract void getResFromParent();

    protected abstract void createPresenter();

    /**
     * 防止快速点击
     * @return
     */
    private boolean fastClick(){
        long lastClick = 0;
        if(System.currentTimeMillis() - lastClick <= 1000){
            return false;
        }
        lastClick = System.currentTimeMillis();
        return true;
    }

    @Override
    protected void onDestroy() {
        if(mPresenter.isViewAttached()){
            mPresenter.detachView();
        }
        super.onDestroy();
    }
}
