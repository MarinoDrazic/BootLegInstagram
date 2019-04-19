package com.example.bootleginstagram;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BootlegInstagramApi {
    @GET("photos?per_page=20&client_id=d19195f7799ac9b6046a1a4392790e3f5643ba35a2933ab38046e4dae862cb38")
    Call<List<InstagramUsers>> GetThemUsers();

}
