package com.tianhao.phone.ui;

import android.util.Log;

import com.gyf.barlibrary.ImmersionBar;
import com.tianhao.phone.BuildConfig;

/**
 * 沉浸式状态栏
 *
 */
public abstract  class ImmersionBarActivity extends BaseActivity {
    private ImmersionBar immersionBar;
    @Override
    protected void afterContentView() {
        if (isStatusBarEnabled()){
            statusBarConfig().init();
//            //设置标题栏
//            if (getTitleBarId() > 0) {
//                ImmersionBar.setTitleBar(this, findViewById(getTitleBarId()));
//            }
        }
    }

    private ImmersionBar statusBarConfig() {
         immersionBar = ImmersionBar.with(this);
         return immersionBar;
    }
    protected ImmersionBar getImmersionBar(){
        return immersionBar;
    }
    protected abstract boolean isStatusBarEnabled();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 必须调用该方法，防止内存泄漏
        if (immersionBar != null) immersionBar.destroy();
    }
}
