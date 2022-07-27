package com.zwj.news.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import com.squareup.picasso.Picasso;
import com.zwj.news.R;
import com.zwj.news.activity.HomeActivity;
import com.zwj.news.activity.LoginActivity;
import com.zwj.news.activity.MyCollectActivity;
import com.zwj.news.activity.MyImforActivity;
import com.zwj.news.activity.WebActivity;
import com.zwj.news.api.Api;
import com.zwj.news.api.ApiConfig;
import com.zwj.news.api.TtitCallback;
import com.zwj.news.entity.LoginResponse;
import com.zwj.news.entity.NewsEntity;
import com.zwj.news.entity.NewsListResponse;
import com.zwj.news.entity.UserEntity;
import com.zwj.news.entity.UserResponse;
import com.zwj.news.view.CircleTransform;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


public class MyFragment extends BaseFragment {

    @BindView(R.id.img_header)
    ImageView imgHeader;
    @BindView(R.id.img_headerText)
    TextView img_headerText;
    @BindView(R.id.img_header_text2)
    TextView img_headerText2;
    @BindView(R.id.refreshLayout)
    RefreshLayout refreshLayout;
private UserResponse userResponse;
    public MyFragment() {
    }
    //Handler:异步通信，线程之间的通信
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    img_headerText.setText(userResponse.getData().getUsername());
                    img_headerText2.setText(userResponse.getData().getAddress());
                    Picasso.with(getActivity()).load(userResponse.getData().getAvatarUrl()).placeholder(R.mipmap.header).error(R.mipmap.header).into(imgHeader);
                    break;
            }
        }
    };
    public static MyFragment newInstance() {
        MyFragment fragment = new MyFragment();
        return fragment;
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        img_headerText.setText(findByKey("nickname"));
        img_headerText2.setText(findByKey("address"));
        Picasso.with(getActivity()).load(findByKey("avatarUrl")).placeholder(R.mipmap.header).error(R.mipmap.header).into(imgHeader);
        getUser(true);

    }
    private void getUser(final Boolean isRefresh){
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                HashMap<String, Object> params = new HashMap<String, Object>();
                Api.config("/user/username/" + findByKey("username"), params).getRequest(getActivity(), new TtitCallback() {
                    @Override
                    public void onSuccess(final String res) {
                        System.out.println(res);
                        if (isRefresh) {
                            refreshLayout.finishRefresh(true);
                        } else {
                            refreshLayout.finishLoadMore(true);
                        }
                        Gson gson = new Gson();
                        userResponse = gson.fromJson(res, UserResponse.class);
                        if(userResponse.getCode().equals("200")){
                            mHandler.sendEmptyMessage(0);

                        }else {
                            if (isRefresh) {
                                Log.e("暂时无数据", "暂时无数据");
                                showToastSync("暂时无数据");
                            }
                        }
//

                        Log.e("刷新", "刷新");

                    }

                    @Override
                    public void onFailure(Exception e) {
                        refreshLayout.finishRefresh();
                    }

                });

            }


        });
  }
    @OnClick({R.id.img_header, R.id.rl_urp,R.id.rl_collect, R.id.rl_book, R.id.rl_logout,R.id.rl_date,R.id.rl_tel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_header:
                String url2="http://47.116.21.234/myPerson?username="+findByKey("username");
                Bundle bundle2=new Bundle();
                bundle2.putString("url",url2);
                navigateToWithBundle(WebActivity.class,bundle2);
                break;
            case R.id.rl_urp:
                Log.e("点击","点击");
                String url="http://zj.njust.edu.cn/jwc/";
                Bundle bundle=new Bundle();
                bundle.putString("url",url);
                navigateToWithBundle(WebActivity.class,bundle);
                break;
            case R.id.rl_collect:
                navigateTo(MyCollectActivity.class);
                break;
            case R.id.rl_book:
                String url1="http://zj.njust.edu.cn/tsg/";
                Bundle bundle1=new Bundle();
                bundle1.putString("url",url1);
                navigateToWithBundle(WebActivity.class,bundle1);
                break;
            case R.id.rl_date:
                String dateUrl="http://zj.njust.edu.cn/2022/0307/c10343a107808/page.htm";
                Bundle dateBundle=new Bundle();
                dateBundle.putString("url",dateUrl);
                navigateToWithBundle(WebActivity.class,dateBundle);
                break;
            case R.id.rl_tel:
                String telUrl="http://zj.njust.edu.cn/6910/list.htm";
                Bundle telBundle=new Bundle();
                telBundle.putString("url",telUrl);
                navigateToWithBundle(WebActivity.class,telBundle);
                break;
            case R.id.rl_logout:
                removeByKey("token");
                navigateToWithFlag(LoginActivity.class,
                        Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                break;
        }
    }
}