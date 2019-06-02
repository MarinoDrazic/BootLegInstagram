package com.example.bootleginstagram;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ProfileFragment extends Fragment {
    BootlegViewModel bootlegViewModel;
    View view;
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.profilefrag,container,false);
        recyclerView=view.getRootView().findViewById(R.id.MainProgileRecycler);
        bootlegViewModel= MainFeedFragment.GetBootlegViewModel();
        bootlegViewModel.getThemPickm8().observe(this, users -> FillWithData(users)  );
        bootlegViewModel.getThemPickm8().observe(this, users -> initRecyclerView(users) );


        return view;
    }
    private void FillWithData(List<InstagramUsers> users)
    {
        ImageView ProfileImage;
        TextView ProfileName;
        TextView Posts;
        TextView Followers;
        TextView Following;
        TextView Description;
        ProfileImage=view.findViewById(R.id.imageProfile);
        ProfileName =view.findViewById(R.id.textViewUserName);
        Posts =view.findViewById(R.id.textViewPosts);
        Followers =view.findViewById(R.id.textViewFollowers);
        Following =view.findViewById(R.id.textViewFollowing);
        Description =view.findViewById(R.id.textViewDescription);
        InstagramUsers User = users.get(0);
        Glide.with(getContext())
                .asBitmap()
                .load(User.getUser().getProfileImage().getLarge())
                .into(ProfileImage);
        ProfileName.setText(User.getUser().getInstagramUsername());
        Posts.setText("   "+User.getUser().getTotalPhotos()+"\n Photos");
        Followers.setText("    "+User.getUser().getTotalLikes()+"\n Likes");
        Following.setText("      "+User.getUser().getTotalCollections()+"\nCollections");
        Description.setText(User.getUser().getBio());
    }
    private void initRecyclerView(List<InstagramUsers> users){
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(users,getContext());
        recyclerView.setAdapter((adapter));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    }
