package com.zwj.news;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.zwj.news.activity.BaseActivity;
import com.zwj.news.activity.HomeActivity;
import com.zwj.news.activity.LoginActivity;
import com.zwj.news.activity.RegisterActivity;
import com.zwj.news.util.StringUtils;

public class MainActivity extends BaseActivity {

    private Button btnLogin;
    private Button btnRegister;

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        btnLogin = findViewById(R.id.btn_login);
        btnRegister = findViewById(R.id.btn_register);
    }

    @Override
    protected void initData() {
//        if (!StringUtils.isEmpty(findByKey("token"))) {
//            navigateTo(HomeActivity.class);
//            finish();

//        }
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent in = new Intent(MainActivity.this, LoginActivity.class);
//                startActivity(in);
                navigateTo(LoginActivity.class);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent in = new Intent(MainActivity.this, RegisterActivity.class);
//                startActivity(in);
                navigateTo(RegisterActivity.class);
            }
        });
    }
}