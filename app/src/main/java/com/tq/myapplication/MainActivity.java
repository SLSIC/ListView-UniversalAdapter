package com.tq.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Menu;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;
import com.tq.adapter.ListViewAdapter;
import com.tq.bean.ItemBean;
import com.tq.bean.SpecialBean;
import com.tq.template.LayoutDatasEntity;
import com.tq.util.ClickProxyUtil;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;
import timber.log.Timber;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private TextView mTV;
    private Button mBtn_proxy;
    private Button mBtn_okgo;
    private Button mBtn_anim;
    private Button mBtn_permission;
    private Button mBtn_design_mode;
    private ListView mLv;
    private ListViewAdapter mAdapter;
    private Toast mToast;
    private android.support.v7.app.ActionBar mBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setClickProxy();
        initDatas();

        mBar = getSupportActionBar();
        // setOverflowShowingAlways();

        mToast = Toast.makeText(getApplicationContext(), "确认退出?", Toast.LENGTH_SHORT);
    }

    private void initDatas() {
        List<ItemBean> datas = new ArrayList<>();
        int length = 50;
        for (int i = 0; i < length; i++) {
            ItemBean itemBean = new ItemBean("WBY", "莫听穿林打叶声", "2015-05-04", "445577" + i);
            datas.add(itemBean);
        }
        if (mAdapter == null) {
            mAdapter = new ListViewAdapter(this, new LayoutDatasEntity(R.layout.header, getHeaderDatas()), new LayoutDatasEntity(R.layout.item_lv, datas));
        }
        mLv.setAdapter(mAdapter);
    }

    private List<SpecialBean> getHeaderDatas() {
        List<SpecialBean> datas = new ArrayList<>();
        int length = 5;
        for (int i = 0; i < length; i++) {
            SpecialBean itemBean = new SpecialBean("YBW", "春江花月夜", "2015-05-04");
            datas.add(itemBean);
        }
        return datas;
    }

    private void setClickProxy() {
        mBtn_proxy.setOnClickListener(this);
        mBtn_anim.setOnClickListener(this);
        mBtn_okgo.setOnClickListener(this);
        mBtn_permission.setOnClickListener(this);
        mBtn_design_mode.setOnClickListener(this);

        getWindow().getDecorView().post(new Runnable() {
            @Override
            public void run() {
                ClickProxyUtil.getInstance().clickProxy(mBtn_proxy, mBtn_okgo, mBtn_anim, mBtn_permission, mBtn_design_mode);
            }
        });
    }

    private void initView() {
        mLv = (ListView) findViewById(R.id.lv);
        mLv.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == SCROLL_STATE_IDLE) {
                    if (mBar != null) {
                        mBar.show();
                    }
                } else {
                    if (mBar != null) {
                        mBar.hide();
                    }
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });
        mLv.addHeaderView(initHeaderView());
        mLv.addHeaderView(View.inflate(this, R.layout.item_lv, null));
    }

    @NonNull
    private View initHeaderView() {
        View v = View.inflate(this, R.layout.header_view, null);
        mTV = (TextView) v.findViewById(R.id.tv);
        mBtn_proxy = (Button) v.findViewById(R.id.btn_proxy);
        mBtn_anim = (Button) v.findViewById(R.id.btn_anim);
        mBtn_okgo = (Button) v.findViewById(R.id.btn_okgo);
        mBtn_permission = (Button) v.findViewById(R.id.btn_permission);
        mBtn_design_mode = (Button) v.findViewById(R.id.btn_design_mode);
        return v;
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btn_proxy:
                Toast.makeText(this, "           签名短信保存成功!\n将在24小时内审核通过后生效!", Toast.LENGTH_SHORT).show();
                Timber.v("btn--->onClick");
                break;
            case R.id.btn_okgo:
                OkGo
                        .get("http://119.37.199.222:9003/fujian/Service.asmx/getWelcomeModel")
                        .tag(this)
                        .cacheKey("TEST")
                        .cacheMode(CacheMode.DEFAULT)
                        .execute(new StringCallback() {
                            @Override
                            public void onSuccess(String s, Call call, Response response) {
                                Timber.v("OKGO-->click");
                                mTV.setText(s);
                            }
                        });
                break;
            case R.id.btn_anim:
                intent = new Intent(this, AnimLottie.class);
                startActivityForResult(intent, -1);
                Timber.v("btn_anim--->onClick");
                break;
            case R.id.btn_permission:
                intent = new Intent(this, PermissionActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_design_mode:
                intent = new Intent(this, DesignModeActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (mToast.getView().getParent() == null) {
            mToast.show();
        } else {
            System.exit(0);
        }
    }

    @Override
    protected void onStart() {
        Timber.v("WBY--->onStart");
        super.onStart();
    }

    @Override
    protected void onRestart() {
        Timber.v("WBY--->onRestart");
        super.onRestart();
    }

    @Override
    protected void onPause() {
        Timber.v("WBY--->onPause");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Timber.v("WBY--->onResume");
        super.onResume();
    }

    @Override
    protected void onStop() {
        Timber.v("WBY--->onStop");
        super.onStop();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Timber.v("WBY--main->onActivityResult");
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    private void setOverflowShowingAlways() {
        try {
            ViewConfiguration config = ViewConfiguration.get(this);
            Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            menuKeyField.setAccessible(true);
            menuKeyField.setBoolean(config, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
