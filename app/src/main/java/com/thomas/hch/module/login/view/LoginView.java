package com.thomas.hch.module.login.view;


import com.thomas.hch.bean.UserBean;

/**
 * @author zhudehao
 * @version $Rev$
 * @time 2016/3/15 15:18
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
public interface LoginView {
    void onLoginResult(Boolean result);

    void onSetProgressBarVisibility(int visibility);

    void onLoginResponse(UserBean userBean);
}
