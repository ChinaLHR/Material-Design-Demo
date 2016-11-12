package com.lhr.mdt1.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lhr.mdt1.R;

/**
 * Created by 发条橙 on 2016/11/1.
 */

public class Fragment5 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.vp_item2, container, false);
        return view;
    }
}
