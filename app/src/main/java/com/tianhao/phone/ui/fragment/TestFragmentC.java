package com.tianhao.phone.ui.fragment;

import android.support.v7.widget.Toolbar;

import com.gyf.barlibrary.ImmersionBar;
import com.tianhao.phone.R;

import butterknife.BindView;

public class TestFragmentC extends ImmersionFragment{
    @BindView(R.id.detail_toolbar)
    Toolbar toolbar;
    public static TestFragmentC newInstance() {
        return new TestFragmentC();
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void initData() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_test_c;
    }

    @Override
    protected int getTitleBarId() {
        return 0;
    }

    @Override
    public void initImmersionBar() {
        ImmersionBar.with(this).titleBar(toolbar).init();
    }
}
