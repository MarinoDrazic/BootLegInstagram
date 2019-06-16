package com.example.bootleginstagram;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.bootleginstagram.Profile.ProfileFragment;
import com.example.bootleginstagram.Search.SearchFragment;

public class MainActivity extends AppCompatActivity {

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




    }

    private void setupViewPager(ViewPager viewPager)
    {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new MainFeedFragment(),"MainFeed" );
        adapter.addFragment(new SearchFragment(),"MainFeed" );
        adapter.addFragment(new ProfileFragment(),"MainFeed" );
        viewPager.setAdapter(adapter);

    }
}
