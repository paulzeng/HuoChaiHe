package com.thomas.hch.http;


import com.thomas.hch.bean.UserBean;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * @author 曾文韬
 * @version $Rev$
 * @time 2016/3/15 15:14
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
public interface ApiManagerService {

    public static final String COACT_MAIN_HOST = "http://120.24.236.107:888/";

    public static final String COACT_BANNAR_HOST = "http://mokao.xuecheyi.com/";

    public static final String COACT_NEWS_HOST = "http://user.xuecheyi.com/";

    //登录
    @FormUrlEncoded
    @POST("api/Login/Login")
    Observable<HttpResult<UserBean>> login(@Field("name") String name, @Field("pwd") String pwd, @Field("clientID") int clientID);


}
