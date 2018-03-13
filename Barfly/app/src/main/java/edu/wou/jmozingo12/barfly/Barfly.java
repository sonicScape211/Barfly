package edu.wou.jmozingo12.barfly;

import android.app.Activity;
import android.os.Bundle;
import android.support.multidex.MultiDexApplication;
import android.util.Log;

/**
 * Created by jmozi on 3/13/2018.
 */

public class Barfly extends MultiDexApplication {
    @Override
    public void onCreate(){
        super.onCreate();

        AWSProvider.initialize(getApplicationContext());

        registerActivityLifecycleCallbacks(new ActivityLifeCycle());
    }
}

/*
This is all for the AWS Analytics basic function.
 */
class ActivityLifeCycle implements android.app.Application.ActivityLifecycleCallbacks{
    private int depth = 0;

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState){

    }

    @Override
    public void onActivityStarted(Activity activity){
        if(depth == 0) {
            Log.d("ActivityLifeCycle", "Application entered foreground");
        }
    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {
        depth--;
        if (depth == 0) {
            Log.d("ActivityLifeCycle", "Application entered background");
        }

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity){

    }

}
