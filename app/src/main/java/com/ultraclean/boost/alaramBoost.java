package com.ultraclean.boost;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public final class alaramBoost extends BroadcastReceiver {

    SharedPreferences s;    SharedPreferences.Editor e;
    @Override
    public void onReceive(Context context, Intent intent) {

        s = context.
                getSharedPreferences("waseem", Context.MODE_PRIVATE);
       e = s.edit();
        e.putString("booster", "1");
        e.commit();

        try {


            phone_boost_.optimizebutton.setBackgroundResource(0);//phone_boost

            phone_boost_.optimizebutton.setImageResource(0);


            phone_boost_.optimizebutton.setImageResource(R.drawable.optimize);
        }
        catch(Exception e)
        {

        }

    }
}
