package com.tq.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.tq.util.BitMapUtil;

/**
 * Created by LB
 * E-mail：libao@ranshine.net
 * Time: 2017/5/4
 * Desc:
 */

public class CRoundImageView extends AppCompatImageView {
    private Paint paint;

    public CRoundImageView(Context context) {
        this(context, null);
    }

    public CRoundImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CRoundImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        paint = new Paint();
    }

    /**
     * 绘制圆形图片
     */
    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (null != drawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Bitmap b = BitMapUtil.getInstance().getRoundedCornerBitmap(bitmap, 180);
            Rect rectSrc = new Rect(0, 0, b.getWidth(), b.getHeight());
            Rect rectDest = new Rect(0, 0, getWidth(), getHeight());
            paint.reset();
            canvas.drawBitmap(b, rectSrc, rectDest, paint);
        } else {
            super.onDraw(canvas);
        }
    }
}
