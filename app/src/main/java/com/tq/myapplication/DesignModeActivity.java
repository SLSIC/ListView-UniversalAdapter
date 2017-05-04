package com.tq.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.tq.adapter.DesignModePagerAdapter;
import com.tq.fragment.BuildDMFragment;
import com.tq.fragment.RecommendFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LB
 * E-mail：libao@ranshine.net
 * Time: 2017/4/28
 * Desc:
 */

public class DesignModeActivity extends BaseActivity {
    private List<Fragment> mFragmentList;
    private List<String> mTitles;
    private ViewPager mVp;
    private FragmentStatePagerAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_mode);
        initView();
        initDatas();
        show();
    }

    private void show() {
        if (mAdapter == null) {
            mAdapter = new DesignModePagerAdapter(getSupportFragmentManager(), mFragmentList, mTitles);
        }
        mVp.setAdapter(mAdapter);
    }

    private void initDatas() {
        mTitles = new ArrayList<>();
        mFragmentList = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            mTitles.add("CS" + i);
            if (i == 0) {
                mFragmentList.add(new RecommendFragment());
            } else {
                mFragmentList.add(new BuildDMFragment());
            }
        }
    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp_design_mode);
    }
}
