package com.example.bootleginstagram.ViewOtherUser;

import com.example.bootleginstagram.SharedModels.UserPhotos;

import java.util.List;

public interface OtherUserProfileRepositoryDataSource {
    interface UserImagesCallback
    {
        void onSuccess(List<UserPhotos> userPhotos);
        void onInvalidUser(String message);
    }

    void getUserImages(UserImagesCallback callback);
}
