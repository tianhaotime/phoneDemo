package com.tianhao.phone.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public  abstract class BaseFragmentPagerAdapter<T extends Fragment> extends FragmentPagerAdapter {

    private T mCurrentFragment;
    private ArrayList<T>  mFragmentList = new ArrayList<>();
    public BaseFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        init(fm, mFragmentList);
    }
    public abstract void init(FragmentManager manager,ArrayList<T>  mFragmentList);
    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        if (getCurrentFragment()!=object){
            mCurrentFragment = (T) object;
        }
        super.setPrimaryItem(container, position, object);

    }
    public T getCurrentFragment(){
        return mCurrentFragment;
    }
    /**
     * 获取Fragment集合
     */
    public List<T> getAllFragment() {
        return mFragmentList;
    }
}
