package com.tq.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by LB
 * E-mail：lb@tqscsoft.com
 * Time: 2017/3/27
 * Desc:
 */

public class PermissionActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtn_requestPer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);
        initView();
    }

    private void initView() {
        mBtn_requestPer = (Button) findViewById(R.id.btn_requestPer);
        mBtn_requestPer.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_requestPer:

                break;
        }
    }
}
