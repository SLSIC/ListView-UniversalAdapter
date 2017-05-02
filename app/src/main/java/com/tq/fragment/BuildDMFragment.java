package com.tq.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tq.myapplication.R;

/**
 * Created by LB
 * E-mail：libao@ranshine.net
 * Time: 2017/4/28
 * Desc:
 */

public class BuildDMFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dm_build,null);
    }
}
