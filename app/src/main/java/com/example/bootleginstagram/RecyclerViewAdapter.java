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

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHoler> {

    List<InstagramUsers> instagramUsers;
    private Context context;

    public RecyclerViewAdapter(List<InstagramUsers>instagramUsers, Context context)
    {
        this.instagramUsers =instagramUsers;
        this.context=context;

    }


    @NonNull
    @Override
    public ViewHoler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mainlayoutitem,viewGroup,false);
        ViewHoler holder = new ViewHoler(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoler viewHoler, int i) {
        Glide.with(context)
                .asBitmap()
                .load(instagramUsers.get(i).getUrls().getFull())
                .placeholder(R.drawable.img_feed_bottom_1)
                .into(viewHoler.ImageMain);
        Glide.with(context)
                .asBitmap()
                .load(instagramUsers.get(i).getUser().getProfileImage().getLarge())
                .into(viewHoler.ImageProfile);


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
