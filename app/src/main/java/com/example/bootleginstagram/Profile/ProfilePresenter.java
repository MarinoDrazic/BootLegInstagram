package com.example.bootleginstagram.Profile;

import com.example.bootleginstagram.InstagramUsers;

import java.util.List;

public class ProfilePresenter {

    private ProfileRepository repository;

    ProfileFragment MainFrag;
    ProfileRecyclerFragmentOne fragmentOne;
    ProfileRecyclerFragmentTwo fragmentTwo;
    ProfileRecyclerFragmentTwo fragmentThree;

    public ProfilePresenter(ProfileFragment MainFrag,
                            ProfileRecyclerFragmentOne fragmentOne,
                            ProfileRecyclerFragmentTwo fragmentTwo,
                            ProfileRecyclerFragmentTwo fragmentThree,
                            ProfileRepository repository)    {
        this.MainFrag=MainFrag;
        this.fragmentOne=fragmentOne;
        this.fragmentTwo=fragmentTwo;
        this.fragmentThree=fragmentThree;
        this.repository=repository;
    }
    public void getUsers()
    {
        repository.getUsers(new ProfileRepositoryDataSource.UsersCallback() {
            @Override
            public void onSuccess(List<InstagramUsers> users) {
                MainFrag.FillWithData(users);
                fragmentOne.initRecyclerView(users);
                fragmentTwo.initRecyclerView(users);
                fragmentThree.initRecyclerView(users);
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
