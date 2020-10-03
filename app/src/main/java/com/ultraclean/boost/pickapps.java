package com.ultraclean.boost;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class pickapps extends Activity {
    SharedPreferences sp;
    SharedPreferences.Editor ed;
    ImageView addcontact;
    ImageView        addplaystore;
       ImageView     addcalculator;
          ImageView  addcamera;
         ImageView   addclock;
          ImageView  addmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p_ppap);

        sp = getSharedPreferences("waseembest", Context.MODE_PRIVATE);
        ed = sp.edit();

        addcontact=findViewById(R.id.addcontacts);
        addcamera= findViewById(R.id.addcamera);





        addplaystore=findViewById(R.id.addplaystore);

        addcalculator= findViewById(R.id.addcalculator);

        addclock= findViewById(R.id.addclock);

        addmap= findViewById(R.id.addmap);


        addcontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               if(!(sp.getString("button1","l").equals("4")||sp.getString("button2","l").equals("4")||sp.getString("button3","l").equals("4")||sp.getString("button4","l").equals("4"))) {
                   if (sp.getString("button", "1").equals("1")) {
                       ed.putString("button1", "4");
                       ed.commit();
                   } else if (sp.getString("button", "1").equals("2")) {
                       ed.putString("button2", "4");
                       ed.commit();
                   } else if (sp.getString("button", "1").equals("3")) {
                       ed.putString("button3", "4");
                       ed.commit();
                   } else if (sp.getString("button", "1").equals("4")) {
                       ed.putString("button4", "4");
                       ed.commit();
                   }

                   finish();
               }
                else
               {
                   LayoutInflater inflater = getLayoutInflater();
                   View layout = inflater.inflate(R.layout.m_ts, null);

                   ImageView image = (ImageView) layout.findViewById(R.id.image);

                   TextView text = (TextView) layout.findViewById(R.id.textView1);
                   text.setText("This App Is Already Added");

                   Toast toast = new Toast(pickapps.this);
                   toast.setGravity(Gravity.CENTER_VERTICAL, 0, 70);
                   toast.setDuration(Toast.LENGTH_LONG);
                   toast.setView(layout);
                   toast.show();

//                   Toast.makeText(pickapps.this, "Choose Another App This App Is Already Added", Toast.LENGTH_SHORT).show();
               }

            }
        });

        addplaystore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!(sp.getString("button1","l").equals("1")||sp.getString("button2","l").equals("1")||sp.getString("button3","l").equals("1")||sp.getString("button4","l").equals("1"))) {

                    if (sp.getString("button", "1").equals("1")) {
                        ed.putString("button1", "1");
                        ed.commit();
                    } else if (sp.getString("button", "1").equals("2")) {
                        ed.putString("button2", "1");
                        ed.commit();
                    } else if (sp.getString("button", "1").equals("3")) {
                        ed.putString("button3", "1");
                        ed.commit();
                    } else if (sp.getString("button", "1").equals("4")) {
                        ed.putString("button4", "1");
                        ed.commit();
                    }

                    finish();
                }
                else
                {
                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.m_ts, null);

                    ImageView image = (ImageView) layout.findViewById(R.id.image);

                    TextView text = (TextView) layout.findViewById(R.id.textView1);
                    text.setText("This App Is Already Added");

                    Toast toast = new Toast(pickapps.this);
                    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 70);
                    toast.setDuration(Toast.LENGTH_LONG);
                    toast.setView(layout);
                    toast.show();

//                    Toast.makeText(pickapps.this, "Choose Another App This App Is Already Added", Toast.LENGTH_SHORT).show();
                }
            }
        });

        addcalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!(sp.getString("button1","l").equals("2")||sp.getString("button2","l").equals("2")||sp.getString("button3","l").equals("2")||sp.getString("button4","l").equals("2"))) {

                    if (sp.getString("button", "1").equals("1")) {
                        ed.putString("button1", "2");
                        ed.commit();
                    } else if (sp.getString("button", "1").equals("2")) {
                        ed.putString("button2", "2");
                        ed.commit();
                    } else if (sp.getString("button", "1").equals("3")) {
                        ed.putString("button3", "2");
                        ed.commit();
                    } else if (sp.getString("button", "1").equals("4")) {
                        ed.putString("button4", "2");
                        ed.commit();
                    }

                    finish();
                }
                else
                {

                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.m_ts, null);

                    ImageView image = (ImageView) layout.findViewById(R.id.image);

                    TextView text = (TextView) layout.findViewById(R.id.textView1);
                    text.setText("This App Is Already Added");

                    Toast toast = new Toast(pickapps.this);
                    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 70);
                    toast.setDuration(Toast.LENGTH_LONG);
                    toast.setView(layout);
                    toast.show();

