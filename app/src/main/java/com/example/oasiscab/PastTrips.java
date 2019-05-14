package com.example.oasiscab;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class PastTrips extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    ArrayList<PastTripsClass> pastTrips = new ArrayList<>();

    public PastTrips() {
        // Required empty public constructor
    }

    public static PastTrips newInstance(String param1, String param2) {
        PastTrips fragment = new PastTrips();
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

        loadPastTrips();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_past_trips, container, false);
        final FragmentActivity c = getActivity();
        final RecyclerView recyclerView = view.findViewById(R.id.past_trips_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(c, LinearLayoutManager.VERTICAL, true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new PastTripsAdapter(getContext(), pastTrips));


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

    public void loadPastTrips(){

        PastTripsClass pastTrip = new PastTripsClass("Thursday 25 Oct 14:25", "Mbabane North, Zone 2");
        pastTrips.add(pastTrip);

        pastTrip = new PastTripsClass("Thursday 25 Oct 14:25", "Mbabane North, Zone 2");
        pastTrips.add(pastTrip);

        pastTrip = new PastTripsClass("Thursday 25 Oct 14:25", "Mbabane North, Zone 2");
        pastTrips.add(pastTrip);

        pastTrip = new PastTripsClass("Thursday 25 Oct 14:25", "Mbabane North, Zone 2");
        pastTrips.add(pastTrip);

        pastTrip = new PastTripsClass("Thursday 25 Oct 14:25", "Mbabane North, Zone 2");
        pastTrips.add(pastTrip);

    }
}
