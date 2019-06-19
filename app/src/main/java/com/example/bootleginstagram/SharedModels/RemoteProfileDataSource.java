package com.example.bootleginstagram.SharedModels;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteProfileDataSource implements ProfileRepositoryDataSource {

    private static RemoteProfileDataSource INSTANCE=null;

    BootlegInstagramApi bootlegInstagramApi;

    public static RemoteProfileDataSource getInstance()
    {
        if (INSTANCE==null)
            INSTANCE= new RemoteProfileDataSource();
        return INSTANCE;
    }

    @Override
    public void getUsers(UsersCallback callback) {
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
        Call<List<InstagramUsers>> call= bootlegInstagramApi.GetThemUsers();
        call.enqueue(new Callback<List<InstagramUsers>>() {
            @Override
            public void onResponse(Call<List<InstagramUsers>> call, Response<List<InstagramUsers>> response) {

                if (response.isSuccessful())
                    callback.onSuccess(response.body());
                else
                    callback.onError("Response is unsuccessful");
            }
            @Override
            public void onFailure(Call<List<InstagramUsers>> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }
}
