package com.ultraclean.boost;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.yandex.metrica.YandexMetrica;
import com.yandex.metrica.YandexMetricaConfig;

import java.util.Calendar;



public class MainActivity extends FragmentActivity {

    public static TextView name;

    SharedPreferences.Editor ed;
    SharedPreferences sssp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                new Handler().postDelayed(this, 1000);
            }
        }, 1000);

        SharedPreferences sharedPreferences = getSharedPreferences("used", MODE_PRIVATE);
        if(!sharedPreferences.getBoolean("is", false)){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("is", true);
            editor.apply();
            AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            Intent alarmIntent = new Intent(MainActivity.this, NotificationReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, alarmIntent, 0);

            /* Set the alarm to start at 10:30 AM */
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            calendar.set(Calendar.HOUR_OF_DAY, 14);
            manager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 1000*60*60*24, pendingIntent);

        }


        //App metrica
        // Создание расширенной конфигурации библиотеки.
        YandexMetricaConfig config = YandexMetricaConfig.newConfigBuilder(getResources().getString(R.string.app_metrica)).build();
        // Инициализация AppMetrica SDK.
        YandexMetrica.activate(getApplicationContext(), config);
        // Отслеживание активности пользователей.
        YandexMetrica.enableActivityAutoTracking(getApplication());


        Rate.mact=this;
        Rate.context=this;


        int rN2i = 6 + (int)(Math.random() * 18);

        int asdf = 6 + (int)(Math.random() * 18);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);


        Intent myi = new Intent(MainActivity.this, alarm_receiver.class);

        PendingIntent pinnt = PendingIntent.getBroadcast(MainActivity.this, 0, myi, 0);


        Calendar firingCal= Calendar.getInstance();

        Calendar currentCal = Calendar.getInstance();

        firingCal.set(Calendar.HOUR_OF_DAY, asdf);         firingCal.set(Calendar.MINUTE, rN2i);



        firingCal.set(Calendar.SECOND, 0);

        long intendedTime = firingCal.getTimeInMillis();   long currentTime = currentCal.getTimeInMillis();


        if(intendedTime >= currentTime){         alarmManager.setRepeating(AlarmManager.RTC, intendedTime, AlarmManager.INTERVAL_DAY, pinnt);

        } else{            firingCal.add(Calendar.DAY_OF_MONTH, 1);             intendedTime = firingCal.getTimeInMillis();




            alarmManager.setRepeating(AlarmManager.RTC, intendedTime, AlarmManager.INTERVAL_DAY, pinnt);
        }



        final Thread.UncaughtExceptionHandler oldHandler =

                Thread.getDefaultUncaughtExceptionHandler();


        Thread.setDefaultUncaughtExceptionHandler(
                new Thread.UncaughtExceptionHandler() {
                    @Override
                    public void uncaughtException(
                            Thread paramThread,
                            Throwable paramThrowable
                    ) {


                        if (oldHandler != null)
                            oldHandler.uncaughtException(
                                    paramThread,
                                    paramThrowable
                            );
                        else
                            System.exit(2);
                    }
                });
        name=findViewById(R.id.name);
        sssp = getSharedPreferences("waseembest", Context.MODE_PRIVATE);
        ed = sssp.edit();


       final TabLayout tabLayout = findViewById(R.id.tab_layout);


        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.phonebooster));

        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.battery_saver));

        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.cooler));

        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.cleaner));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);




        final ViewPager viewPager = findViewById(R.id.pager);

        final my_pager_adap adapter = new my_pager_adap(getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(adapter);


        viewPager.setOffscreenPageLimit(4);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
    private boolean isNetworkAvailable() {




        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();

        return activeNetworkInfo != null && activeNetworkInfo.isConnected();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        ed.putString("button1", "0");

        ed.putString("button2", "0");

        ed.putString("button3", "0");

        ed.putString("button4", "0");

        ed.commit();

    }





}
