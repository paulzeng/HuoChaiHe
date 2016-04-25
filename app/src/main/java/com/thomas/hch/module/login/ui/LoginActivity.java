package com.thomas.hch.module.login.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;
import com.thomas.hch.R;
import com.thomas.hch.base.BaseActivity;
import com.thomas.hch.bean.UserBean;
import com.thomas.hch.module.login.presenter.LoginPresenterImpl;
import com.thomas.hch.module.login.view.LoginView;
import com.thomas.hch.module.main.ui.MainActivity;
import com.thomas.hch.utils.LogUtil;
import com.thomas.hch.utils.ToastUtil;
import com.thomas.hch.views.TitleBar;
import com.umeng.comm.core.CommunitySDK;
import com.umeng.comm.core.beans.CommUser;
import com.umeng.comm.core.constants.ErrorCode;
import com.umeng.comm.core.impl.CommunityFactory;
import com.umeng.comm.core.login.LoginListener;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author 曾文韬
 * @version $Rev$
 * @time 2016/4/23 15:41
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
public class LoginActivity extends BaseActivity implements LoginView {
    public LoginPresenterImpl mLoginPresenter;
    //public static LoginListener sLoginListener;
    @Bind(R.id.title_bar)
    TitleBar mTitleBar;
    @Bind(R.id.et_login_username)
    EditText mEtUsername;
    @Bind(R.id.et_login_password)
    EditText mEtPassword;
    @Bind(R.id.btn_login)
    Button mBtnLogin;
    @Bind(R.id.login_progress)
    ProgressBar mProgressLogin;
    @Bind(R.id.tv_forget_pwd)
    TextView mTvForgetPwd;
    @Bind(R.id.tv_register)
    TextView mTvRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        StatusBarUtil.setColor(LoginActivity.this, getResources().getColor(R.color.statu_color), 0);

        //init
        mLoginPresenter = new LoginPresenterImpl(this);
        mLoginPresenter.setProgressBarVisiblity(View.INVISIBLE);
        mTitleBar.setTitle(0, "", "登录", 0, "", new View.OnClickListener()

                {
                    @Override
                    public void onClick(View v) {
                        ToastUtil.show(LoginActivity.this, "点击title左边");
                    }
                }

                , new View.OnClickListener()

                {
                    @Override
                    public void onClick(View v) {
                        ToastUtil.show(LoginActivity.this, "点击title右边");
                    }
                }

        );
    }


    @OnClick({R.id.btn_login, R.id.tv_forget_pwd, R.id.tv_register})
    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                if (TextUtils.isEmpty(mEtUsername.getText().toString().trim())) {
                    ToastUtil.show(this, "请输入手机号/用户名", 1 * 1000);
                    LogUtil.e("####", "帐号=" + mEtUsername.getText().toString().trim());
                    return;
                }
                if (TextUtils.isEmpty(mEtPassword.getText().toString().trim())) {
                    ToastUtil.show(this, "请输入密码", 1 * 1000);
                    return;
                }
                mLoginPresenter.setProgressBarVisiblity(View.VISIBLE);
                mBtnLogin.setEnabled(false);
                mLoginPresenter.doLogin(mEtUsername.getText().toString(), mEtPassword.getText().toString(), 4);
                break;
            case R.id.tv_forget_pwd:
                //               TODO startActivity(new Intent(this, RegisterActivity.class));
                break;
            case R.id.tv_register:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
        }
    }

    @Override
    public void onLoginResult(Boolean result) {
        mLoginPresenter.setProgressBarVisiblity(View.INVISIBLE);
        mBtnLogin.setEnabled(true);
        if (result) {
            ToastUtil.show(this, "Login Success");
            //startActivity(new Intent(this, MainActivity.class));
        } else {
            ToastUtil.show(this, "Login Failed");
        }
    }


    @Override
    public void onSetProgressBarVisibility(int visibility) {
        mProgressLogin.setVisibility(visibility);
    }

    @Override
    public void onLoginResponse(UserBean userBean) {
        //LoginSDKManager.getInstance().addAndUse(new SimpleLoginImpl(String.valueOf(userBean.getId()), userBean.getUser_name()));
        //startActivity(new Intent(this, MainActivity.class));
        //finish();
        umengLogin(userBean);
    }

    private void umengLogin(UserBean userBean){
        //创建CommUser前必须先初始化CommunitySDK
        CommunitySDK sdk = CommunityFactory.getCommSDK(this);
        CommUser user = new CommUser();
        user.name = userBean.getNick_name();
        user.id = "ID"+userBean.getId();
        sdk.loginToUmengServer(this, user, new LoginListener() {
            @Override
            public void onStart() {

            }
            @Override
            public void onComplete(int stCode, CommUser commUser) {
                LogUtil.d("####", "login result is" + stCode);          //获取登录结果状态码
                if (ErrorCode.NO_ERROR==stCode) {
                    //在此处可以跳转到任何一个你想要的activity
                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
                    finish();
                }
            }
        });
    }
}