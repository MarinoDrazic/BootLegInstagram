package com.example.bootleginstagram.Search;
import android.util.Log;
import com.example.bootleginstagram.BootlegInstagramApi;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteSearchDataSource implements SearchRepositoryDataSource {
    private static RemoteSearchDataSource INSTANCE=null;
    BootlegInstagramApi bootlegInstagramApi;
    public static RemoteSearchDataSource getInstance()
    {
        if (INSTANCE==null)
            INSTANCE= new RemoteSearchDataSource();
        return INSTANCE;
    }
    @Override
    public void getImages(ImagesCallback callback,String querry) {

        OkHttpClient client = new OkHttpClient.Builder()//
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl("https://api.unsplash.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        bootlegInstagramApi = retrofit.create(BootlegInstagramApi.class);
        //Znan da je ovo extra skupo svaki put napravit Client i retrofit al Neman RestApiClienta
        //TODO napravi Simple Api i getRetroFitInstance().

        Call<SearchResults> call= bootlegInstagramApi.GetThemSearchResults(querry);
        call.enqueue(new Callback<SearchResults>() {
            @Override
            public void onResponse(Call<SearchResults> call, Response<SearchResults> response) {
                if (response.isSuccessful())
                {
                    if (response.body().getResults().size()>=18)
                        callback.onSuccess(response.body());
                    else if (response.body().getResults().size()==0)
                        callback.onEmpty();

                    else
                        callback.onNotEnoughImages(
                                "The Item you search for has only "
                                        +response.body().getResults().size()+
                                        " item. To correctly display data we need at least 18 items.");
                }
                else
                {
                    Log.e("onFailure", "onFailure: BigOOF");
                }

            }

            @Override
            public void onFailure(Call<SearchResults> call, Throwable t) {
                Log.e("onFailure", "onFailure: BigOOF");
            }
        });

    }
}
