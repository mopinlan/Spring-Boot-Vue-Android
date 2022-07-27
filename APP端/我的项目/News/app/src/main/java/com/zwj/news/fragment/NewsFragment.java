package com.zwj.news.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import com.zwj.news.R;
import com.zwj.news.activity.LoginActivity;

import com.zwj.news.activity.WebActivity;
import com.zwj.news.adapter.NewsAdapter;
import com.zwj.news.api.Api;
import com.zwj.news.api.ApiConfig;
import com.zwj.news.api.TtitCallback;
import com.zwj.news.entity.NewsEntity;
import com.zwj.news.entity.NewsListResponse;
import com.zwj.news.util.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NewsFragment extends BaseFragment {
    private int categoryId;
    private String title;
    private RecyclerView recyclerView;
    private NewsAdapter newsAdapter;
    private List<NewsEntity> datas = new ArrayList<>();
    private LinearLayoutManager linearLayoutManager;
    private RefreshLayout refreshLayout;
    private int pageNum = 1;
    private String newsTitle;

    public void setData(String string) {
        newsTitle=string;
    }
    public NewsFragment() {

    }

    //Handler:异步通信，线程之间的通信
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    newsAdapter.setDatas(datas);
                    //动态更新ListView
                    newsAdapter.notifyDataSetChanged();
                    recyclerView.setAdapter(newsAdapter);
                    break;
            }
        }
    };

    //传递新闻分类id
    public static NewsFragment newInstance(int categoryId) {
        NewsFragment fragment = new NewsFragment();
        fragment.categoryId = categoryId;
        return fragment;
    }


    @Override
    protected int initLayout() {
        return R.layout.fragment_video;
    }

    @Override
    protected void initView() {
        recyclerView = mRootView.findViewById(R.id.recyclerView);
        refreshLayout = mRootView.findViewById(R.id.refreshLayout);
    }

    @Override
    protected void initData() {
        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        newsAdapter = new NewsAdapter(getActivity());
        recyclerView.setAdapter(newsAdapter);
        //点击列表
        newsAdapter.setOnItemClickListener(new NewsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Serializable obj) {
                Log.e("点击", "点击");
                NewsEntity newsEntity = (NewsEntity) obj;
                String url = "http://47.116.21.234/newsDetail?newsid=" + ((NewsEntity) obj).getId() + "&userid=" + findByKey("userid");
                Log.e("url", url);
                // String url="www.baidu.com";
                Bundle bundle = new Bundle();
                bundle.putString("url", url);
                navigateToWithBundle(WebActivity.class, bundle);
            }
        });
        //刷新
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {

                pageNum = 1;
                getVideoList(true);
                Log.e("刷新", pageNum + "");

            }
        });
        //下拉
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshlayout) {
                pageNum++;
                getVideoList(false);
                Log.e("加载", pageNum + "");
            }
        });
        getVideoList(true);
    }

    private void getVideoList(final Boolean isRefresh) {
        String token = findByKey("token");
        if (!StringUtils.isEmpty(token)) {
            HashMap<String, Object> params = new HashMap<>();
            //   params.put("token", token);
            params.put("pageNum", pageNum);
            params.put("pageSize", ApiConfig.PAGE_SIZE);
            params.put("title", "");
            params.put("categoryId", categoryId);
            Api.config(ApiConfig.News_LIST_BY_CATEGORY, params).getRequest(getActivity(), new TtitCallback() {
                @Override
                public void onSuccess(final String res) {
                    if (isRefresh) {
                        refreshLayout.finishRefresh(true);
                    } else {
                        refreshLayout.finishLoadMore(true);
                    }
                    NewsListResponse response = new Gson().fromJson(res, NewsListResponse.class);
                    Log.e("NewsListResponse",response.toString());
                    if (response != null && response.getCode().equals("200")) {
                        List<NewsEntity> list = response.getData().getRecords();
                        if (list != null && list.size() > 0) {
                            if (isRefresh) {
                                datas = list;
                            } else {
                                datas.addAll(list);
                            }
                            mHandler.sendEmptyMessage(0);
                        } else {
                            if (isRefresh) {
                                Log.e("暂时无数据", "暂时无数据");
                                showToastSync("暂时无数据");
                            } else {
                                Log.e("没有更多数据了", "没有更多数据了");
                                showToastSync("没有更多数据了");
                            }
                        }
//
                    }
//
                }

                @Override
                public void onFailure(Exception e) {
                    if (isRefresh) {
                        refreshLayout.finishRefresh(true);
                    } else {
                        refreshLayout.finishLoadMore(true);
                    }
                }
            });
        } else {
            navigateTo(LoginActivity.class);
        }

    }
}