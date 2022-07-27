package com.zwj.news.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.flyco.tablayout.SlidingTabLayout;
import com.google.gson.Gson;
import com.zwj.news.R;
import com.zwj.news.adapter.HomeAdapter;
import com.zwj.news.api.Api;
import com.zwj.news.api.ApiConfig;
import com.zwj.news.api.TtitCallback;
import com.zwj.news.entity.CategoryEntity;
import com.zwj.news.entity.CategoryListResponse;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomeFragment extends BaseFragment {
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private String[] mTitles;
    private ViewPager viewPager;
    private SlidingTabLayout slidingTabLayout;

    public HomeFragment() {
    }

    //创建HomeFragment
    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        viewPager = mRootView.findViewById(R.id.fixedViewPager);
        slidingTabLayout = mRootView.findViewById(R.id.slidingTabLayout);

    }


    @Override
    protected void initData() {
//
        getVideoCategoryList();

    }

    private void getVideoCategoryList() {
        HashMap<String, Object> params = new HashMap<>();
        Api.config(ApiConfig.News_CATEGORY_LIST, params).getRequest(getActivity(), new TtitCallback() {
            @Override
            public void onSuccess(final String res) {
                Log.e("News_CATEGORY_LIST",res);
                //创建一个新的线程，在新的线程中
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        CategoryListResponse response = new Gson().fromJson(res, CategoryListResponse.class);
                        if (response != null && response.getCode().equals("200")) {
                            List<CategoryEntity> list = response.getData();
                            if (list != null && list.size() > 0) {
                                //创建新闻分类的数组
                                mTitles = new String[list.size()];
                                for (int i = 0; i < list.size(); i++) {
                                    mTitles[i] = list.get(i).getType();
                                    mFragments.add(NewsFragment.newInstance(list.get(i).getId()));
                                }
                                //设置viewPager的预加载
                                viewPager.setOffscreenPageLimit(mFragments.size());
                                viewPager.setAdapter(new HomeAdapter(getFragmentManager(), mTitles, mFragments));
                                slidingTabLayout.setViewPager(viewPager);
                            }
                        }
                    }
                });
            }


            @Override
            public void onFailure(Exception e) {
            }
        });
    }
}