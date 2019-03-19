package com.tianhao.phone.ui;

import com.hjq.toast.ToastUtils;

import butterknife.ButterKnife;

/**
 * 特有功能的activity
 * 1，带有ButterKnife功能
 * 2，带有mvp功能
 * 3，设置标题栏
 */
public abstract class UIActivity extends ImmersionBarActivity {

    @Override
    protected void afterContentView() {
        super.afterContentView();
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    protected void showToast(String s){
        ToastUtils.show(s);
    }

    @Override
    protected boolean isStatusBarEnabled() {
        return true;
    }

//    @Override
//    public void setTitle(int titleId) {
//        super.setTitle(titleId);
//        setTitle(getText(titleId));
//    }
//
//    @Override
//    public void setTitle(CharSequence title) {
//        super.setTitle(title);
//
//    }
}
