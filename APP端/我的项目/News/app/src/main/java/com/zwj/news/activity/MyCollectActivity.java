package com.zwj.news.activity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.zwj.news.R;
import com.zwj.news.adapter.MyCollectAdapter;
import com.zwj.news.adapter.MyCollectAdapterFirst;
import com.zwj.news.adapter.NewsAdapter;
import com.zwj.news.api.Api;
import com.zwj.news.api.ApiConfig;
import com.zwj.news.api.TtitCallback;
import com.zwj.news.entity.CommentEntity;
import com.zwj.news.entity.MyCollectResponse;
import com.zwj.news.entity.NewsEntity;
import com.zwj.news.listener.OnItemChildClickListener;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MyCollectActivity extends BaseActivity  {
    private RecyclerView recyclerView;
    private MyCollectAdapterFirst newsAdapter;
    private List<CommentEntity> datas = new ArrayList<>();
    private LinearLayoutManager linearLayoutManager;


    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    newsAdapter.setDatas(datas);
                    newsAdapter.notifyDataSetChanged();
                    recyclerView.setAdapter(newsAdapter);
                    break;
            }
        }
    };

    @Override
    protected int initLayout() {
        return R.layout.activity_mycollect;
    }

    @Override
    protected void initView() {
        recyclerView = findViewById(R.id.recyclerView);
    }

    @Override
    protected void initData() {
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        newsAdapter = new MyCollectAdapterFirst(this);
        newsAdapter.setOnItemChildClickListener(this);
        recyclerView.setAdapter(newsAdapter);
        newsAdapter.setOnItemClickListener(new MyCollectAdapterFirst.OnItemClickListener() {
            @Override
            public void onItemClick(Serializable obj) {
                Log.e("点击","点击");
                CommentEntity newsEntity=(CommentEntity) obj;
                String url="http://47.116.21.234/newsDetail?newsid="+((CommentEntity) obj).getNews().getId()+"&userid="+findByKey("userid");
                Log.e("url",url);
                // String url="www.baidu.com";
                Bundle bundle=new Bundle();
                bundle.putString("url",url);

                navigateToWithBundle(WebActivity.class,bundle);
            }
        });
        getVideoList();
    }

    private void getVideoList() {
        HashMap<String, Object> params = new HashMap<>();

        Api.config(ApiConfig.Comment_List+findByKey("userid"), params).getRequest(this, new TtitCallback() {

            @Override
            public void onSuccess(final String res) {
                Log.e("res", res.toString());
                MyCollectResponse response = new Gson().fromJson(res, MyCollectResponse.class);

                if (response != null && response.getCode().equals("200")) {
                    List<CommentEntity> list = response.getData();
                    if (list != null && list.size() > 0) {
                            datas=list;
                        mHandler.sendEmptyMessage(0);
                    }
                }
            }

            @Override
            public void onFailure(Exception e) {
            }
        });
    }



}
