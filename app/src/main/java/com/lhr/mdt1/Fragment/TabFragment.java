package com.lhr.mdt1.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lhr.mdt1.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 发条橙 on 2016/11/1.
 */

public class TabFragment extends Fragment {
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private List<Fragment> fragmentList;
    private String[] titles = new String[]{"Tab1", "Tab2", "Tab3", "Tab4", "Tab5"};

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_tabs, null);
        initView(view);
        return view;


    }

    private void initView(View view) {
        fragmentList = new ArrayList<Fragment>();
        fragmentList.add(new Fragment1());
        fragmentList.add(new Fragment2());
        fragmentList.add(new Fragment3());
        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        mViewPager.setAdapter(new FragAdapter(getActivity().getSupportFragmentManager()));
        mTabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        mTabLayout.setupWithViewPager(mViewPager);
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

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }

}
