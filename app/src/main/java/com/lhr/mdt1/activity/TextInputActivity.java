package com.lhr.mdt1.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import com.lhr.mdt1.R;

/**
 * Created by 发条橙 on 2016/11/2.
 */

public class TextInputActivity extends AppCompatActivity {
    private TextInputLayout usernameWrapper;
    private TextInputLayout passwordnameWrapper;
    private  Button login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textinput);
        usernameWrapper = (TextInputLayout) findViewById(R.id.usernameWrapper);
        passwordnameWrapper = (TextInputLayout) findViewById(R.id.passwordnameWrapper);
        login = (Button) findViewById(R.id.login);

        //Edittext默认的字符与点击后上移的字符，在XML设置也可以得到同样效果
        usernameWrapper.setHint("Username");
        passwordnameWrapper.setHint("Password");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard();
                String username = usernameWrapper.getEditText().getText().toString();
                String password = passwordnameWrapper.getEditText().getText().toString();
                if (!username.equals("lhr")){
                    usernameWrapper.setError("您的ID输入错误");
                }else if (!password.equals("123456")){
                    passwordnameWrapper.setError("您的密码输入错误");
                } else {
                    usernameWrapper.setErrorEnabled(false);
                    passwordnameWrapper.setErrorEnabled(false);
                    finish();
                }

            }
        });

    }
    private void hideKeyboard(){
       View view = getCurrentFocus();
        if (view == null){
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).
                    hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}