//                    Toast.makeText(pickapps.this, "Choose Another App This App Is Already Added", Toast.LENGTH_SHORT).show();
                }

            }
        });

        addclock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!(sp.getString("button1","l").equals("3")||sp.getString("button2","l").equals("3")||sp.getString("button3","l").equals("3")||sp.getString("button4","l").equals("3"))) {

                    if (sp.getString("button", "1").equals("1")) {
                        ed.putString("button1", "3");
                        ed.commit();
                    } else if (sp.getString("button", "1").equals("2")) {
                        ed.putString("button2", "3");
                        ed.commit();
                    } else if (sp.getString("button", "1").equals("3")) {
                        ed.putString("button3", "3");
                        ed.commit();
                    } else if (sp.getString("button", "1").equals("4")) {
                        ed.putString("button4", "3");
                        ed.commit();
                    }

                    finish();
                }
                else
                {
                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.m_ts, null);

                    ImageView image = (ImageView) layout.findViewById(R.id.image);

                    TextView text = (TextView) layout.findViewById(R.id.textView1);
                    text.setText("This App Is Already Added");

                    Toast toast = new Toast(pickapps.this);
                    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 70);
                    toast.setDuration(Toast.LENGTH_LONG);
                    toast.setView(layout);
                    toast.show();

//                    Toast.makeText(pickapps.this, "Choose Another App This App Is Already Added", Toast.LENGTH_SHORT).show();
                }

            }
        });

        addmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(!(sp.getString("button1","l").equals("5")||sp.getString("button2","l").equals("5")||sp.getString("button3","l").equals("5")||sp.getString("button4","l").equals("5"))) {

                    if (sp.getString("button", "1").equals("1")) {
                        ed.putString("button1", "5");
                        ed.commit();
                    } else if (sp.getString("button", "1").equals("2")) {
                        ed.putString("button2", "5");
                        ed.commit();
                    } else if (sp.getString("button", "1").equals("3")) {
                        ed.putString("button3", "5");
                        ed.commit();
                    } else if (sp.getString("button", "1").equals("4")) {
                        ed.putString("button4", "5");
                        ed.commit();
                    }

                    finish();
                }
                else
                {

                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.m_ts, null);

                    ImageView image = (ImageView) layout.findViewById(R.id.image);

                    TextView text = (TextView) layout.findViewById(R.id.textView1);
                    text.setText("This App Is Already Added");

                    Toast toast = new Toast(pickapps.this);
                    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 70);
                    toast.setDuration(Toast.LENGTH_LONG);
                    toast.setView(layout);
                    toast.show();

//                    Toast.makeText(pickapps.this, "Choose Another App This App Is Already Added", Toast.LENGTH_SHORT).show();
                }

            }
        });

        addcamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!(sp.getString("button1","l").equals("6")||sp.getString("button2","l").equals("6")||sp.getString("button3","l").equals("6")||sp.getString("button4","l").equals("6"))) {

                    if (sp.getString("button", "1").equals("1")) {
                        ed.putString("button1", "6");
                        ed.commit();
                    } else if (sp.getString("button", "1").equals("2")) {
                        ed.putString("button2", "6");
                        ed.commit();
                    } else if (sp.getString("button", "1").equals("3")) {
                        ed.putString("button3", "6");
                        ed.commit();
                    } else if (sp.getString("button", "1").equals("4")) {
                        ed.putString("button4", "6");
                        ed.commit();
                    }

                    finish();
                }
                else
                {
//                    Toast.makeText(pickapps.this, "Choose Another App This App Is Already Added", Toast.LENGTH_SHORT).show();

                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.m_ts, null);

                    ImageView image = (ImageView) layout.findViewById(R.id.image);

                    TextView text = (TextView) layout.findViewById(R.id.textView1);
                    text.setText("This App Is Already Added");

                    Toast toast = new Toast(pickapps.this);
                    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 70);
                    toast.setDuration(Toast.LENGTH_LONG);
                    toast.setView(layout);
                    toast.show();
                }

            }
        });



    }
}
