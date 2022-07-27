package com.zwj.news.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.google.gson.Gson;
import com.zwj.news.R;
import com.zwj.news.api.Api;
import com.zwj.news.api.ApiConfig;
import com.zwj.news.api.TtitCallback;
import com.zwj.news.entity.LoginResponse;
import com.zwj.news.fragment.MyFragment;
import com.zwj.news.util.AppConfig;
import com.zwj.news.util.StringUtils;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends BaseActivity {

    private EditText etAccount;
    private EditText etPwd;
    private Button btnLogin;

    @Override
    protected int initLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        etAccount = findViewById(R.id.et_account);
        etPwd = findViewById(R.id.et_pwd);
        btnLogin = findViewById(R.id.btn_login);
    }
//trim()：删除字符串首部和尾部的空格
    @Override
    protected void initData() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = etAccount.getText().toString().trim();
                String pwd = etPwd.getText().toString().trim();
                login(account, pwd);
            }
        });
    }

    private void login(String account, String pwd) {
        if (StringUtils.isEmpty(account)) {
            showToast("请输入账号");
            return;
        }
        if (StringUtils.isEmpty(pwd)) {
            showToast("请输入密码");
            return;
        }

        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("username", account);
        params.put("password", pwd);
        Api.config(ApiConfig.LOGIN, params).postRequest(this, new TtitCallback() {
            @Override
            public void onSuccess(final String res) {
                Log.e("onSuccess", res);
                Gson gson = new Gson();
                LoginResponse loginResponse = gson.fromJson(res, LoginResponse.class);
                Log.e("token",loginResponse.getData().getToken());
                Log.e("code",loginResponse.getCode());
                if (loginResponse.getCode().equals("200")) {
                    String token = loginResponse.getData().getToken();
                    insertVal("token", token);

                    insertVal("address", String.valueOf(loginResponse.getData().getAddress()));
                    insertVal("userid", String.valueOf(loginResponse.getData().getId()));
                    insertVal("username", String.valueOf(loginResponse.getData().getUsername()));
                    insertVal("avatarUrl",String.valueOf(loginResponse.getData().getAvatarUrl()));
                    insertVal("nickname", String.valueOf(loginResponse.getData().getNickname()));
                    Log.e("token",token);
                    navigateToWithFlag(HomeActivity.class,
                            Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    showToastSync("登录成功");
                } else {
                    showToastSync("登录失败");
                }
            }

            @Override
            public void onFailure(Exception e) {

            }


        });
    }
}