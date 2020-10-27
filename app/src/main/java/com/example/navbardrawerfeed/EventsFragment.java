package com.example.navbardrawerfeed;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class EventsFragment extends Fragment {

    private View eventsFragmentView;

    public EventsFragment() {
        //Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        eventsFragmentView = inflater.inflate(R.layout.fragment_events, container, false);



        return eventsFragmentView;
    }
}