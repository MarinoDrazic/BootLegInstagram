package com.example.bootleginstagram;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainFeedFragment extends Fragment {
    BootlegViewModel bootlegViewModel = new BootlegViewModel();
    public BootlegInstagramApi bootlegInstagramApi;
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mainfeedfrag,container,false);

        recyclerView =view.getRootView().findViewById(R.id.rvFeed);
        OkHttpClient client = new OkHttpClient.Builder()//
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl("https://api.unsplash.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        bootlegInstagramApi = retrofit.create(BootlegInstagramApi.class);
        bootlegViewModel.fetchData(bootlegInstagramApi);
        bootlegViewModel.getThemPickm8().observe(this, users -> initRecyclerView(users) );
        return view;
    }
    public MainFeedFragment()
    {

    }
    private void initRecyclerView(List<InstagramUsers> users){
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(users,getContext());
        recyclerView.setAdapter((adapter));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    }

}
