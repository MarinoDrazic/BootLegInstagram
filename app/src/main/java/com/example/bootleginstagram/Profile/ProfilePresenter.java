package com.example.bootleginstagram.Profile;

import com.example.bootleginstagram.SharedModels.InstagramUsers;
import com.example.bootleginstagram.SharedModels.ProfileRepositoryDataSource;

import java.util.List;

public class ProfilePresenter {

    private ProfileRepository repository;
    private ProfileView view;

    public ProfilePresenter(ProfileView view,
                            ProfileRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    public void getUsers() {
        repository.getUsers(new ProfileRepositoryDataSource.UsersCallback() {
            @Override
            public void onSuccess(List<InstagramUsers> users) {
                view.fillWithData(users);

            }

            @Override
            public void onError(String message) {
                //TODO

            }

            @Override
            public void onEmpty() {
                //TODO

            }
        });
    }
}
