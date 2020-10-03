package com.ultraclean.boost;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import static android.content.Context.NOTIFICATION_SERVICE;

public class alarm_receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {            Toast.makeText(context, "HGello", Toast.LENGTH_SHORT)
                .show();


            Intent notificationIntent = new Intent(context, MainActivity.class);
            PendingIntent intentt = PendingIntent.getActivity(context, 0,
                    notificationIntent, 0);





            Notification not = new Notification.Builder(context)
                    .setContentTitle(context.getResources().getString(R.string.title_notefication))
                    .setContentText(context.getResources().getString(R.string.detail_notification))
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentIntent(intentt).setAutoCancel(true)
                    .setDefaults(Notification.DEFAULT_SOUND
                            | Notification.DEFAULT_VIBRATE)
                    .build();        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);


            notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                    | Intent.FLAG_ACTIVITY_SINGLE_TOP);            not.flags |= Notification.FLAG_AUTO_CANCEL;
            notificationManager.notify(0, not);








        }
    }
}
