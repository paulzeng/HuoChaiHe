package com.thomas.hch.module.login.presenter;

/**
 * @author zhudehao
 * @version $Rev$
 * @time 2016/3/15 15:22
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
public interface LoginPresenter {
    void setProgressBarVisiblity(int visiblity);

    void doLogin(String name, String pwd, int clientID);

    void unSubscribe();
}
