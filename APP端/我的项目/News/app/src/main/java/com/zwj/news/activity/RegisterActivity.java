package com.zwj.news.activity;

import android.content.Intent;
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
import com.zwj.news.entity.RegisterResponse;
import com.zwj.news.util.StringUtils;

import java.util.HashMap;

public class RegisterActivity extends BaseActivity {

    private EditText etAccount;
    private EditText etPwd;
    private Button btnResiter;

    @Override
    protected int initLayout() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {
        etAccount = findViewById(R.id.et_account);
        etPwd = findViewById(R.id.et_pwd);
        btnResiter = findViewById(R.id.btn_register);
    }

    @Override
    protected void initData() {
        btnResiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = etAccount.getText().toString().trim();
                String pwd = etPwd.getText().toString().trim();
                register(account, pwd);
            }
        });
    }

    private void register(String account, String pwd) {
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
        Api.config(ApiConfig.REGISTER, params).postRequest(this,new TtitCallback() {
            @Override
            public void onSuccess(final String res) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                       System.out.println(res);
                        Gson gson = new Gson();
                        RegisterResponse registerResponse = gson.fromJson(res, RegisterResponse.class);
                        if (registerResponse.getCode().equals("200")) {

                            navigateToWithFlag(LoginActivity.class,
                                    Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            showToastSync("注册成功");
                        } else if(registerResponse.getCode().equals("600")){
                            showToastSync("用户名重复");
                        }else{
                            showToastSync("登录失败");
                        }

                    }
                });
            }

            @Override
            public void onFailure(Exception e) {
                Log.e("onFailure", e.toString());
            }
        });
    }
}