package com.tianhao.phone.ui;

import android.Manifest;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Intent;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.gyf.barlibrary.BarHide;
import com.tianhao.phone.R;

import butterknife.BindView;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class LauncherActivity extends UIActivity implements Animator.AnimatorListener {

    @BindView(R.id.iv_launcher_bg)
    ImageView ivLauncherBg;
    @BindView(R.id.iv_launcher_icon)
    ImageView ivLauncherIcon;
    @BindView(R.id.iv_launcher_name)
    TextView ivLauncherName;


    @Override
    protected void initData() {

    }

    @Override
    protected int getTitleBarId() {
        return 0;
    }

    @Override
    protected void initView() {
        //实现动画
        ObjectAnimator animator = ObjectAnimator.ofFloat(ivLauncherBg,"alpha",0,1f);
        animator.setDuration(2000);
        animator.addListener(this);
        PropertyValuesHolder holder1 = PropertyValuesHolder.ofFloat("scaleX", 0,1);
        PropertyValuesHolder holder2 = PropertyValuesHolder.ofFloat("scaleY", 0,1);
        ObjectAnimator scaleAnimator = ObjectAnimator.ofPropertyValuesHolder(ivLauncherIcon,holder1,holder2);
        scaleAnimator.setDuration(1000);
        ObjectAnimator rotationAnimator = ObjectAnimator.ofFloat(ivLauncherName,"rotation",180,360);
        rotationAnimator.setDuration(1000);
        AnimatorSet set = new AnimatorSet();
        set.setInterpolator(new AccelerateInterpolator());
        set.playTogether(scaleAnimator,rotationAnimator,animator);
        set.start();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        LauncherActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }

    @Override
    protected void beforeContentView() {

    }

    @Override
    protected void afterContentView() {
        super.afterContentView();
        //有导航栏的情况下，activity全屏显示，也就是activity最下面被导航栏覆盖，不写默认非全屏
        //隐藏状态栏
        //透明导航栏，不写默认黑色(设置此方法，fullScreen()方法自动为true)
        if (isStatusBarEnabled()){
            getImmersionBar().fullScreen(true).hideBar(BarHide.FLAG_HIDE_STATUS_BAR).transparentNavigationBar().init();
        }
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_launcher;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @NeedsPermission({Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE})
    void hasPermissions() {
        startActivity(new Intent(this,HomeActivity.class));
        finish();
    }

    @OnPermissionDenied({Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE})
    void noPermissions() {
        showToast("没有读写权限");
    }

    @OnNeverAskAgain({Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE})
    void onNeverAskPermissions() {
        startActivity(new Intent(Settings.ACTION_SETTINGS)); //直接进入手机中设置界面
    }

    @Override
    public void onAnimationStart(Animator animation) {

    }

    @Override
    public void onAnimationEnd(Animator animation) {
        LauncherActivityPermissionsDispatcher.hasPermissionsWithPermissionCheck(this);
    }

    @Override
    public void onAnimationCancel(Animator animation) {

    }

    @Override
    public void onAnimationRepeat(Animator animation) {

    }
}
