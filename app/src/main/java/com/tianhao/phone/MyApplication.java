package com.tianhao.phone;

import android.app.Application;

import com.hjq.toast.ToastUtils;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ToastUtils.init(this);
    }
}
