package com.tq.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tq.myapplication.R;
import com.tq.views.disperseview.ShakeListener;
import com.tq.views.disperseview.StellarMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by S-WBY-L
 * Time: 2016/8/19.
 * Desc:
 */
public class RecommendFragment extends BaseFragment {

    private List<String> mDatas;
    private ShakeListener mShakeListener;
    private int sl;
    private int st;
    private int sb;
    private int sr;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        initdatas();
        super.onCreate(savedInstanceState);
    }

    private void initdatas() {
        mDatas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mDatas.add("测试" + i);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dm_observer, container, false);
        // final FrameLayout fl = (FrameLayout) v.findViewById(R.id.fl_top);
        final ImageView iv = (ImageView) v.findViewById(R.id.iv_center);
        iv.post(new Runnable() {
            @Override
            public void run() {
                sl = iv.getLeft();
                st = iv.getTop();
                sb = iv.getBottom();
                sr = iv.getRight();
            }
        });
/*        fl.post(new Runnable() {
            @Override
            public void run() {
                int sw = getActivity().getWindowManager().getDefaultDisplay().getWidth() / 2;
                int sh = fl.getHeight();
                int cw = getActivity().getResources().getDimensionPixelSize(R.dimen.randomWidth) / 2;
                int ch = getActivity().getResources().getDimensionPixelSize(R.dimen.randomHeight) / 2;
                Log.v("WBY", "sh---." + sh);
                sl = sw - cw;
                st = sh - ch;
                sb = sh + ch;
                sr = sw + cw;
            }
        });*/
/*        final FrameLayout fl = (FrameLayout) v.findViewById(R.id.fl_top);
        fl.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                mFlWidth = fl.getWidth();
                mFlHeight = fl.getHeight();
                Log.v("WBY", "======" + mFlWidth + "***" + mFlHeight);
            }
        });
        final ImageView iv = (ImageView) v.findViewById(R.id.iv_center);
        iv.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                mIvWidth = iv.getWidth();
                mIvHeight = iv.getHeight();
                Log.v("WBY", "======" + mIvWidth + "###" + mIvHeight);
            }
        });*/
        //initMargin();
        handlerRandomView(v);
        return v;
    }


