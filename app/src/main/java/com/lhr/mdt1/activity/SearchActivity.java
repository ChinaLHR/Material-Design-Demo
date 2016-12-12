package com.lhr.mdt1.activity;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.widget.Toast;

import com.lhr.mdt1.R;


/**
 * Created by 发条橙 on 2016/12/12.
 */

public class SearchActivity extends AppCompatActivity {
    private android.support.v7.widget.SearchView search;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        this.search = (SearchView) findViewById(R.id.search);
        SearchManager mSearchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        search.setSearchableInfo(mSearchManager.getSearchableInfo(getComponentName()));
        /**
         * 接收查询Activity传进来的数据
         */
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())){
            String query = intent.getStringExtra(SearchManager.QUERY);
           show(query);
        }
        //开启输入文字的清除与查询按钮
        search.setSubmitButtonEnabled(true);
        //设置hint
        search.setQueryHint("请输入关键字");
        //设置默认打开
        search.onActionViewExpanded();

        //查询监听
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            //点击查询按钮
            @Override
            public boolean onQueryTextSubmit(String query) {
                show(query);
                return true;
            }
            //查询框文字发送发生变化
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private void show(String str) {
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
    }
}
