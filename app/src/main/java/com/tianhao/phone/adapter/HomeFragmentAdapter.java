package com.tianhao.phone.adapter;

import android.support.v4.app.FragmentManager;

import com.tianhao.phone.ui.fragment.TestFragmentA;
import com.tianhao.phone.ui.fragment.TestFragmentB;
import com.tianhao.phone.ui.fragment.TestFragmentC;
import com.tianhao.phone.ui.fragment.TestFragmentD;
import com.tianhao.phone.ui.fragment.UIFragment;

import java.util.ArrayList;

public class HomeFragmentAdapter extends BaseFragmentPagerAdapter<UIFragment> {
    public HomeFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public void init(FragmentManager manager, ArrayList<UIFragment> mFragmentList) {
        mFragmentList.add(TestFragmentA.newInstance());
        mFragmentList.add(TestFragmentB.newInstance("",""));
        mFragmentList.add(TestFragmentC.newInstance());
        mFragmentList.add(TestFragmentD.Companion.newInstance());
    }


}
