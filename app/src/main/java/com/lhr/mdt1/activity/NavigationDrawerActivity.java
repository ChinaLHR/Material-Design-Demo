package com.lhr.mdt1.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.lhr.mdt1.R;

/**
 * Created by 发条橙 on 2016/11/4.
 */

public class NavigationDrawerActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigationdrawer);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.id_drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.id_nv_menu);

        Toolbar toolbar = (Toolbar) findViewById(R.id.id_toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //开启侧滑
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });
        setupDrawerContent(mNavigationView);


    }
    private void setupDrawerContent(NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
           //记录点击过的menu，下次打开侧滑面板
            private MenuItem mPreMenuItem;
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (mPreMenuItem != null) mPreMenuItem.setChecked(false);
                item.setCheckable(true);
                mDrawerLayout.closeDrawers();
                mPreMenuItem = item;
                return true;
            }
        });
    }



}
