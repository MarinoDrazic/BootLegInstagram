package com.example.bootleginstagram.Profile;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bootleginstagram.InstagramUsers;
import com.example.bootleginstagram.R;
import com.example.bootleginstagram.RecyclerViewAdapter;
import com.example.bootleginstagram.SectionsPageAdapter;

import java.util.List;

public class ProfileFragment extends Fragment {

    private ProfilePresenter presenter;
    View view;
    private ViewPager viewPager;
    private SectionsPageAdapter sectionsPageAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.profilefrag,container,false);

        sectionsPageAdapter = new SectionsPageAdapter(getActivity().getSupportFragmentManager());
        viewPager = view.findViewById(R.id.ViewPagerID2);
        setupViewPager(viewPager);
        TabLayout tabLayout = view.findViewById(R.id.ProfileTab);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //This just feels wrong?
        presenter= new ProfilePresenter(this,
                (ProfileRecyclerFragmentOne) sectionsPageAdapter.getItem(0),
                (ProfileRecyclerFragmentTwo) sectionsPageAdapter.getItem(1),
                (ProfileRecyclerFragmentTwo) sectionsPageAdapter.getItem(2),
                ProfileRepository.getInstance(RemoteProfileDataSource.getInstance()));
        presenter.getUsers();
    }

    private void setupViewPager(ViewPager viewPager)
    {
        sectionsPageAdapter.addFragment(new ProfileRecyclerFragmentOne(),"Grid" );
        sectionsPageAdapter.addFragment(new ProfileRecyclerFragmentTwo(),"MainFeed" );
        sectionsPageAdapter.addFragment(new ProfileRecyclerFragmentTwo(),"Grid2" );

        viewPager.setAdapter(sectionsPageAdapter);

    }

    public void FillWithData(List<InstagramUsers> users)
    {
        //TODO user butter
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
        //TODO split to make more readable or rework this completely.
        InstagramUsers User = users.get(0);
        Glide.with(getContext())
                .asBitmap()
                .load(User.getUser().getProfileImage().getLarge())
                .into(ProfileImage);
        ProfileName.setText(User.getUser().getInstagramUsername());
        Posts.setText(User.getUser().getTotalPhotos()+"\n Photos");
        Followers.setText(User.getUser().getTotalLikes()+"\n Likes");
        Following.setText(User.getUser().getTotalCollections()+"\nCollections");
        Description.setText(User.getUser().getBio());
    }


    }
