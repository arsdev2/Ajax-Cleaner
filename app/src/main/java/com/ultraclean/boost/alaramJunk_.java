package com.ultraclean.boost;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;


public final class alaramJunk_ extends BroadcastReceiver {
    SharedPreferences.Editor ed;
    SharedPreferences sp;
    @Override
    public void onReceive(Context context, Intent intent) {

        sp = context.getSharedPreferences("waseem", Context.MODE_PRIVATE);        ed = sp.edit();


        ed.putString("junk", "1");//save
        ed.commit();

    }
}
