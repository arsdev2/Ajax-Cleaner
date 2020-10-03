package com.ultraclean.boost;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import hotchemi.android.rate.AppRate;
import hotchemi.android.rate.OnClickButtonListener;

public class Rate {
   public static Activity mact;

    final static String click_s="is_click";
  final static String  APP_PREFERENCES="config";
    final static String TAG="myapp";
   public  static Context context;
    public static void show_rate(){
        SharedPreferences sharedPreferences = context.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        boolean click=sharedPreferences.getBoolean(click_s,false);
        if (!click) {
            AppRate.with(context).setTitle(context.getResources().getString(R.string.rate_title)).setMessage(context.getResources().getString(R.string.rate_text))
                    .setTextRateNow(context.getResources().getString(R.string.rate_btn)).setTextNever(context.getResources().getString(R.string.never_btn))
                    .setInstallDays(0) // default 10, 0 means install day.
                    .setLaunchTimes(0) // default 10
                    .setRemindInterval(0) // default 1
                    .setShowLaterButton(false) // default true
                    .setDebug(true) // default false
                    .setOnClickButtonListener(new OnClickButtonListener() { // callback listener.
                        @Override
                        public void onClickButton(int which) {
                            Log.d(TAG, Integer.toString(which));
                            if (which==-1){
                                SharedPreferences sharedPreferences = context.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
                                SharedPreferences.Editor e= sharedPreferences.edit();
                                e.putBoolean(click_s,true);
                                e.commit();
                            }
                        }
                    })
                    .monitor();

            // Show a dialog if meets conditions
            AppRate.showRateDialogIfMeetsConditions(mact);
        }

    }

}
