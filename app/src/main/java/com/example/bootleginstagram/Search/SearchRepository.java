package com.example.bootleginstagram.Search;

public class SearchRepository implements SearchRepositoryDataSource {

    private static SearchRepository INSTANCE = null;

    private final SearchRepositoryDataSource remoteDataSource;

    public static synchronized  SearchRepository getInstance(
            SearchRepositoryDataSource remoteDataSource)    {
        if (INSTANCE==null)
            INSTANCE = new SearchRepository(remoteDataSource);
        return INSTANCE;
    }
    private  SearchRepository(SearchRepositoryDataSource remoteDataSource)
    {
        this.remoteDataSource=remoteDataSource;
    }

    @Override
    public void getImages(ImagesCallback callback,String querry) {
        remoteDataSource.getImages(new ImagesCallback() {
            @Override
            public void onSuccess(SearchResults searchResults) {
                callback.onSuccess(searchResults);
            }

            @Override
            public void onNotEnoughImages(String AmountOfImagesFetched) {
                callback.onNotEnoughImages(AmountOfImagesFetched);
            }

            @Override
            public void onEmpty() {
                callback.onEmpty();
            }
        },querry);


    }
}
