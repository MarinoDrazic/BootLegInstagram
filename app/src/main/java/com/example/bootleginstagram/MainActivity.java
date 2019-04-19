package com.example.bootleginstagram;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
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
    private ViewPager viewPager;
    private SectionsPageAdapter sectionsPageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.ViewPagerID);
        setupViewPager(viewPager);
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

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
    private void setupViewPager(ViewPager viewPager)
    {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new MainFeedFragment(),"MainFeed" );
        adapter.addFragment(new ProfileFragment(),"MainFeed" );
        viewPager.setAdapter(adapter);

    }
}
