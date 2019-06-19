package com.example.bootleginstagram.SharedModels;

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
