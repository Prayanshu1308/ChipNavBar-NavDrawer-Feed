package com.example.navbardrawerfeed;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class HomeFragment extends Fragment {

    private View homeFragmentView;
    private RecyclerView homeRecyclerView;
    ArrayList<feed> homeFragmentList;
    homeFragRecyclerAdapter homeFragRecyclerAdapter;

    public HomeFragment() {
        //Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        homeFragmentView = inflater.inflate(R.layout.fragment_home, container, false);

        homeRecyclerView = homeFragmentView.findViewById(R.id.homeRecyclerView);
        homeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        homeFragmentList = new ArrayList<>();

        homeFragmentList.add(new feed("Person A", "29-10-2020 05:40 PM", "no_post_img", "This is my first message on this app", "5"));
        homeFragmentList.add(new feed("Person B", "25-10-2020 06:35 PM", "has_image", "Labelled as a vegetable for nutritional purposes, tomatoes are a good source of vitamin C and the phytochemical lycopene. ", "10"));
        homeFragmentList.add(new feed("Person C", "24-10-2020 10:42 AM", "no_post_img", "This is my another message for every one on this app", "0"));
        homeFragmentList.add(new feed("Person D", "24-09-2020 01:17 PM", "has_img", "Additionally, a large percentage of the world’s tomato crop is used for processing; products include canned tomatoes, tomato juice, ketchup, puree, paste, and “sun-dried” tomatoes or dehydrated pulp.", "15"));
        homeFragmentList.add(new feed("Person E", "15-08-2020 06:23 AM", "no_post_img", "This is a message for the world", "6"));

        Comparator<feed> compareByDateAndTime = new Comparator<feed>() {
            @Override
            public int compare(feed f1, feed f2) {
                return f2.getPostDateAndTime().compareToIgnoreCase(f1.getPostDateAndTime());
            }
        };
        Collections.sort(homeFragmentList, compareByDateAndTime);

        homeFragRecyclerAdapter = new homeFragRecyclerAdapter(homeFragmentList, getContext());
        homeRecyclerView.setAdapter(homeFragRecyclerAdapter);

        return homeFragmentView;
    }
}