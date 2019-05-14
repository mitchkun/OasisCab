package com.example.oasiscab;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

public class PastTripsAdapter extends RecyclerView.Adapter<PastTripsAdapter.MyViewHolder>  {

    private List<PastTripsClass> pastTrips;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView dateTime;
        public TextView location;
        private TextView rateDriverButton;
        private TextView driverProfileButton;



        public MyViewHolder(View view) {
            super(view);
            dateTime = view.findViewById(R.id.date_time);
            location = view.findViewById(R.id.location);
            rateDriverButton =view.findViewById(R.id.rate_driver_btn);
            driverProfileButton= view.findViewById(R.id.drivers_profile_btn);
        }
    }


    public PastTripsAdapter(Context context, List<PastTripsClass>  pastTrips) {
        this.pastTrips = pastTrips;
        this.context = context;
    }

    @Override
    public PastTripsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.past_trips, parent, false);


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        PastTripsClass pastTrip= pastTrips.get(position);
        holder.dateTime.setText(pastTrip.getDateTime());
        holder.location.setText(pastTrip.getLocation());

        holder.rateDriverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRatingAgentDiaolog();
            }
        });

        holder.driverProfileButton .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intentToDriverProfile();
            }
        });
    }

    @Override
    public int getItemCount() {
        return pastTrips.size();

    }


    public void removeItem(int position) {
        pastTrips.remove(position);

        notifyItemRemoved(position);
    }

    public void showRatingAgentDiaolog(){

        final AlertDialog.Builder popDialog = new AlertDialog.Builder(context, AlertDialog.THEME_HOLO_DARK);

//      Inflate the rating_dialog xml layout
        LayoutInflater factory = LayoutInflater.from(context);
        final View view = factory.inflate(R.layout.rating_dialog, null);

        popDialog.setView(view);


        popDialog.setCancelable(false);
        popDialog.setPositiveButton("SUBMIT",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

//                      dismiss dialog on onClick
                        dialog.dismiss();
                    }

                });

        Dialog dialog = popDialog.create();
        dialog.setCanceledOnTouchOutside(true);
        popDialog.show();

    }

    public void intentToDriverProfile(){
        Intent intent= new Intent(context, DriversProfile.class);
        context.startActivity(intent);

    }
}
