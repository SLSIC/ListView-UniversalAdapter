package com.tq.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.tq.bean.ItemBean;
import com.tq.bean.SpecialBean;
import com.tq.myapplication.R;
import com.tq.template.LayoutDatasEntity;
import com.tq.template.ListViewBaseAdapter;
import com.tq.template.ViewHolder;
import com.tq.util.BitMapUtil;

/**
 * Created by LB
 * E-mail：lb@tqscsoft.com
 * Time: 2017/3/21
 * Desc:
 */

public class ListViewAdapter extends ListViewBaseAdapter {

    public ListViewAdapter(Context context, @Nullable LayoutDatasEntity... entitys) {
        super(context, entitys);
    }

    @Override
    public void convert(ViewHolder vh, Object item, int position) {
        if (getItemViewType(position) == 0) {
            SpecialBean bean = (SpecialBean) item;
            ((TextView) vh.getView(R.id.titleTv)).setText(bean.getTitle());
            ((TextView) vh.getView(R.id.descTv)).setText(bean.getDesc());
            ((TextView) vh.getView(R.id.timeTv)).setText(bean.getTime());
        } else {
            ItemBean i = (ItemBean) item;
            ((TextView) vh.getView(R.id.titleTv)).setText(i.getTitle());
            ((TextView) vh.getView(R.id.descTv)).setText(i.getDesc());
            ((TextView) vh.getView(R.id.timeTv)).setText(i.getTime());
/*            final LottieAnimationView anim = vh.getView(R.id.item_anim);
*//*            LottieComposition.Factory.fromAssetFileName(mContext, "data.json", new OnCompositionLoadedListener() {
                @Override
                public void onCompositionLoaded(LottieComposition composition) {
                    anim.setComposition(composition);
                    anim.playAnimation();
                }
            });*//*
            anim.setAnimation("data.json", LottieAnimationView.CacheStrategy.Strong);
            anim.playAnimation();*/

            TextView tv = vh.getView(R.id.phoneTv);
            Drawable drawable = mContext.getResources().getDrawable(R.drawable.aut);
            BitMapUtil util = BitMapUtil.getInstance();
            Bitmap bitmap = util.getRoundedCornerBitmap(util.drawableToBitmap(drawable), 15);
            drawable = new BitmapDrawable(mContext.getResources(), bitmap);
            if (position % 2 == 0) {
                drawable.setBounds(0, 0, 10, 10);
            } else {
                drawable = new BitmapDrawable(mContext.getResources(), util.createReflectionImageWithOrigin(bitmap));
                drawable.setBounds(0, 0, 50, 50);
            }
            tv.setCompoundDrawables(drawable, null, null, null);
            tv.setText(i.getPhone());
        }
    }
}
