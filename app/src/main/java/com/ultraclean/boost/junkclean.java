package com.ultraclean.boost;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static android.content.Context.ALARM_SERVICE;

public class junkclean extends Fragment {
    int alljunk;

    SharedPreferences sharedpreferences;



    ImageView   sys;
    TextView Mtex;
    TextView      cachetext;
    TextView   temptext;
    TextView   residuetext;
    TextView   systemtext;
    public static ImageView mainbutton;



    SharedPreferences.Editor editor;
    ImageView mainbrush;
    ImageView    cache;
    ImageView    temp;
    ImageView     residue;
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.clen_jjjkk, container, false);
        mainbrush=view.findViewById(R.id.mainbrush);

        mainbutton=view.findViewById(R.id.mainbutton);

        cache=view.findViewById(R.id.cache);

        temp=view.findViewById(R.id.temp);
        residue=view.findViewById(R.id.residue);

        sys=view.findViewById(R.id.system);


        Mtex=view.findViewById(R.id.Mtex);

        cachetext=view.findViewById(R.id.cachetext);


        temptext =view.findViewById(R.id.temptext);

        residuetext =view.findViewById(R.id.residuetext);

        systemtext =view.findViewById(R.id.systemtext);

        try {

            sharedpreferences = getActivity().getSharedPreferences("waseem", Context.MODE_PRIVATE);


            if (sharedpreferences.getString("junk", "1").equals("1")) {
                mainbrush.setImageResource(R.drawable.junk_red);
                mainbutton.setImageResource(R.drawable.clean);


                cache.setImageResource(R.drawable.cache);


                temp.setImageResource(R.drawable.temp);


                residue.setImageResource(R.drawable.res);

                sys.setImageResource(R.drawable.sys);

                Random ran1 = new Random();
                final int proc1 = ran1.nextInt(20) + 5;

                Random ran2 = new Random();
                final int proc2 = ran2.nextInt(15) + 10;

                Random ran3 = new Random();
                final int proc3 = ran3.nextInt(30) + 15;

                Random ran4 = new Random();
                final int proc4 = ran4.nextInt(25) + 10;

                alljunk = proc1 + proc2 + proc3 + proc4;

                Mtex.setText(alljunk + " MB");
                Mtex.setTextColor(Color.parseColor("#F22938"));

                cachetext.setText(proc1 + " MB");

                cachetext.setTextColor(Color.parseColor("#F22938"));

                temptext.setText(proc2 + " MB");

                temptext.setTextColor(Color.parseColor("#F22938"));

                residuetext.setText(proc3 + " MB");

                residuetext.setTextColor(Color.parseColor("#F22938"));

                systemtext.setText(proc4 + " MB");

                systemtext.setTextColor(Color.parseColor("#F22938"));

            } else {



                mainbrush.setImageResource(R.drawable.junk_blue);

                mainbutton.setImageResource(R.drawable.cleaned);

                cache.setImageResource(R.drawable.cache2);

                temp.setImageResource(R.drawable.temp2);

                residue.setImageResource(R.drawable.res2);

                sys.setImageResource(R.drawable.sys2);


                Mtex.setText("CRYSTAL CLEAR");

                Mtex.setTextColor(Color.parseColor("#24D149"));

                cachetext.setText(0 + " MB");

                cachetext.setTextColor(Color.parseColor("#24D149"));

                temptext.setText(0 + " MB");

                temptext.setTextColor(Color.parseColor("#24D149"));

                residuetext.setText(0 + " MB");

                residuetext.setTextColor(Color.parseColor("#24D149"));

                systemtext.setText(0 + " MB");

                systemtext.setTextColor(Color.parseColor("#24D149"));
            }


            mainbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (sharedpreferences.getString("junk", "1").equals("1")) {

                        Intent i = new Intent(getActivity(), sacnJun.class);
                        i.putExtra("junk", alljunk + "");
                        startActivity(i);

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {

                            @Override
                            public void run() {
                                //Do something after 100ms


                                mainbrush.setImageResource(R.drawable.junk_blue);

                                mainbutton.setImageResource(R.drawable.cleaned);

                                cache.setImageResource(R.drawable.cache2);

                                temp.setImageResource(R.drawable.temp2);

                                residue.setImageResource(R.drawable.res2);

                                sys.setImageResource(R.drawable.sys2);


                                Mtex.setText("CRYSTAL CLEAR");

                                Mtex.setTextColor(Color.parseColor("#24D149"));

                                cachetext.setText(0 + " MB");

                                cachetext.setTextColor(Color.parseColor("#24D149"));

                                temptext.setText(0 + " MB");

                                temptext.setTextColor(Color.parseColor("#24D149"));

                                residuetext.setText(0 + " MB");

                                residuetext.setTextColor(Color.parseColor("#24D149"));

                                systemtext.setText(0 + " MB");
                                systemtext.setTextColor(Color.parseColor("#24D149"));


                                editor = sharedpreferences.edit();

                                editor.putString("junk", "0");

                                editor.commit();


                                Intent intent = new Intent(getActivity(), alaramJunk_.class);

                                PendingIntent pendingIntent = PendingIntent.getBroadcast(getActivity(), 0,
                                        intent, PendingIntent.FLAG_ONE_SHOT);

                                AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(ALARM_SERVICE);

                                alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (600 * 1000), pendingIntent);

                            }
                        }, 2000);

                    } else {
//                        Toast.makeText(getActivity(), "No Junk Files ALready Cleaned.", Toast.LENGTH_LONG).show();

                        @SuppressLint("RestrictedApi") LayoutInflater inflater = getLayoutInflater(getArguments());
                        View layout = inflater.inflate(R.layout.m_ts, null);

                        ImageView image = (ImageView) layout.findViewById(R.id.image);

                        TextView text = (TextView) layout.findViewById(R.id.textView1);
                        text.setText("No Junk Files ALready Cleaned.");

                        Toast toast = new Toast(getActivity());
                        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 70);
                        toast.setDuration(Toast.LENGTH_LONG);
                        toast.setView(layout);
                        toast.show();
                    }
                }
            });


//            Random ran1 = new Random();
//            final int proc1 = ran1.nextInt(20) + 5;
//
//            Random ran2 = new Random();
//            final int proc2 = ran2.nextInt(15) + 10;
//
//            Random ran3 = new Random();
//            final int proc3 = ran3.nextInt(30) + 15;
//
//            Random ran4 = new Random();
//            final int proc4 = ran4.nextInt(25) + 10;
//
//            alljunk=proc1+proc2+proc3+proc4;
//
//            Mtex.setText(alljunk+" MB");
//            Mtex.setTextColor(Color.parseColor("#F22938"));
//
//            cachetext.setText(proc1+" MB");
//            cachetext.setTextColor(Color.parseColor("#F22938"));
//
//            temptext.setText(proc2+" MB");
//            temptext.setTextColor(Color.parseColor("#F22938"));
//
//            residuetext.setText(proc3+" MB");
//            residuetext.setTextColor(Color.parseColor("#F22938"));
//
//            systemtext.setText(proc4+" MB");
//            systemtext.setTextColor(Color.parseColor("#F22938"));

        }
        catch (Exception e)
        {

        }

        return view;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1){
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean getUserVisibleHint() {

//        MainActivity.name.setText("Junk Cleaner");
        return getUserVisibleHint();

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);


        if (isVisibleToUser) {
            MainActivity.name.setText("Junk Cleaner");

        } else {

        }
    }
}
