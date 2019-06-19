package com.example.bootleginstagram.MainFeed;

import com.example.bootleginstagram.SharedModels.InstagramUsers;
import com.example.bootleginstagram.SharedModels.ProfileRepositoryDataSource;

import java.util.List;

public class MainFeedRepository implements ProfileRepositoryDataSource {

    private static MainFeedRepository INSTANCE = null;

    private ProfileRepositoryDataSource remoteSource;

    public static  MainFeedRepository getInstance(ProfileRepositoryDataSource remoteSource)
    {
        if (INSTANCE==null)
            INSTANCE= new MainFeedRepository(remoteSource );
        return INSTANCE;
    }
    public MainFeedRepository(ProfileRepositoryDataSource remoteSource)
    {
        this.remoteSource=remoteSource;
    }

    @Override
    public void getUsers(UsersCallback callback) {
    remoteSource.getUsers(new UsersCallback() {
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
