package com.tianhao.phone.ui;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.view.View;

import com.tianhao.phone.R;
import com.tianhao.phone.adapter.HomeFragmentAdapter;
import com.tianhao.phone.widget.NoScrollViewPager;

import butterknife.BindView;

public class HomeActivity extends UIActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    @BindView(R.id.vp)
    NoScrollViewPager vp;
    @BindView(R.id.bottomNavigationView)
    BottomNavigationView bottomNavigationView;
    private HomeFragmentAdapter homeFragmentAdapter;
    @Override
    protected void beforeContentView() {

    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {
        bottomNavigationView.setItemIconTintList(null);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    protected void initData() {
        homeFragmentAdapter = new HomeFragmentAdapter(getSupportFragmentManager());
        vp.setAdapter(homeFragmentAdapter);
        vp.setOffscreenPageLimit(homeFragmentAdapter.getCount());
//        vp.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
//            @Override
//            public void onPageSelected(int position) {
//                switch (position){
//                    case 0:
//                        bottomNavigationView.setSelectedItemId(R.id.menu_home);
//                        break;
//                    case 1:
//                        bottomNavigationView.setSelectedItemId(R.id.menu_found);
//                        break;
//                }
//            }
//        });
    }

    @Override
    protected int getTitleBarId() {
        return 0;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item ) {
        switch (item.getItemId()){
            case R.id.menu_home:
                vp.setCurrentItem(0);
                return true;
            case R.id.menu_found:
                vp.setCurrentItem(1);
                return true;
            case R.id.menu_message:
                vp.setCurrentItem(2);
                return true;
            case R.id.menu_mine:
                vp.setCurrentItem(3);
                return true;
        }
        return false;
    }
}
