package com.example.adhfixer.waleed;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class RideAdapter extends ArrayAdapter<Ride> {
        Context context;
        int resource;

        public RideAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Ride> rides) {
            super(context, resource, rides);
            this.context=context;
            this.resource = resource;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = ((Activity) context).getLayoutInflater();
            View view = layoutInflater.inflate(resource, parent, false);

            Ride rides =  (Ride) getItem(position);

            TextView tvRide = (TextView) view.findViewById(R.id.tvRide);
            TextView tvTime = (TextView) view.findViewById(R.id.tvTime);
            TextView tvDrive = (TextView) view.findViewById(R.id.tvDriver);
            TextView tvPrice = (TextView) view.findViewById(R.id.tvPrice);
       //     ImageView imageView = (ImageView) view.findViewById(R.id.imgLocation);


            tvPrice.setText(rides.getPrice()+" ");
            tvTime.setText(rides.getTime());
            tvRide.setText(rides.getFrom()+ " - " +rides.getTo());
            tvDrive.setText(rides.getDriver());
    //        imageView.setImageResource(R.drawable.ic_icon);


            return view;
        }
}
