package com.thomas.hch.app;

import android.app.Activity;
import android.app.Application;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 曾文韬
 * @version $Rev$
 * @time 2016/4/23 15:20
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
public class BaseApplication extends Application {
    public static BaseApplication mInstance;
    public static List<Activity> allActivity = new LinkedList<Activity>();

    /**
     * 销毁所有activity，应用退出
     */
    public void exit() {
        for (Activity activity : allActivity) {
            activity.finish();
        }
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    public static BaseApplication getInstance() {
        return mInstance;
    }
}
