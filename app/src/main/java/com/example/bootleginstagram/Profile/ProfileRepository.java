package com.example.bootleginstagram.Profile;

import com.example.bootleginstagram.InstagramUsers;

import java.util.List;

public class ProfileRepository implements ProfileRepositoryDataSource {

    private static ProfileRepository INSTANCE = null;

    private final ProfileRepositoryDataSource remoteDataSource;

    public static ProfileRepository getInstance(
            ProfileRepositoryDataSource remoteDataSource) {

        if (INSTANCE==null)
            INSTANCE = new ProfileRepository(remoteDataSource);
        return INSTANCE;

    }
    public ProfileRepository(ProfileRepositoryDataSource remoteSource){
        this.remoteDataSource=remoteSource;
    }
    @Override
    public void getUsers(UsersCallback callback) {
        remoteDataSource.getUsers(new UsersCallback() {
            @Override
            public void onSuccess(List<InstagramUsers> users) {
                callback.onSuccess(users);
            }

            @Override
            public void onError(String message) {
                callback.onError(message);
            }

            @Override
            public void onEmpty() {
                callback.onEmpty();
            }
        });

    }
}
