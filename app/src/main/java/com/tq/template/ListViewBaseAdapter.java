package com.tq.template;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by LB
 * E-mail：libao@ranshine.net
 * Time: 2017/3/21
 * Desc:
 */

public abstract class ListViewBaseAdapter extends BaseAdapter {
    protected Context mContext;
    protected LayoutDatasEntity[] mLayoutDatasEntities;

    public ListViewBaseAdapter(Context context, LayoutDatasEntity... entitys) {
        this.mContext = context;
        this.mLayoutDatasEntities = entitys;
        initPosition(mLayoutDatasEntities);
    }

    private void initPosition(LayoutDatasEntity[] mLayoutDatasEntities) {
        int position = -1;
        for (LayoutDatasEntity entity : mLayoutDatasEntities) {
            switch (position) {
                case -1:
                    if (entity.getDatas().size() == 0) {
                        position = -1;
                        entity.getPosition()[0] = -1;
                        entity.getPosition()[1] = -1;
                    } else {
                        entity.getPosition()[0] = 0;
                        position = entity.getDatas().size() - 1;
                        entity.getPosition()[1] = position;
                    }
                    break;
                default:
                    entity.getPosition()[0] = position + 1;
                    position += entity.getDatas().size();
                    entity.getPosition()[1] = position;
                    break;
            }
        }
    }

    @Override
    public int getCount() {
        return mLayoutDatasEntities[mLayoutDatasEntities.length - 1].getPosition()[1] + 1;
    }

    @Override
    public Object getItem(int position) {
        for (LayoutDatasEntity entity : mLayoutDatasEntities) {
            if (entity.getPosition()[1] == -1) {
                continue;
            }
            if (position >= 0 && position <= entity.getPosition()[1]) {
                return entity.getDatas().get(position - entity.getPosition()[0]);
            }
        }
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return mLayoutDatasEntities.length;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh = null;
        if (convertView == null) {
            for (int i = 0; i < mLayoutDatasEntities.length; i++) {
                if (getItemViewType(position) == i) {
                    vh = new ViewHolder(mContext, mLayoutDatasEntities[i].getLayoutId(), parent);
                }
            }
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        convert(vh, getItem(position), position);
        assert vh != null;
        return vh.getConvertView();
    }

    @Override
    public int getItemViewType(int position) {
        for (int type = 0; type < mLayoutDatasEntities.length; type++) {
            if (position <= mLayoutDatasEntities[type].getPosition()[1]) {
                return type;
            }
        }
        return IGNORE_ITEM_VIEW_TYPE;
    }

    public abstract void convert(ViewHolder vh, Object item, int position);
}
