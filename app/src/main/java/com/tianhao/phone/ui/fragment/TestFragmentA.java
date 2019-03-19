package com.tianhao.phone.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.hjq.bar.TitleBar;
import com.tianhao.phone.R;
import com.tianhao.phone.ui.RegisterActivity;

import butterknife.BindView;

/**
 * 首页fragment
 */
public class TestFragmentA extends ImmersionFragment {

    @BindView(R.id.fragment_a_abl)
    AppBarLayout appBarLayout;
    @BindView(R.id.detail_toolbar)
    Toolbar detailToolbar;
    @BindView(R.id.tv_test_address)
    TextView tvTestAddress;
    @BindView(R.id.tv_test_search)
    TextView tvTestSearch;
    @BindView(R.id.tb_test_a_bar)
    TitleBar tbTestABar;

    public static TestFragmentA newInstance() {
        return new TestFragmentA();
    }

    //可以使用view，oncreateview之后已经bindview
    @Override
    protected void initView() {
        //给toolbar设置一个pading  别让他和状态栏重叠
        ImmersionBar.setTitleBar(this.getActivity(), detailToolbar);

    }

    @Override
    protected void initData() {
        Log.e("aking"," fragment a = initdate"+super.getClass());
        DisplayMetrics dm = new DisplayMetrics();

        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        int mWidth = dm.widthPixels; // 当前分辨率 宽度 单位px
        int mHeight = dm.heightPixels; // 当前分辨率 高度 单位px
        float dpi = dm.densityDpi;//屏幕密度
        float density = dm.density;//密度

        Log.e("aking","mWidth : "+mWidth);
        Log.e("aking","mHeight : "+mHeight);
        Log.e("aking","dpi : "+dpi);
        Log.e("aking","density : "+density);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_test_a;
    }

    @Override
    protected int getTitleBarId() {
        return R.id.tb_test_a_bar;
    }


}
