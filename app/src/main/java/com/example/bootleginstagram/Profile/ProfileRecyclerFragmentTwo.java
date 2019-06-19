package com.example.bootleginstagram.Profile;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bootleginstagram.SharedModels.InstagramUsers;
import com.example.bootleginstagram.R;

import java.util.List;

public class ProfileRecyclerFragmentTwo extends Fragment implements  ProfileRecyclerFragmentOneCallback{


    private RecyclerView recyclerView;
    private List<InstagramUsers> users;

    public  ProfileRecyclerFragmentTwo getInstance(List<InstagramUsers> users) {
        this.users=users;
        return this;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profiletablayout,container,false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.ProfileTabRecyclerOne);
        initRecyclerView();
    }



    @Override
    public void initRecyclerView() {

        RecyclerViewAdapterForProfileFeed adapter = new RecyclerViewAdapterForProfileFeed(users,getContext());

        recyclerView.setAdapter((adapter));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

    }


}
