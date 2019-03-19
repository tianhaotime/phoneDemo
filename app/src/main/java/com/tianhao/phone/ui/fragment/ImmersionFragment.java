package com.tianhao.phone.ui.fragment;

import com.gyf.barlibrary.ImmersionBar;

/**
 * 沉浸式fragment
 */
public abstract class ImmersionFragment extends UIFragment {

    /**
     * 此方法在fragment 布局加载完并且是显示的时候调用
     *
     *  if (mFragment != null && mIsActivityCreated && mFragment.getUserVisibleHint()
     *                 && mSimpleImmersionOwner.immersionBarEnabled()) {
     *             mSimpleImmersionOwner.initImmersionBar();
     *         }
     * */
    @Override
    public void initImmersionBar() {
        ImmersionBar.with(this).keyboardEnable(true).init();

        if (getTitleBarId()>0){
            //给自定义的titlebar设置一个pading让他不喝状态栏重叠
            ImmersionBar.setTitleBar(this.getActivity(), findViewById(getTitleBarId()));
        }
    }
}
