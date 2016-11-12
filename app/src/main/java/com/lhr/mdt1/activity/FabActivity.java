package com.lhr.mdt1.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lhr.mdt1.Adapter.NormalRecyclerViewAdapter;
import com.lhr.mdt1.R;

/**
 * Created by 发条橙 on 2016/11/3.
 */

public class FabActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fab);
        RecyclerView mRecycerView = (RecyclerView) findViewById(R.id.lvToDoList);
        //设置为线性布局
        mRecycerView.setLayoutManager(new LinearLayoutManager(this));
        mRecycerView.setAdapter(new NormalRecyclerViewAdapter(this));
    }
}
