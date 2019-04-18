package com.example.bootleginstagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public BootlegInstagramApi bootlegInstagramApi;
    BootlegViewModel bootlegViewModel = new BootlegViewModel();
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.rvFeed);
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

    }
    private void initRecyclerView(List<InstagramUsers> users){
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(users,this);
        recyclerView.setAdapter((adapter));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
