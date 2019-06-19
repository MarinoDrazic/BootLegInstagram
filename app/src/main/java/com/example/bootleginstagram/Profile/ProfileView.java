package com.example.bootleginstagram.Profile;

import android.support.v4.view.ViewPager;

import com.example.bootleginstagram.SharedModels.InstagramUsers;

import java.util.List;

public interface ProfileView {
    void fillWithData(List<InstagramUsers> users);
    void setupViewPager(ViewPager viewPager);
}
