package com.tq.util;

import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Calendar;

import timber.log.Timber;

/**
 * Created by LB
 * E-mail：lb@tqscsoft.com
 * Time: 2017/3/20
 * Desc:
 */

public class ClickProxyUtil {

    private static ClickProxyUtil instance;

    private ClickProxyUtil() {

    }

    public static ClickProxyUtil getInstance() {
        if (instance == null) {
            synchronized (ClickProxyUtil.class) {
                if (instance == null) {
                    instance = new ClickProxyUtil();
                }
            }
        }
        return instance;
    }

    public void clickProxy(View... views) {
        try {
            for (View v : views) {
                Class<?> viewClazz = Class.forName("android.view.View");
                Method info = viewClazz.getDeclaredMethod("getListenerInfo");
                if (!info.isAccessible()) {
                    info.setAccessible(true);
                }
                Object o = info.invoke(v);
                Class<?> listenerClazz = Class.forName("android.view.View$ListenerInfo");
                Field clickField = listenerClazz.getDeclaredField("mOnClickListener");
                if (!clickField.isAccessible()) {
                    clickField.setAccessible(true);
                }
                View.OnClickListener l = (View.OnClickListener) clickField.get(o);
                View.OnClickListener listenerProxy = new OnClickListenerProxy(l);
                clickField.set(o, listenerProxy);
            }
        } catch (Exception e) {
            Timber.v("clickProxy--->" + e.toString());
            e.printStackTrace();
        }
    }

    private class OnClickListenerProxy implements View.OnClickListener {
        private View.OnClickListener o;
        private static final int MIN_CLICK_DELAY_TIME = 1000;
        private long lastClickTime = 0;

        OnClickListenerProxy(View.OnClickListener mListener) {
            this.o = mListener;
        }

        @Override
        public void onClick(View v) {
            long currentTime = Calendar.getInstance().getTimeInMillis();
            if (currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {
                lastClickTime = currentTime;
                Timber.v("proxy--->excute");
                if (o != null) {
                    o.onClick(v);
                }
            }
        }
    }
}
