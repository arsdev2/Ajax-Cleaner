package com.ultraclean.boost;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class app_listen extends BroadcastReceiver {

   @Override
   public void onReceive(Context context, Intent arg1) {
       // TODO Auto-generated method stub


       String installedPackageName = arg1.getData().getEncodedSchemeSpecificPart();



       if(!(installedPackageName.equals("fast.cleaner.battery.saver"))) {

           final String packageName = installedPackageName;
           PackageManager packageManager= context.getApplicationContext().getPackageManager();
           try {
               String appName = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(packageName, PackageManager.GET_META_DATA));
               LayoutInflater inflater = LayoutInflater.from(context);


               View L = inflater.inflate(R.layout.m_ts, null);



               TextView text = L.findViewById(R.id.textView1);



               text.setText(appName+" Is Optimized by Fast Cleaner and Battery Saver.");

               Toast t = new Toast(context);

               t.setGravity(Gravity.CENTER_VERTICAL, 0, 120);

               t.setDuration(Toast.LENGTH_LONG);

               t.setView(L);

               t.show();
           } catch (PackageManager.NameNotFoundException e) {

               //ex
           }
       }
   }
}
