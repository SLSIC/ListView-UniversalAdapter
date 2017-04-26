package com.tq.template;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by LB
 * E-mail：libao@ranshine.net
 * Time: 2017/3/21
 * Desc:
 */

public class ViewHolder {
    private SparseArray<View> mViews;
    private View mConvertView;

    ViewHolder(Context context, int layoutId, ViewGroup parent) {
        this.mViews = new SparseArray<View>();
        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        mConvertView.setTag(this);
    }

    @SuppressWarnings("unchecked")
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    View getConvertView() {
        return mConvertView;
    }
}