/*    private void initMargin() {
        int sw = getActivity().getWindowManager().getDefaultDisplay().getWidth() / 2;
        int sh = getActivity().getWindowManager().getDefaultDisplay().getHeight() / 8;
        Log.v("WBY", "sh***" + sh);
        int cw = getActivity().getResources().getDimensionPixelSize(R.dimen.randomWidth) / 2;
        int ch = getActivity().getResources().getDimensionPixelSize(R.dimen.randomHeight) / 2;
        Log.v("WBY", "ch***" + ch);
        sl = sw - cw;
        st = sh - ch;
        sb = sh + ch;
        sr = sw + cw;
    }*/

    private void handlerRandomView(View v) {
        final StellarMap map = (StellarMap) v.findViewById(R.id.sm);
/*      //map.setInnerPadding(0, 0, 0, getActivity().getWindowManager().getDefaultDisplay().getHeight() / 2);
        //Log.v("WBY", "test--1->" + getActivity().getWindowManager().getDefaultDisplay().getHeight()+"--"+getActivity().getWindowManager().getDefaultDisplay().getWidth());
        Point point = new Point();
        getActivity().getWindowManager().getDefaultDisplay().getSize(point);
        Log.v("WBY", "test--2->" + point.y + "--" + point.x);*/
        map.setInnerPadding(20, 20, 20, 20);
        map.setRegularity(15, 20);
        final RecommendAdapter recommendAdapter = new RecommendAdapter();
        map.setAdapter(recommendAdapter);

        // 第一页
        map.setGroup(0, true);

        mShakeListener = new ShakeListener(getActivity());
        mShakeListener.setOnShakeListener(new ShakeListener.OnShakeListener() {
            @Override
            public void onShake() {
                int currentGroup = map.getCurrentGroup();
                if (currentGroup == recommendAdapter.getGroupCount() - 1) {
                    currentGroup = 0;
                } else {
                    currentGroup++;
                }
                map.setGroup(currentGroup, true);
            }
        });
    }

    @Override
    public void onPause() {
        if (mShakeListener != null) {
            mShakeListener.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        if (mShakeListener != null) {
            mShakeListener.resume();
        }
        super.onResume();
    }

    private class RecommendAdapter implements StellarMap.Adapter {
        private static final int PAGE_SIZE = 15;

        @Override
        public int getGroupCount() {
            if (mDatas.size() % PAGE_SIZE == 0) {
                return mDatas.size() / PAGE_SIZE;
            } else {
                return mDatas.size() / PAGE_SIZE + 1;
            }
        }

        @Override
        public int getCount(int group) {
            if (mDatas.size() % PAGE_SIZE == 0) {
                return PAGE_SIZE;
            } else {
                // 如果是最后一组,返回真实个数,否则返回个数常量
                if (group == getGroupCount() - 1) {
                    return mDatas.size() % PAGE_SIZE;
                } else {
                    return PAGE_SIZE;
                }
            }
        }

        @Override
        public View getView(int group, int position, View convertView) {
/*            Log.v("WBY", "fl---->" + mFlHeight + "---" + mFlWidth);
            Log.v("WBY", "Iv---->" + mIvHeight + "---" + mIvWidth);
            int ivWidth = mIvWidth / 2 + 50;
            int ivHeight = mIvHeight / 2 + 50;

            int flHeight = mFlHeight / 2;
            int flWidth = mFlWidth / 2;*/
/*            final int sl = flWidth - ivWidth;
            final int st = flHeight - ivHeight;
            final int sb = flHeight + ivHeight;
            final int sr = flWidth + ivWidth;*/

            final TextView tv = new TextView(getActivity().getApplicationContext());

            int index = group * PAGE_SIZE + position;
            final String data = mDatas.get(index);

            // 随机字体大小颜色
            tv.setTextSize(new Random().nextInt(22) + 12);
            int argb = getRandomColor();

            tv.setTextColor(argb);
            tv.setText(data);
            tv.setClickable(true);
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity().getApplicationContext(), "[ " + data + " ]", Toast.LENGTH_SHORT).show();
                }
            });
            tv.post(new Runnable() {
                @Override
                public void run() {
                   /* int[] locations = new int[2];
                    tv.getLocationOnScreen(locations);
                    int width = tv.getWidth();
                    int height = tv.getHeight();
                    int l = locations[0];
                    int t = locations[1];
                    int b = t + height;
                    int r = l + width;*/

                    int l = tv.getLeft();
                    int t = tv.getTop();
                    int b = tv.getBottom();
                    int r = tv.getRight();

                    //Log.v("WBY", "L AND T--->" + l + "_____" + t);
                    //Log.v("WBY", "width AND height--->" + width + "_____" + height);
                    //Log.v("WBY", "l-t-r-b" + l + "---" + t + "----" + r + "---" + b);
                    //Log.v("WBY", "sl-t-r-b" + sl + "---" + st + "----" + sr + "---" + sb);
                    // 左上
                    if (l >= sl && t >= st && l <= sr && t <= sb) {
                        tv.setVisibility(View.GONE);
                    }
                    // 左下
                    if (l >= sl && b >= st && l <= sr && b <= sb) {
                        tv.setVisibility(View.GONE);
                    }
                    // 右上
                    if (r >= sl && t >= st && r <= sr && t <= sb) {
                        tv.setVisibility(View.GONE);
                    }
                    // 右下
                    if (r >= sl && b >= st && r <= sr && b <= sb) {
                        tv.setVisibility(View.GONE);
                    }
                }
            });
            return tv;
        }

        private int getRandomColor() {
            Random random = new Random();
            int alpha = random.nextInt(226) + 30;
            int red = random.nextInt(236) + 10;
            int green = random.nextInt(236) + 10;
            int blue = random.nextInt(236) + 10;
            return Color.argb(alpha, red, green, blue);
        }

        @Override
        public int getNextGroupOnPan(int group, float degree) {
            return 0;
        }

        @Override
        public int getNextGroupOnZoom(int group, boolean isZoomIn) {
            return 0;
        }
    }
}
