package com.example.bootleginstagram.Profile;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import com.example.bootleginstagram.R;
import com.example.bootleginstagram.SharedModels.InstagramUsers;
import com.example.bootleginstagram.SharedModels.RemoteProfileDataSource;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileFragment extends Fragment implements ProfileView {

    private ProfilePresenter presenter;
    private ViewPager viewPager;
    private SectionsPageAdapter sectionsPageAdapter;
    private ProfileRecyclerFragmentOneCallback callback;
    private ProfileRecyclerFragmentOneCallback callback2;
    private ProfileRecyclerFragmentOneCallback callback3;

    @BindView(R.id.imageProfile)
    ImageView profileImage;
    @BindView(R.id.textViewUserName)
    TextView ProfileName;
    @BindView(R.id.textViewPosts)
    TextView Posts;
    @BindView(R.id.textViewFollowers)
    TextView Followers;
    @BindView(R.id.textViewFollowing)
    TextView Following;
    @BindView(R.id.textViewDescription)
    TextView Description;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.profilefrag, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        presenter = new ProfilePresenter(this,
                ProfileRepository.getInstance(RemoteProfileDataSource.getInstance()));
        presenter.getUsers();
        ButterKnife.bind(this,view);
    }


    @Override
    public void fillWithData(List<InstagramUsers> users) {

        callback = new ProfileRecyclerFragmentOne().getInstance(users);
        callback2 = new ProfileRecyclerFragmentTwo().getInstance(users);
        callback3 = new ProfileRecyclerFragmentTwo().getInstance(users);
        sectionsPageAdapter = new SectionsPageAdapter(getActivity().getSupportFragmentManager());
        viewPager = this.getView().findViewById(R.id.ViewPagerID2);
        viewPager.setOffscreenPageLimit(10);
        setupViewPager(viewPager);
        TabLayout tabLayout = this.getView().findViewById(R.id.ProfileTab);
        tabLayout.setupWithViewPager(viewPager);

        //TODO rework this completely.

        InstagramUsers User = users.get(1);

        Glide.with(getContext())
                .asBitmap()
                .load(User.getUser().getProfileImage().getLarge())
                .into(profileImage);
        ProfileName.setText(User.getUser().getInstagramUsername());
        Posts.setText(User.getUser().getTotalPhotos() + "\n Photos");
        Followers.setText(User.getUser().getTotalLikes() + "\n Likes");
        Following.setText(User.getUser().getTotalCollections() + "\nCollections");
        Description.setText(User.getUser().getBio());

    }

    @Override
    public void setupViewPager(ViewPager viewPager) {

        sectionsPageAdapter.addFragment((ProfileRecyclerFragmentOne)callback, "Grid");
        sectionsPageAdapter.addFragment((ProfileRecyclerFragmentTwo)callback2, "MainFeed");
        sectionsPageAdapter.addFragment((ProfileRecyclerFragmentTwo)callback3, "MainFeed");

        viewPager.setAdapter(sectionsPageAdapter);

    }
}
