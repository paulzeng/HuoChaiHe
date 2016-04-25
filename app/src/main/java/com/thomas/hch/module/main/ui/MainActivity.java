package com.thomas.hch.module.main.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.thomas.hch.R;
import com.thomas.hch.base.BaseFragment;
import com.thomas.hch.module.home.ui.HomeFragment;
import com.thomas.hch.module.hotfeed.ui.HotFeedFragment;
import com.thomas.hch.module.message.ui.MessageFragment;
import com.thomas.hch.module.my.ui.MyFragment;
import com.thomas.hch.module.topic.ui.TopicFragment;
import com.thomas.hch.utils.LogUtil;
import com.thomas.hch.views.ControlScrollViewPager;
import com.thomas.hch.views.TitleBar;
import com.umeng.comm.core.CommunitySDK;
import com.umeng.comm.core.impl.CommunityFactory;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.title_bar)
    TitleBar mTitleBar;
    @Bind(R.id.contentPager)
    ControlScrollViewPager mViewPager;
    @Bind(R.id.iv_home)
    ImageView mIvHome;
    @Bind(R.id.iv_topic)
    ImageView mIvTopic;
    @Bind(R.id.iv_message)
    ImageView mIvMessage;
    @Bind(R.id.iv_hot)
    ImageView mIvHot;
    @Bind(R.id.iv_my)
    ImageView mIvMy;
    CommunitySDK mCommSDK = null;
    private HomeFragment homeFragment;
    private TopicFragment topicFragment;
    private BaseFragment messageFragment,hotFragment,myFragment;
    List<Fragment> fragments = new ArrayList<Fragment>();
    private FragmentPagerAdapter pagerAdapter;
    // 当前fragment的index
    private int currentTabIndex;
    private int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        // 1、初始化友盟微社区
        mCommSDK = CommunityFactory.getCommSDK(this);
        mCommSDK.initSDK(this);
        initView();
    }

    private void initView() {
        mIvHome.setSelected(true);
        setHomeTab();
        homeFragment = new HomeFragment();
        topicFragment = new TopicFragment();
        messageFragment = new MessageFragment();
        hotFragment = new HotFeedFragment();
        myFragment = new MyFragment();
        fragments.add(homeFragment);
        fragments.add(topicFragment);
        fragments.add(messageFragment);
        fragments.add(hotFragment);
        fragments.add(myFragment);
        pagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        };
        mViewPager.setNoScroll(true);
        mViewPager.setAdapter(pagerAdapter);
        mViewPager.setOffscreenPageLimit(4);
    }

    private void setHomeTab(){
        mTitleBar.setTitle(0, "", "首页", 0, "", null, null);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtil.e("restart", "onRestart");
        mViewPager.setCurrentItem(currentTabIndex);
    }

    @OnClick({R.id.iv_home, R.id.iv_topic, R.id.iv_message, R.id.iv_hot, R.id.iv_my})
    public void onClick(View view) {
        mIvHome.setSelected(false);
        mIvTopic.setSelected(false);
        mIvMessage.setSelected(false);
        mIvHot.setSelected(false);
        mIvMy.setSelected(false);
        switch (view.getId()) {
            case R.id.iv_home:
                mTitleBar.setTitle("首页");
                index = 0;
                mIvHome.setSelected(true);
                mTitleBar.removeAllActions();
                break;
            case R.id.iv_topic:
                mTitleBar.setTitle("话题");
                index = 1;
                mIvTopic.setSelected(true);
                mTitleBar.removeAllActions();
                break;
            case R.id.iv_message:
                mTitleBar.setTitle("消息");
                index = 2;
                mIvMessage.setSelected(true);
                mTitleBar.removeAllActions();
                break;
            case R.id.iv_hot:
                mTitleBar.setTitle("热门");
                index = 3;
                mIvHot.setSelected(true);
                mTitleBar.removeAllActions();
                break;
            case R.id.iv_my:
                mTitleBar.setTitle("我的");
                index = 4;
                mIvMy.setSelected(true);
                mTitleBar.removeAllActions();
                break;
        }
        if (currentTabIndex != index) {
            mViewPager.setCurrentItem(index);
        }
        currentTabIndex = index;
    }
}
