package com.example.bootleginstagram;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class SearchRecyclerViewAdapter extends RecyclerView.Adapter<SearchRecyclerViewAdapter.ViewHoler> {

    SearchResults searchResultsList;
    private Context context;
    int Brojac=0;

    public SearchRecyclerViewAdapter(SearchResults SearchRes, Context context)
    {
        this.searchResultsList =SearchRes;
        this.context=context;

    }
    @NonNull
    @Override
    public ViewHoler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.searchfragitem,viewGroup,false);
        SearchRecyclerViewAdapter.ViewHoler holder = new SearchRecyclerViewAdapter.ViewHoler(view);
        return holder;    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoler viewHoler, int i) {

        Glide.with(context)
                .asBitmap()
                .load(searchResultsList.getResults().get(Brojac).getUrls().getRegular())
                .into(viewHoler.Image1);
        Brojac++;
        Glide.with(context)
                .asBitmap()
                .load(searchResultsList.getResults().get(Brojac).getUrls().getRegular())
                .into(viewHoler.Image2);
        Brojac++;
        Glide.with(context)
                .asBitmap()
                .load(searchResultsList.getResults().get(Brojac).getUrls().getRegular())
                .into(viewHoler.Image3);
        Brojac++;
        Glide.with(context)
                .asBitmap()
                .load(searchResultsList.getResults().get(Brojac).getUrls().getRegular())
                .into(viewHoler.Image4);
        Brojac++;
        Glide.with(context)
                .asBitmap()
                .load(searchResultsList.getResults().get(Brojac).getUrls().getRegular())
                .into(viewHoler.Image5);
        Brojac++;
        Glide.with(context)
                .asBitmap()
                .load(searchResultsList.getResults().get(Brojac).getUrls().getRegular())
                .into(viewHoler.Image6);
        Brojac++;
    }

    @Override
    public int getItemCount() {
        return 3;//6 items can be shown,Called 18.18/6
    }

    public class ViewHoler extends RecyclerView.ViewHolder {
        ImageView Image1;
        ImageView Image2;
        ImageView Image3;
        ImageView Image4;
        ImageView Image5;
        ImageView Image6;

        boolean pressed;


        public ViewHoler(@NonNull View itemView) {
            super(itemView);
            Image1 = itemView.findViewById(R.id.imageView5);
            Image2 = itemView.findViewById(R.id.imageView6);
            Image3 = itemView.findViewById(R.id.imageView7);
            Image4 = itemView.findViewById(R.id.imageView8);
            Image5 = itemView.findViewById(R.id.imageView9);
            Image6 = itemView.findViewById(R.id.imageView10);





        }
    }
}
