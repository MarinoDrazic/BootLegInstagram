package com.example.bootleginstagram.Search;

public class SearchPresenter {
    private SearchRepository repository;
    SearchFragment view;
    public SearchPresenter (SearchFragment view,SearchRepository repository)
    {
        this.view=view;
        this.repository=repository;
    }
    public  void getImagesData(String querry)
    {
        repository.getImages(new SearchRepositoryDataSource.ImagesCallback() {
            @Override
            public void onSuccess(SearchResults searchResults) {
                view.initRecyclerView(searchResults);
            }

            @Override
            public void onNotEnoughImages(String AmountOfImagesFetched) {
                //TODO connect to view method
            }

            @Override
            public void onEmpty() {
                //TODO connect to view method

            }
        },querry);
    }
}
