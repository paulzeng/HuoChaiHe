package com.thomas.hch.http;

import android.util.Log;

import rx.functions.Func1;

/**
 * @author zhudehao
 * @version $Rev$
 * @time 2016/3/18 11:00
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */


/**
 * 用来统一处理Http的resultCode,并将HttpResult的Data部分剥离出来返回给subscriber
 *
 * @param <T> Subscriber真正需要的数据类型，也就是Data部分的数据类型
 */
public class CoachResultFunc<T> implements Func1<CoachHttpResult<T>, T> {

    @Override
    public T call(CoachHttpResult<T> httpResult) {
        Log.e("mainview", httpResult.toString());
        if (httpResult.getCode() != 1) {
            throw new ApiException(httpResult.getCode());
        }
        return httpResult.getData();
    }
}
