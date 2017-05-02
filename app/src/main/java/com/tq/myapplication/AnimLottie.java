package com.tq.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class AnimLottie extends BaseActivity implements View.OnClickListener {
    private TextView tab_tv1;
    private TextView tab_tv2;
    private TextView tab_tv3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_lottie);
        initView();
    }

    private void initView() {
        tab_tv1 = (TextView) findViewById(R.id.tab_tv1);
        tab_tv1.setOnClickListener(this);
        tab_tv2 = (TextView) findViewById(R.id.tab_tv2);
        tab_tv2.setOnClickListener(this);
        tab_tv3 = (TextView) findViewById(R.id.tab_tv3);
        tab_tv3.setOnClickListener(this);
    }

    @Override
    @SuppressWarnings("deprecation")
    public void onClick(View v) {
        tab_tv1.setTextColor(Color.parseColor("#FF888888"));
        tab_tv2.setTextColor(Color.parseColor("#FF888888"));
        tab_tv3.setTextColor(Color.parseColor("#FF888888"));
        tab_tv1.setBackgroundDrawable(AnimLottie.this.getResources().getDrawable(R.drawable.tab_normal));
        tab_tv2.setBackgroundDrawable(AnimLottie.this.getResources().getDrawable(R.drawable.tab_normal));
        tab_tv3.setBackgroundDrawable(AnimLottie.this.getResources().getDrawable(R.drawable.tab_normal));
        switch (v.getId()) {
            case R.id.tab_tv1:
                Toast.makeText(this, "tab1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tab_tv2:
                Toast.makeText(this, "tab2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tab_tv3:
                Toast.makeText(this, "tab3", Toast.LENGTH_SHORT).show();
                break;
        }
        ((TextView) v).setTextColor(Color.parseColor("red"));
        v.setBackgroundDrawable(AnimLottie.this.getResources().getDrawable(R.drawable.tab_selected));
    }
}
