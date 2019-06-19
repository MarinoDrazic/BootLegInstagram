package com.example.bootleginstagram.MainFeed;

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
import com.example.bootleginstagram.RecyclerAdapters.RecyclerViewAdapter;
import com.example.bootleginstagram.SharedModels.RemoteProfileDataSource;

import java.util.List;


public class MainFeedFragment extends Fragment {
//TODO Butterup this bitch
    RecyclerView recyclerView;
    private MainFeedPresenter presenter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mainfeedfrag,container,false);
        recyclerView=view.findViewById(R.id.rvFeed);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter= new MainFeedPresenter(this,
                MainFeedRepository.getInstance(RemoteProfileDataSource.getInstance()));
        presenter.getUsers();
    }

    public MainFeedFragment()
    {

    }

    public void initRecyclerView(List<InstagramUsers> users){
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(users,getContext());
        recyclerView.setAdapter((adapter));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    }

}
