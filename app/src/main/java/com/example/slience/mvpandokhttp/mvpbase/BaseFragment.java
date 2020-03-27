package com.example.slience.mvpandokhttp.mvpbase;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.slience.mvpandokhttp.R;

/**
 * Created by PeiShanqing on 2020/3/26 20:51.
 */
public abstract class BaseFragment<P extends BasePresenter<V> , V extends IBaseView> extends Fragment implements IBaseView {

    protected P mPresenter;
    /**基类上下文**/
    protected Context mContext;

    /**头布局**/
    private FrameLayout baseTop;
    /**内容布局**/
    private FrameLayout baseContent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        mContext = getActivity();

        View view = inflater.inflate(R.layout.activity_base , null);
        baseTop = view.findViewById(R.id.base_top);
        baseContent = view.findViewById(R.id.base_content);

        if(getTopBar() != null){
            baseTop.addView(getTopBar());
            baseTop.setVisibility(View.VISIBLE);
        }else{
            baseTop.setVisibility(View.GONE);
        }

        LayoutInflater.from(mContext).inflate(setLayout() , baseContent , true);

        createPresenter();
        if(mPresenter != null){
            mPresenter.attachView((V) this);
        }

        return view;
    }

    /**
     * 子类必须实现，返回一个写好了的 topbar,如果不需要标题，实现方法后返回null就行，
     * @return
     */
    protected abstract View getTopBar();

    /**绑定布局**/
    protected abstract int setLayout();

    /**创建Presenter**/
    protected abstract void createPresenter();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    /**初始化控件**/
    protected abstract void initView(View view);

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    /**
     * 设置数据等逻辑代码
     */
    protected abstract void initData();

    @Override
    public void onDestroy() {
        if(mPresenter.isViewAttached()){
            mPresenter.detachView();
        }
        super.onDestroy();
    }

}

