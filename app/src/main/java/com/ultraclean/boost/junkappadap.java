package com.ultraclean.boost;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class junkappadap extends RecyclerView.Adapter<junkappadap.MyViewHolder> {

    public List<com.ultraclean.boost.apps> apps;


    @Override
    public int getItemCount() {
        return apps.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView size;
        ImageView image;

        public MyViewHolder(View view) {
            super(view);
            size = view.findViewById(R.id.apptext);




            image = view.findViewById(R.id.appimage);

        }
    }


    public junkappadap(List<com.ultraclean.boost.apps> getapps) {
        apps = getapps;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.jkjasd_rec_ap, parent, false);        return new MyViewHolder(itemView);
    }




    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        com.ultraclean.boost.apps app = apps.get(position);

        holder.size.setText(app.getSize());

        holder.image.setImageDrawable(app.getImage());
    }





}
