package com.lhr.mdt1.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lhr.mdt1.Adapter.NormalRecyclerViewAdapter;
import com.lhr.mdt1.R;

/**
 * Created by 发条橙 on 2016/11/3.
 */

public class CoordinatorLayout extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cdl);
        RecyclerView rv = (RecyclerView) findViewById(R.id.cdl_recyclerView);
       CollapsingToolbarLayout collapsing_toolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsing_toolbar.setTitle("Title");
        //设置为线性布局
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new NormalRecyclerViewAdapter(this));

    }
}
