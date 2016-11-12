package com.lhr.mdt1.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lhr.mdt1.R;

/**
 * Created by 发条橙 on 2016/11/1.
 */

public class SnackBarActivity extends AppCompatActivity {
    private FloatingActionButton mFloatingActionButton;
    private CoordinatorLayout mCoordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snackbar);

        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.layoutRoot);
        mFloatingActionButton = (FloatingActionButton) findViewById(R.id.fab);

        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar mSnackbar = Snackbar.make(mCoordinatorLayout, "Hello Snackbar LHR", Snackbar.LENGTH_SHORT).setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("Snckbar", "OK");
                    }
                });
                setSnackbarColor(mSnackbar, Color.BLACK,Color.BLUE);
                SnackbarAddView(mSnackbar,R.layout.snackbaricon,0);
                mSnackbar.show();

            }
        });

    }


    //更改Snackbar字体颜色，背景颜色
    public static void setSnackbarColor(Snackbar Snackbar, int TextColorColor, int backgroundColor) {
        View view = Snackbar.getView();
        if (view != null) {
            view.setBackgroundColor(backgroundColor);
            //获取Snackbar的message控件，修改字体颜色
            ((TextView) view.findViewById(R.id.snackbar_text)).setTextColor(TextColorColor);
        }

    }
    //为Snackbar添加图标
    public static void SnackbarAddView(Snackbar snackbar,int layoutId,int index){
        View snackbarview = snackbar.getView();//获取snackbar的View(其实就是SnackbarLayout)
        Snackbar.SnackbarLayout snackbarLayout=(Snackbar.SnackbarLayout)snackbarview;//将获取的View转换成SnackbarLayout
        View add_view = LayoutInflater.from(snackbarview.getContext()).inflate(layoutId,null);//加载布局文件新建View
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);//设置新建布局参数
        p.gravity= Gravity.CENTER_VERTICAL;//设置新建布局在Snackbar内垂直居中显示
        snackbarLayout.addView(add_view,index,p);//将新建布局添加进snackbarLayout相应位置
    }
}
