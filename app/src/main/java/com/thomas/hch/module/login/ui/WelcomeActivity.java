package com.thomas.hch.module.login.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.thomas.hch.R;
import com.thomas.hch.base.BaseActivity;
import com.thomas.hch.module.main.ui.MainActivity;
import com.umeng.comm.core.utils.CommonUtils;

/**
 * @author 曾文韬
 * @version $Rev$
 * @time 2016/4/23 15:30
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
public class WelcomeActivity extends BaseActivity {
    @SuppressLint("HandlerLeak")
    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    Intent intent = null;
                    if (CommonUtils.isLogin(WelcomeActivity.this)) {
                        intent = new Intent(WelcomeActivity.this, MainActivity.class);
                    } else {
                        intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                    }
                    startActivity(intent);
                    finish();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        mHandler.sendEmptyMessageDelayed(0, 1500);
    }

    @Override
    public void onBackPressed() {
        mHandler.removeMessages(0);
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        mHandler.removeMessages(0);
        super.onDestroy();
    }

}

