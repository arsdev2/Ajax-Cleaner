package com.ultraclean.boost;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.hookedonplay.decoviewlib.DecoView;
import com.hookedonplay.decoviewlib.charts.SeriesItem;
import com.hookedonplay.decoviewlib.events.DecoEvent;


public class noraml_m extends Activity{

    DecoView arcView;
    TextView ist,sec,thir,fou,completion;
    ImageView istpic,secpic,thirpic,foupic;
    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;
    int check=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nor_r);

        ist=findViewById(R.id.ist);
        sec=findViewById(R.id.sec);
        thir= findViewById(R.id.thi);
        fou= findViewById(R.id.fou);
        istpic=findViewById(R.id.istpic);
        secpic= findViewById(R.id.secpic);
        thirpic= findViewById(R.id.thipic);
        foupic= findViewById(R.id.foupic);
        completion= findViewById(R.id.completion);
        sharedpreferences = getSharedPreferences("was", Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();



        arcView = (DecoView) findViewById(R.id.dynamicArcView2);

        arcView.addSeries(new SeriesItem.Builder(Color.parseColor("#27282D"))
                .setRange(0, 100, 100)
                .setInitialVisibility(false)
                .setLineWidth(12f)
                .build());
        SeriesItem seriesItem1 = new SeriesItem.Builder(Color.parseColor("#27282D"))
                .setRange(0, 100, 0)
                .setLineWidth(10f)
                .build();

        SeriesItem seriesItem2 = new SeriesItem.Builder(Color.parseColor("#FFFFFF"))
                .setRange(0, 100, 0)
                .setLineWidth(10f)
                .build();
        int series1Index2 = arcView.addSeries(seriesItem2);

        seriesItem2.addArcSeriesItemListener(new SeriesItem.SeriesItemListener() {
            @Override
            public void onSeriesItemAnimationProgress(float v, float v1) {


                Float obj = new Float(v1);
                int i = obj.intValue();
                completion.setText(i+"%");

                if(v1>=10 && v1<50)
                {
                    ist.setTextColor(Color.parseColor("#FFFFFF"));
                    istpic.setImageResource(R.drawable.circle_white);
                }
                else if(v1>=50 && v1<75)
                {
                    sec.setTextColor(Color.parseColor("#FFFFFF"));
                    secpic.setImageResource(R.drawable.circle_white);
                }
                else if(v1>=75 && v1<90)
                {
                    thir.setTextColor(Color.parseColor("#FFFFFF"));
                    thirpic.setImageResource(R.drawable.circle_white);
                }
                else if(v1>=90 && v1<=100)
                {
                    fou.setTextColor(Color.parseColor("#FFFFFF"));
                    foupic.setImageResource(R.drawable.circle_white);
                }


            }

            @Override
            public void onSeriesItemDisplayProgress(float v) {

            }
        });


        arcView.addEvent(new DecoEvent.Builder(DecoEvent.EventType.EVENT_SHOW, true)
                .setDelay(0)
                .setDuration(0)
                .setListener(new DecoEvent.ExecuteEventListener() {
                    @Override
                    public void onEventStart(DecoEvent decoEvent) {
                    }

                    @Override
                    public void onEventEnd(DecoEvent decoEvent) {

                    }

                })
                .build());

        arcView.addEvent(new DecoEvent.Builder(100).setIndex(series1Index2).setDelay(1000).setListener(new DecoEvent.ExecuteEventListener() {
            @Override
            public void onEventStart(DecoEvent decoEvent) {

            }

            @Override
            public void onEventEnd(DecoEvent decoEvent) {

                //---------------------------------------
                try {
                    Rate.show_rate();

                }catch (Exception e){}
                check=1;
                youDesirePermissionCode(noraml_m.this);
                editor.putString("mode", "0");
                editor.commit();
                //---------------------------------------



            }
        }).build());
    }

    public void enablesall()
    {



        power_saving_compl.setAutoOrientationEnabled(getApplicationContext(), true);

        Settings.System.putInt(this.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, 255);

        ContentResolver.setMasterSyncAutomatically(true);

    }


    public void youDesirePermissionCode(Activity context){


        boolean permission;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            permission = Settings.System.canWrite(context);
        } else {
            permission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED;

        }
        if (permission) {
            enablesall();

            finish();
        }  else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
                intent.setData(Uri.parse("package:" + context.getPackageName()));
                context.startActivityForResult(intent, 1);
            } else {
                ActivityCompat.requestPermissions(context, new String[]{Manifest.permission.WRITE_SETTINGS}, 1);
            }
        }
    }
    //
    @SuppressLint("NewApi")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && Settings.System.canWrite(this)){
            Log.d("TAG", "CODE_WRITE_SETTINGS_PERMISSION success");

            enablesall();

            finish();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(check==1)
        {
            try
            {
                enablesall();
            }
            catch(Exception e)
            {
                finish();
            }
            finish();
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            enablesall();

            finish();
        }
    }

}
