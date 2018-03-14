package edu.wou.jmozingo12.barfly;

import android.app.Activity;
import android.os.Bundle;
import android.support.multidex.MultiDexApplication;
import android.util.Log;

import com.amazonaws.mobileconnectors.pinpoint.analytics.AnalyticsClient;
import com.amazonaws.mobileconnectors.pinpoint.analytics.AnalyticsEvent;

/**
 * Created by jmozi on 3/13/2018.
 */

public class Application extends MultiDexApplication {
    @Override
    public void onCreate(){
        super.onCreate();

        AWSProvider.initialize(getApplicationContext());

        registerActivityLifecycleCallbacks(new ActivityLifeCycle());

        //Test for Amazon Pinpoint
        //Create the manager for AWS Pinpoint
        final AnalyticsClient mgr = AWSProvider.getInstance()
                .getPinpointManager()
                .getAnalyticsClient();
        //create a new event object
        final AnalyticsEvent event = mgr.createEvent("ActivityOpened");
        //Record to send to Pinpoint server and submit.
        mgr.recordEvent(event);
        mgr.submitEvents();
    }
}

/*
This is all for the AWS Analytics basic function.
 */
class ActivityLifeCycle implements android.app.Application.ActivityLifecycleCallbacks {
    private int depth = 0;

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

    }

    /**
     * Method to create AWS Pinpoint monitoring on startup.
     *
     * @param activity
     */
    @Override
    public void onActivityStarted(Activity activity) {
        if (depth == 0) {
            Log.d("ActivityLifeCycle", "Application entered foreground");
            AWSProvider.getInstance().getPinpointManager().getSessionClient().startSession();
            AWSProvider.getInstance().getPinpointManager().getAnalyticsClient().submitEvents();
        }
        depth++;
    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    /**
     * Method to end AWS Pinpoint monitoring.
     *
     * @param activity
     */
    @Override
    public void onActivityStopped(Activity activity) {
        depth--;
        if (depth == 0) {
            Log.d("ActivityLifeCycle", "Application entered background");
            AWSProvider.getInstance().getPinpointManager().getSessionClient().stopSession();
            AWSProvider.getInstance().getPinpointManager().getAnalyticsClient().submitEvents();
        }

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}

