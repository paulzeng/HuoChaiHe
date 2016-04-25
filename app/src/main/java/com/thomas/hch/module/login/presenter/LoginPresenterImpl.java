package com.thomas.hch.module.login.presenter;

import android.util.Log;

import com.thomas.hch.bean.UserBean;
import com.thomas.hch.http.MySubscriber;
import com.thomas.hch.module.login.model.LoginModelImpl;
import com.thomas.hch.module.login.view.LoginView;


/**
 * @author zhudehao
 * @version $Rev$
 * @time 2016/3/15 15:23
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
public class LoginPresenterImpl implements LoginPresenter {
    LoginView mLoginView;
    LoginModelImpl mLoginModelImpl;

    public LoginPresenterImpl(LoginView mLoginView) {
        this.mLoginView = mLoginView;
        mLoginModelImpl = new LoginModelImpl();
    }


    @Override
    public void setProgressBarVisiblity(int visiblity) {
        mLoginView.onSetProgressBarVisibility(visiblity);
    }

    @Override
    public void doLogin( String name, String pwd, int clientID) {
        mLoginModelImpl.loginRequest(name, pwd, clientID, new MySubscriber<UserBean>() {
            @Override
            public void onCompleted() {
                mLoginView.onLoginResult(true);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("mainview", "onError:" + e.toString());
                mLoginView.onLoginResult(false);
            }

            @Override
            public void onNext(UserBean userBeans) {
                Log.e("mainview", "onNext:" + userBeans.toString());
                if (null != userBeans) {
                    mLoginView.onLoginResponse(userBeans);
                }

            }
        });
    }

    @Override
    public void unSubscribe() {

    }


}
