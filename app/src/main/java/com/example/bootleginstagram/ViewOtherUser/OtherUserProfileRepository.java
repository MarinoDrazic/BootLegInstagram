package com.example.bootleginstagram.ViewOtherUser;

import com.example.bootleginstagram.SharedModels.UserPhotos;

import java.util.List;

public class OtherUserProfileRepository implements OtherUserProfileRepositoryDataSource {
    private static OtherUserProfileRepository INSTANCE = null;

    private  OtherUserProfileRepositoryDataSource remoteSource;

    public static OtherUserProfileRepository getINSTANCE(
            OtherUserProfileRepositoryDataSource remoteSource)
    {
        if(INSTANCE==null)
            INSTANCE= new OtherUserProfileRepository(remoteSource);
        return INSTANCE;
    }
    public OtherUserProfileRepository(OtherUserProfileRepositoryDataSource remoteSource)
    {
        this.remoteSource=remoteSource;
    }

    @Override
    public void getUserImages(UserImagesCallback callback) {
    remoteSource.getUserImages(new UserImagesCallback() {
        @Override
        public void onSuccess(List<UserPhotos> userPhotos) {
            callback.onSuccess(userPhotos);
        }

        @Override
        public void onInvalidUser(String message) {
            callback.onInvalidUser(message);
        }
    });
    }
}
