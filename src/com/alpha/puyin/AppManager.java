package com.alpha.puyin;

import android.app.Activity;

import java.util.Stack;

/**
 * @author SongJian
 * @created 2016/1/16.
 * @e-mail 1129574214@qq.com
 *
 * activity堆栈式管�?
 */
public class AppManager {
    private static Stack<Activity> activityStack;
    private static AppManager instance;

    private AppManager(){}

    /**
     * 单一实例
     */
    public static AppManager getAppManager(){
        if (instance == null){
            return new AppManager();
        }
        return instance;
    }
    /**
     * 添加Activity到堆�?
     */
    public void addActivity(Activity activity){
        if (activityStack == null){
            activityStack = new Stack<Activity>();
        }
        activityStack.add(activity);
    }
    /**
     * 获取当前Activity（堆栈中�?后一个压入的�?
     */
    public Activity currentActivity(){
        Activity activity = activityStack.lastElement();
        return activity;
    }
    /**
     * 结束当前Activity（堆栈中�?后一个压入的�?
     */
    public void finishActivity(){
        Activity activity = activityStack.lastElement();
        finishActivity(activity);
    }
    /**
     * 结束指定的Activity
     */
    public void finishActivity(Activity activity){
        if (activity != null && !activity.isFinishing()){
            activityStack.remove(activity);
            activity.finish();
            activity = null;
        }
    }
}
