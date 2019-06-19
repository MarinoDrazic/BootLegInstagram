package com.example.bootleginstagram.MainFeed;

import com.example.bootleginstagram.SharedModels.InstagramUsers;
import com.example.bootleginstagram.SharedModels.ProfileRepositoryDataSource;

import java.util.List;

public class MainFeedPresenter {
    private MainFeedRepository repository;
    //TODO make an abstract MainfeedFrag.
    private MainFeedFragment fragment;

    public MainFeedPresenter(MainFeedFragment fragment, MainFeedRepository repository) {
        this.fragment=fragment;
        this.repository = repository;
    }
    public void getUsers(){

        repository.getUsers(new ProfileRepositoryDataSource.UsersCallback() {
            @Override
            public void onSuccess(List<InstagramUsers> users) {
                fragment.initRecyclerView(users);
            }

            @Override
            public void onError(String message) {

            }

            @Override
            public void onEmpty() {

            }
        });
    }
}
