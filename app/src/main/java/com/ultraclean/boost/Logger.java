package com.ultraclean.boost;

import android.util.Log;

public class Logger {

    private static final String TAG = "MY_BATTERY_SAVER";

    public static void d(String message){
        Log.d(TAG, message);
    }

    public static void e(String message){
        Log.e(TAG, message);
    }

}
