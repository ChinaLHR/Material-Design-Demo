package com.lhr.mdt1.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.lhr.mdt1.R;
import com.lhr.mdt1.View.SwipeRefreshView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 发条橙 on 2016/12/3.
 */

public class SwipeRefreshActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener,SwipeRefreshView.OnLoadListener{
    private  ListView refresh_lv;
    private SwipeRefreshView refresh_sfl ;
    private int mCount;
    private List<String> mList;
    private StringAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swiperefresh);
        refresh_lv = (ListView) findViewById(R.id.refresh_lv);
        refresh_sfl = (SwipeRefreshView) findViewById(R.id.refresh_sfl);
        initData();
        mAdapter = new StringAdapter();
        refresh_lv.setAdapter(mAdapter);

        //设置监听
        refresh_sfl.setOnRefreshListener(this);
        //设置下拉进度的背景颜色，默认就是白色的
        refresh_sfl.setProgressBackgroundColorSchemeResource(android.R.color.white);
        // 设置下拉进度的更新时主题颜色（松手）
        refresh_sfl.setColorSchemeResources(R.color.colorPrimary,R.color.colorAccent, R.color.colorPrimaryDark);

        refresh_sfl.setOnLoadListener(this);
    }

    private void initData() {
        mList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            mList.add("LHR" + i + "号");
            mCount++;
        }
    }


    //顶部下拉时会调用这个方法，在里面实现请求数据的逻辑，设置下拉进度条消失等等
    @Override
    public void onRefresh() {
        // 开始刷新，设置当前为刷新状态
        refresh_sfl.setRefreshing(true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mList.add(0,"LHR刷新出来的");
                mAdapter.notifyDataSetChanged();
                Toast.makeText(SwipeRefreshActivity.this,"刷新成功",Toast.LENGTH_SHORT).show();
                //设置刷新状态为关闭
                refresh_sfl.setRefreshing(false);
            }
        },2000);

    }

    @Override
    public void onLoad() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                // 添加数据
                for (int i = 0; i < 5; i++) {
                    mList.add("上拉加载更多的数据"+i);
                    // 这里要放在里面刷新，放在外面会导致刷新的进度条卡住
                    mAdapter.notifyDataSetChanged();
                }

                Toast.makeText(SwipeRefreshActivity.this, "加载了" + 5 + "条数据", Toast.LENGTH_SHORT).show();
                // 加载完数据设置为不加载状态，将加载进度收起来
                refresh_sfl.setLoading(false);
            }
        }, 3000);
    }

    /**
     * ListView适配器
     */
    private class StringAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public Object getItem(int position) {
            return mList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView==null){
                convertView = View.inflate(SwipeRefreshActivity.this,android.R.layout.simple_list_item_1,null);
            }
            TextView tv = (TextView)convertView;
            tv.setGravity(Gravity.CENTER);
            tv.setPadding(0,20,0,20);
            tv.setText(mList.get(position));
            return convertView;
        }
    }

}
