package com.thomas.hch.module.login.model;


import com.thomas.hch.bean.UserBean;
import com.thomas.hch.http.MySubscriber;

/**
 * @author zhudehao
 * @version $Rev$
 * @time 2016/3/15 15:25
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
public interface LoginModel {
    String getName();

    String getPwd();

    void loginRequest(String name, String pwd, int clientID, MySubscriber<UserBean> subscriber);
}
