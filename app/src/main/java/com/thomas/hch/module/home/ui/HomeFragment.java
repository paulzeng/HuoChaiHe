package com.thomas.hch.module.home.ui;

import android.widget.TextView;

import com.umeng.comm.core.utils.ResFinder;
import com.umeng.comm.ui.fragments.FriendsFragment;
import com.umeng.comm.ui.fragments.RealTimeFeedFragment;
import com.umeng.comm.ui.imagepicker.presenter.impl.FriendFeedPresenter;
import com.umeng.comm.ui.imagepicker.presenter.impl.RealTimeFeedPresenter;

/**
 * @author 曾文韬
 * @version $Rev$
 * @time 2016/4/23 15:49
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
public class HomeFragment extends FriendsFragment {
    public HomeFragment() {

    }

    @Override
    protected FriendFeedPresenter createPresenters() {
        return new RealTimeFeedPresenter(this);
    }

    @Override
    protected void initWidgets() {
        super.initWidgets();
        TextView titleTextView = (TextView) mRootView.findViewById(ResFinder
                .getId("umeng_comm_title_tv"));
        titleTextView.setText(ResFinder.getString("umeng_comm_realtime")); // 实时内容
    }

    public static RealTimeFeedFragment newRealTimeFeedRecommend() {
        return new RealTimeFeedFragment();
    }
}
