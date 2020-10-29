package com.example.navbardrawerfeed;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class homeFragRecyclerAdapter extends RecyclerView.Adapter {


    ArrayList<feed> homeFragmentList;
    Context myContext;

    public homeFragRecyclerAdapter(ArrayList<feed> homeFragmentList, Context context) {
        this.homeFragmentList = homeFragmentList;
        this.myContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.each_feed, parent, false);
        return new homeFragRecyclerAdapter.FeedHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        final FeedHolder FeedHolder = (FeedHolder)holder;

        final feed feed = homeFragmentList.get(position);

        FeedHolder.feedProfileName.setText(feed.getProfileName());
        FeedHolder.feedDateAndTime.setText(feed.getPostDateAndTime());

        String PostImageUrl = feed.getPostImageUrl();
        if(!PostImageUrl.equals("no_post_img")){
            FeedHolder.feedImage.setImageResource(R.drawable.tomatoes);
        }else {
            FeedHolder.feedImage.setVisibility(View.GONE);
        }

        FeedHolder.feedText.setText(feed.getPostMessage());

        FeedHolder.feedLikes.setText(feed.getPostLikes()+" Likes");



    }

    @Override
    public int getItemCount() {
        return homeFragmentList == null? 0: homeFragmentList.size();
    }


    public class FeedHolder extends RecyclerView.ViewHolder {

        TextView feedProfileName;
        TextView feedDateAndTime;
        ImageView feedImage;
        TextView feedText;
        TextView feedLikes;

        public FeedHolder(View itemView) {
            super(itemView);
            feedProfileName = itemView.findViewById(R.id.each_post_name_text_view);
            feedDateAndTime= itemView.findViewById(R.id.each_post_date_and_time_text_view);
            feedImage = itemView.findViewById(R.id.feed_image);
            feedText = itemView.findViewById(R.id.feed_text);
            feedLikes = itemView.findViewById(R.id.feed_likes);
        }

    }



}
