package com.example.bootleginstagram;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.Random;

public class RecyclerViewAdapterForProfileFeed extends RecyclerView.Adapter<RecyclerViewAdapterForProfileFeed.ViewHoler>{
    List<InstagramUsers> instagramUsers;
    private Context context;

    public RecyclerViewAdapterForProfileFeed(List<InstagramUsers>instagramUsers, Context context)
    {
        this.instagramUsers =instagramUsers;
        this.context=context;

    }


    @NonNull
    @Override
    public RecyclerViewAdapterForProfileFeed.ViewHoler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mainlayoutitem,viewGroup,false);
        RecyclerViewAdapterForProfileFeed.ViewHoler holder = new RecyclerViewAdapterForProfileFeed.ViewHoler(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterForProfileFeed.ViewHoler viewHoler, int i) {
        Random rand = new Random();

        Glide.with(context)
                .asBitmap()
                .load(instagramUsers.get(i).getUrls().getRegular())
                .placeholder(R.drawable.img_feed_bottom_1)
                .into(viewHoler.ImageMain);
        Glide.with(context)
                .asBitmap()
                .load(instagramUsers.get(0).getUser().getProfileImage().getMedium())
                .into(viewHoler.ImageProfile);
        viewHoler.Name.setText(instagramUsers.get(0).getUser().getName());
        viewHoler.Name2.setText(instagramUsers.get(rand.nextInt(10)).getUser().getFirstName());
        viewHoler.Name3.setText(instagramUsers.get(0).getUser().getName());
        viewHoler.RandomNum.setText(instagramUsers.get(i).getLikes()+" others.");

        if (instagramUsers.get(i).getDescription()!=null) {
            viewHoler.Desc.setText(instagramUsers.get(i).getDescription().toString());
        }else {
            viewHoler.Desc.setText("#NoDescription");
        }
        if (instagramUsers.get(i).getUser().getLocation()!=null) {
            viewHoler.Location.setText(instagramUsers.get(i).getUser().getLocation().toString());
        }else {
            viewHoler.Location.setText("");
        }

    }

    @Override
    public int getItemCount() {
        return instagramUsers.size();
    }

    public class ViewHoler extends RecyclerView.ViewHolder {
        ImageView ImageProfile;
        ImageView ImageMain;
        TextView Name;
        TextView Location;
        TextView Name2;
        TextView RandomNum;
        TextView Desc;
        TextView Name3;


        public ViewHoler(@NonNull View itemView) {
            super(itemView);
            ImageProfile = itemView.findViewById(R.id.imageProfile);
            ImageMain = itemView.findViewById(R.id.imageMain);
            Name= itemView.findViewById(R.id.Name);
            Location = itemView.findViewById(R.id.Location);
            Name2= itemView.findViewById(R.id.textLikedByName);
            RandomNum= itemView.findViewById(R.id.textNumber);
            Desc= itemView.findViewById(R.id.textDesc);
            Name3= itemView.findViewById(R.id.Name2);


        }
    }
}
