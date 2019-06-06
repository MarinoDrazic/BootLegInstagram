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

import java.util.List;

public class ProfileRecyclerFragmentTwo extends Fragment {
    BootlegViewModel bootlegViewModel;
    View view;
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profiletablayout,container,false);
        recyclerView=view.getRootView().findViewById(R.id.ProfileTabRecyclerOne);
        bootlegViewModel= MainFeedFragment.GetBootlegViewModel();
        bootlegViewModel.getThemPickm8().observe(this, users -> initRecyclerView(users) );
        return view;
    }
    private void initRecyclerView(List<InstagramUsers> users){
        RecyclerViewAdapterForProfileFeed adapter = new RecyclerViewAdapterForProfileFeed(users,getContext());

        recyclerView.setAdapter((adapter));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

    }
}
