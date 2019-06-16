package com.example.bootleginstagram.Profile;

import com.example.bootleginstagram.InstagramUsers;

import java.util.List;

public interface ProfileRepositoryDataSource {
    interface UsersCallback
    {
        void onSuccess(List<InstagramUsers> users);
        void onError(String message);
        void onEmpty();
    }
    void getUsers(UsersCallback callback);
}
