package com.ultraclean.boost;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

public class pow_sav_pop extends Activity {
    RecyclerView rerev;
    power_adapter masdar;
    List<power_it> items;
    ImageView ap_dasd;
    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;
    TextView extendedtime,extendedtimedetail;

    int hour;
    int min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b=getIntent().getExtras();
        setContentView(R.layout.pow_pop);
        sharedpreferences = getSharedPreferences("was", Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();
        extendedtime=(TextView) findViewById(R.id.addedtime);
        extendedtimedetail=(TextView) findViewById(R.id.addedtimedetail);


        try {
            hour = Integer.parseInt(b.getString("hour").replaceAll("[^0-9]", "")) - Integer.parseInt(b.getString("hournormal").replaceAll("[^0-9]", ""));
            min = Integer.parseInt(b.getString("minutes").replaceAll("[^0-9]", "")) - Integer.parseInt(b.getString("minutesnormal").replaceAll("[^0-9]", ""));
        }
        catch(Exception e)
        {
            hour=3;
            min=5;
        }

        if(hour==0 && min==0)
        {
            hour=3;
            min=5;
        }
        extendedtime.setText("(+"+hour+" h " +Math.abs(min)+" m)");
        extendedtimedetail.setText("Extended Battery Up to "+Math.abs(hour)+"h "+Math.abs(min)+"m");




        items=new ArrayList<>();
        ap_dasd= findViewById(R.id.applied);
        ap_dasd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                editor.putString("mode", "1");
                editor.commit();

                Intent i=new Intent(getApplicationContext(),power_saving_compl.class);
                startActivity(i);

                finish();
            }
        });

        rerev =findViewById(R.id.recycler_view);

        rerev.setItemAnimator(new SlideInLeftAnimator());


        rerev.getItemAnimator().setAddDuration(200);

        masdar = new power_adapter(items);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rerev.setLayoutManager(mLayoutManager);
        rerev.setItemAnimator(new SlideInUpAnimator(new OvershootInterpolator(1f)));
        rerev.computeHorizontalScrollExtent();
        rerev.setAdapter(masdar);
        masdar.notifyDataSetChanged();

        final Handler handler1 = new Handler();
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                add("Limit Brightness Upto 80%", 0);


            }
        }, 1000);

        final Handler handler2 = new Handler();
        handler2.postDelayed(new Runnable() {
            @Override
            public void run() {
                add("Decrease Device Performance", 1);


            }
        }, 2000);

        final Handler handler3 = new Handler();
        handler3.postDelayed(new Runnable() {
            @Override
            public void run() {
                add("Close All Battery Consuming apps", 2);


            }
        }, 3000);

        final Handler handler4 = new Handler();
        handler4.postDelayed(new Runnable() {
            @Override
            public void run() {
                add("Closes System Services like Bluetooth,Screen Rotation,Sync etc.", 3);

            }
        }, 4000);



    }

    public void add(String text, int position) {


        power_it item=new power_it();
        item.setText(text);
        items.add(item);
//        mDataSet.add(position, text);
        masdar.notifyItemInserted(position);
    }

}
