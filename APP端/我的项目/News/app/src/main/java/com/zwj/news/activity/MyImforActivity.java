package com.zwj.news.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.zwj.news.R;
import com.zwj.news.adapter.MyCollectAdapterFirst;
import com.zwj.news.api.Api;
import com.zwj.news.api.ApiConfig;
import com.zwj.news.api.TtitCallback;
import com.zwj.news.entity.CommentEntity;
import com.zwj.news.entity.MyCollectResponse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MyImforActivity extends BaseActivity  {

    @Override
    protected int initLayout() {
        return R.layout.activity_myinfor;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }






}
