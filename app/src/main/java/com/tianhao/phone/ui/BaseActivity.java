package com.tianhao.phone.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * 基础类，实现公共的内容
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        beforeContentView();
        setContentView(getLayoutID());
        afterContentView();
        initView();
        initData();
    }

    protected abstract void beforeContentView();

    protected abstract void afterContentView();

    /**
     * @return activity布局
     */
    protected abstract int getLayoutID();

    protected abstract void initView();

    protected abstract void initData();

    /**
     * @return  标题栏id actionbar
     */
    protected abstract int getTitleBarId();
    @Override
    public void finish() {
        // 隐藏软键盘，避免软键盘引发的内存泄露
        View view = getCurrentFocus();
        if (view != null) {
            InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (manager != null) manager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        super.finish();
    }
}
