package com.example.oasiscab;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.oasiscab.FavouriteLocationClass;
import com.example.oasiscab.R;

import java.util.ArrayList;

public class FavouriteLocListAdapter extends BaseAdapter {

    private Context mContext;
    public ArrayList<FavouriteLocationClass> favouriteLocations;

    public FavouriteLocListAdapter(Context context, ArrayList<FavouriteLocationClass> favouriteLocations) {

        //initialise context, arraylist
        this.mContext = context;
        this.favouriteLocations = favouriteLocations;

    }

    private class ViewHolder {
        TextView nameOrSignificance;
        TextView location;
        ImageView deleteButton;
    }

    @Override
    public View getView (final int position, View convertView, ViewGroup parent){
        // TODO Auto-generated method stub

        ViewHolder holder = null;
        Log.v("Convert View", String.valueOf(position));

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);

            convertView = inflater.inflate(R.layout.favourite_locations, null);

            holder = new ViewHolder();
            holder.nameOrSignificance = convertView.findViewById(R.id.name_significance);
            holder.location = convertView.findViewById(R.id.location);
            holder.deleteButton = convertView.findViewById(R.id.delete_btn);

            convertView.setTag(holder);


        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        FavouriteLocationClass favouriteLocation = favouriteLocations.get(position);
        holder.nameOrSignificance.setText(favouriteLocation.getNameOrSignificance());
        holder.location.setText(favouriteLocation.getLocation());

        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                favouriteLocations.remove(position);
                notifyDataSetChanged();
            }
        });

        return convertView;
    }


    @Override
    public int getCount() {
        return favouriteLocations.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
