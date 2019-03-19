package com.tianhao.phone.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.hjq.bar.TitleBar;
import com.tianhao.phone.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TestFragmentB#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TestFragmentB extends ImmersionFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    @BindView(R.id.tb_test_b_title)
    TitleBar titleBar;
    public TestFragmentB() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static TestFragmentB newInstance(String param1, String param2) {
        TestFragmentB fragment = new TestFragmentB();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }



    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        Log.e("aking"," fragment b = initdate");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("TestFragmentB", "activity" + this.getActivity());
        ImmersionBar.setTitleBar(this.getActivity(), titleBar);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_blank;
    }

    @Override
    protected int getTitleBarId() {
        return 0;
    }

    @Override
    public void initImmersionBar() {
         ImmersionBar.with(this).statusBarDarkFont(true)
                 .init();
    }


}
