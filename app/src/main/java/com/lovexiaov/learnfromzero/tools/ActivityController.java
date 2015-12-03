package com.lovexiaov.learnfromzero.tools;

import android.app.Activity;

import java.util.ArrayList;

/**
 * Manager Activities
 * 这种管理方式不太好，手动 finish() Activity 时，不能自己从 ArrayList 中将该类删除。
 * Created by lovexiaov on 15/12/2.
 */
public class ActivityController {

    public static final ArrayList<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public static void finashAll() {
        for (Activity activity : activities){
            activity.finish();
        }
    }

}
