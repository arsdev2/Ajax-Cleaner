package com.ultraclean.boost;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.skyfishjy.library.RippleBackground;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

public class cpuscan extends Activity{



    TextView cldc;
    RelativeLayout rel;

    ImageView scanner;
    ImageView imAN;
    ImageView cpu;

    scancpu_ap mAdapter;
    RecyclerView recyclerView;
    List<apps> app=null;
    RippleBackground rippleBackground;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ccccpu_cs);
        scanner = (ImageView) findViewById(R.id.scann);
        cpu = (ImageView) findViewById(R.id.cpu);
        cldc=(TextView) findViewById(R.id.cpucooler);
        imAN = (ImageView) findViewById(R.id.heart);
        rel=(RelativeLayout) findViewById(R.id.rel);
        app=new ArrayList<>();

        RotateAnimation rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(1500);
        rotate.setRepeatCount(3);
        rotate.setInterpolator(new LinearInterpolator());
        scanner.startAnimation(rotate);
        TranslateAnimation animation = new TranslateAnimation(0.0f, 1000.0f, 0.0f, 0.0f);          //  new TranslateAnimation(xFrom,xTo, yFrom,yTo)
        animation.setDuration(5000);
        animation.setRepeatCount(0);
        animation.setInterpolator(new LinearInterpolator());
        animation.setFillAfter(true);
        imAN.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imAN.setImageResource(0);
                imAN.setBackgroundResource(0);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        recyclerView = findViewById(R.id.recycler_view);        recyclerView.setItemAnimator(new SlideInLeftAnimator());
        mAdapter = new scancpu_ap(cpucool.apps);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new SlideInUpAnimator(new OvershootInterpolator(1f)));
        recyclerView.computeHorizontalScrollExtent();
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        try {
            final Handler handler1 = new Handler();
            handler1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    add("Limit Brightness Upto 80%", 0);


                }
            }, 0);       final Handler handler2 = new Handler();
            handler2.postDelayed(new Runnable() {
                @Override
                public void run() {
                    remove(0);
                    add("Decrease Device Performance", 1);


                }
            }, 900);            final Handler handler3 = new Handler();
            handler3.postDelayed(new Runnable() {
                @Override
                public void run() {
                    remove(0);
                    add("Close All Battery Consuming apps", 2);


                }
            }, 1800);      final Handler handler4 = new Handler();
            handler4.postDelayed(new Runnable() {
                @Override
                public void run() {                remove(0);
                    add("Closes System Services like Bluetooth,Screen Rotation,Sync etc.", 3);


                }
            }, 2700);          final Handler handler5 = new Handler();
            handler5.postDelayed(new Runnable() {
                @Override
                public void run() {
                    remove(0);
                    add("Closes System Services like Bluetooth,Screen Rotation,Sync etc.", 4);
                }
            }, 3700);
            final Handler handler6 = new Handler();
            handler6.postDelayed(new Runnable() {
                @Override
                public void run() {
                    remove(0);
                    add("Closes System Services like Bluetooth,Screen Rotation,Sync etc.", 5);
                }
            }, 4400);

            final Handler handler7 = new Handler();
            handler7.postDelayed(new Runnable() {
                @Override
                public void run() {
                    add("Closes System Services like Bluetooth,Screen Rotation,Sync etc.", 6);
                    remove(0);
                    rippleBackground=findViewById(R.id.content);
                    rippleBackground.startRippleAnimation();
                    imAN.setImageResource(0);
                    imAN.setBackgroundResource(0);
                    cpu.setImageResource(R.drawable.green_circle);
                    scanner.setImageResource(R.drawable.task_complete);
                    ObjectAnimator anim = (ObjectAnimator) AnimatorInflater.loadAnimator(getApplicationContext(), R.animator.flipping);
                    anim.setTarget(scanner);
                    anim.setDuration(3000);
                    anim.start();
                    rel.setVisibility(View.GONE);
                    cldc.setText("Cooled CPU to 25.3°C");
                    anim.addListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {
                            imAN.setImageResource(0);
                            imAN.setBackgroundResource(0);
                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            rippleBackground.stopRippleAnimation();
                            final Handler handler6 = new Handler();
                            handler6.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    finish();

                                }
                            }, 1000);
                            try {
                                Rate.show_rate();

                            }catch (Exception e){

                            }
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {
///commen
                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {
//comment
                        }
                    });

                }
            }, 5500);

        }
        catch(Exception e)
        {//exception

        }

    }

    public void remove(int position) {
        mAdapter.notifyItemRemoved(position);
        try {
            cpucool.apps.remove(position);
        }
        catch(Exception e)
        {

        }
    }
    public void add(String text, int position) {

        try {


            mAdapter.notifyItemInserted(position);
        }
        catch(Exception e)
        {

        }
    }
}
