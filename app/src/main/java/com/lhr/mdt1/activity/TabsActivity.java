package com.lhr.mdt1.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.lhr.mdt1.Fragment.Fragment1;
import com.lhr.mdt1.Fragment.Fragment2;
import com.lhr.mdt1.Fragment.Fragment3;
import com.lhr.mdt1.Fragment.Fragment4;
import com.lhr.mdt1.Fragment.Fragment5;
import com.lhr.mdt1.R;

import java.util.ArrayList;
import java.util.List;

import static com.lhr.mdt1.R.id.tabLayout;

/**
 * Created by 发条橙 on 2016/11/1.
 */

public class TabsActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private List<Fragment> fragmentList;
    private String[] titles = new String[]{"Tab1", "Tab2", "Tab3", "Tab4", "Tab5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);
        initAdapter();
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(new FragAdapter(getSupportFragmentManager()));
        mTabLayout = (TabLayout) findViewById(tabLayout);
        //将TabLayout与ViewPager组合起来
        mTabLayout.setupWithViewPager(mViewPager);
        //为TabLayout的Tab设置图标
        TabLayout.Tab tabCall1 = mTabLayout.getTabAt(0);
        tabCall1.setIcon(R.drawable.tabselector);
        TabLayout.Tab tabCall2 = mTabLayout.getTabAt(1);
        tabCall2.setIcon(R.drawable.tabselector);
        TabLayout.Tab tabCall3 = mTabLayout.getTabAt(2);
        tabCall3.setIcon(R.drawable.tabselector);
        TabLayout.Tab tabCall4 = mTabLayout.getTabAt(3);
        tabCall4.setIcon(R.drawable.tabselector);
        TabLayout.Tab tabCall5 = mTabLayout.getTabAt(4);
        tabCall5.setIcon(R.drawable.tabselector);


    }

    private void initAdapter() {
        fragmentList = new ArrayList<Fragment>();
        fragmentList.add(new Fragment1());
        fragmentList.add(new Fragment2());
        fragmentList.add(new Fragment3());
        fragmentList.add(new Fragment4());
        fragmentList.add(new Fragment5());
    }

    class FragAdapter extends FragmentPagerAdapter {

        public FragAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        //返回Tag的标题
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }

}
