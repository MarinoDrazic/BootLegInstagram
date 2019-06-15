package com.example.bootleginstagram;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.bootleginstagram.Search.SearchResults;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BootlegViewModel {

    public MutableLiveData<List<InstagramUsers>> PokemonMutableLiveData = new MutableLiveData<List<InstagramUsers>>();
    public LiveData<List<InstagramUsers>> getThemPickm8(){
        LiveData<List<InstagramUsers>>PokemonToReturn = PokemonMutableLiveData;
        return PokemonToReturn;   }

    public MutableLiveData<SearchResults> SearchResultsQuerry = new MutableLiveData<SearchResults>();
    public LiveData<SearchResults> GetThemSearchResults(){
        LiveData<SearchResults>PokemonToReturn = SearchResultsQuerry;
        return PokemonToReturn;   }

    public void fetchData(BootlegInstagramApi bootlegInstagramApi)
    {
        Call<List<InstagramUsers>> call= bootlegInstagramApi.GetThemUsers();
        call.enqueue(new Callback<List<InstagramUsers>>() {
            @Override
            public void onResponse(Call<List<InstagramUsers>> call, Response<List<InstagramUsers>> response) {
                if (response.isSuccessful())
                {
                    PokemonMutableLiveData.postValue(response.body());
                }
                else
                {
                    Log.e("onFailure", "onFailure: BigOOF");
                }
            }
            @Override
            public void onFailure(Call<List<InstagramUsers>> call, Throwable t) {
                Log.e("onFailure", "onFailure: BigOOF");
            }
        });
    }



    public void fetchSearchResults(BootlegInstagramApi bootlegInstagramApi,String querry)
    {
        Call<SearchResults> call= bootlegInstagramApi.GetThemSearchResults(querry);
        call.enqueue(new Callback<SearchResults>() {
            @Override
            public void onResponse(Call<SearchResults> call, Response<SearchResults> response) {
                if (response.isSuccessful())
                {
                    SearchResultsQuerry.postValue(response.body());
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
