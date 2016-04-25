package com.thomas.hch.module.login.model;


import com.thomas.hch.bean.UserBean;
import com.thomas.hch.http.HostType;
import com.thomas.hch.http.HttpResult;
import com.thomas.hch.http.MySubscriber;
import com.thomas.hch.http.ResultFunc;
import com.thomas.hch.http.RetrofitManager;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author zhudehao
 * @version $Rev$
 * @time 2016/3/15 15:29
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
public class LoginModelImpl implements LoginModel {
    String name;
    String pwd;
    Subscription mSubscription;


    public String getName() {
        return name;
    }


    public String getPwd() {
        return pwd;
    }

    @Override
    public void loginRequest(String name, String pwd, int clientID, MySubscriber<UserBean> subscriber) {
        unSubscribe();
        Observable<HttpResult<UserBean>> observable = RetrofitManager.builder(HostType.COACH_ASSISTANT_NEWS).apiService.login(name, pwd, clientID);

        mSubscription = observable.map(new ResultFunc<UserBean>())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void unSubscribe() {
        if (mSubscription != null && mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
    }
}