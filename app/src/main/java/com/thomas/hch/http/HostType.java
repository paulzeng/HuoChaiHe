package com.thomas.hch.http;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author liuhai
 * @version $Rev$
 * @time 2016/4/15 15:31
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate 2016/4/15$
 * @updateDes ${TODO}
 */
public class HostType {

    /**
     * 多少种Host类型
     */
    public static final int TYPE_COUNT = 3;

    /**教练助手
     *
     */
    @HostTypeChecker
    public static final int COACH_ASSISTANT_MAIN = 1;

    /**
     * 学车易广告
     */
    @HostTypeChecker
    public static final int COACH_ASSISTANT_BANNAR = 2;

    /**
     * 学车易咨询
     */
    @HostTypeChecker
    public static final int COACH_ASSISTANT_NEWS = 3;

    /**
     * 替代枚举的方案，使用IntDef保证类型安全
     */
    @IntDef({COACH_ASSISTANT_MAIN, COACH_ASSISTANT_BANNAR, COACH_ASSISTANT_NEWS})
    @Retention(RetentionPolicy.SOURCE)
    public @interface HostTypeChecker {

    }
}
