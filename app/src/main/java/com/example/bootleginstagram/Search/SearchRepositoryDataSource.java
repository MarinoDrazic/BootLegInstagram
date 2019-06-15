package com.example.bootleginstagram.Search;

public interface SearchRepositoryDataSource {
    interface ImagesCallback
    {
        void onSuccess(SearchResults searchResults);
        void onNotEnoughImages(String AmountOfImagesFetched);
        void onEmpty();
    }
    void getImages(ImagesCallback callback,String querry);
}
