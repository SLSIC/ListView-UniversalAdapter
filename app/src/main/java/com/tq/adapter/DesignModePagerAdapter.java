package com.tq.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by LB
 * E-mail：libao@ranshine.net
 * Time: 2017/4/28
 * Desc:
 */

public class DesignModePagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> mFragments;
    private List<String> mTitles;

    public DesignModePagerAdapter(FragmentManager manager, List<Fragment> fragments, List<String> titles) {
        super(manager);
        this.mFragments = fragments;
        this.mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments != null ? mFragments.size() : 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles != null ? mTitles.get(position) : "";
    }
}
