package com.example.bootleginstagram.RecyclerAdapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.bootleginstagram.R;
import com.example.bootleginstagram.SharedModels.InstagramUsers;

import java.util.List;

public class GridRecyclerViewAdapter extends RecyclerView.Adapter<GridRecyclerViewAdapter.ViewHoler>{

    List<InstagramUsers> instagramUsers;
    private Context context;

    public GridRecyclerViewAdapter(List<InstagramUsers>instagramUsers, Context context)
    {
        this.instagramUsers =instagramUsers;
        this.context=context;

    }


    @NonNull
    @Override
    public GridRecyclerViewAdapter.ViewHoler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.gridimageforrecycler,viewGroup,false);
        GridRecyclerViewAdapter.ViewHoler holder = new GridRecyclerViewAdapter.ViewHoler(view);

        //view.getLayoutParams().height=500;
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoler viewHoler, int i) {
        Glide.with(context)
                .asBitmap()
                .load(instagramUsers.get(i).getUrls().getRegular())
                .override(200, 200)
                .centerCrop()
                .placeholder(R.drawable.img_feed_bottom_1)
                .into(viewHoler.ImageMain);
    }


    public int getItemCount() {
        return instagramUsers.size();
    }

    public class ViewHoler extends RecyclerView.ViewHolder {
        ImageView ImageMain;
        public ViewHoler(@NonNull View itemView) {
            super(itemView);
            ImageMain = itemView.findViewById(R.id.imageViewGrid);
        }
    }
}
