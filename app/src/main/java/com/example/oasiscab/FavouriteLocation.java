package com.example.oasiscab;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


public class FavouriteLocation extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private Button addButton;
    private EditText nameOrSignificance;
    private EditText addLocation;
    private FavouriteLocListAdapter favouriteLocListAdapter;
    private ListView listView;

    public ArrayList<FavouriteLocationClass> favouriteLocations = new ArrayList<>();

    public FavouriteLocation() {
        // Required empty public constructor
    }

    public static FavouriteLocation newInstance(String param1, String param2) {
        FavouriteLocation fragment = new FavouriteLocation();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_favourite_location, container, false);
        nameOrSignificance = view.findViewById(R.id.name_significance);
        addLocation = view.findViewById(R.id.add_location);
        addButton = view.findViewById(R.id.add_btn);
        listView = view.findViewById(R.id.favourite_locations_list);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                check if the edittext fields are filled with data first
                if(!nameOrSignificance.getText().equals("") && !addLocation.getText().equals("")){

                    addFavouriteLocations(nameOrSignificance.getText().toString(), addLocation.getText().toString());
                    favouriteLocListAdapter = new FavouriteLocListAdapter(getContext(), favouriteLocations);
                    listView.setAdapter(favouriteLocListAdapter);

                }
            }
        });

        favouriteLocListAdapter = new FavouriteLocListAdapter(getContext(), favouriteLocations);
        listView.setAdapter(favouriteLocListAdapter);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //        if (context instanceof OnFragmentInteractionListener) {
//        mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

//    add favourite locations
    public void addFavouriteLocations(String nameOrSignicance, String location){
        FavouriteLocationClass favouriteLocation = new FavouriteLocationClass(nameOrSignicance, location);
        favouriteLocations.add(favouriteLocation);
    }
}
