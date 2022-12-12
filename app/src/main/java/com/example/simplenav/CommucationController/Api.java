package com.example.simplenav.CommucationController;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Api {
    String BASE_URL = "https://develop.ewlab.di.unimi.it/mc/twittok/";

    @POST("getTwok")
    Call<GetTwok> getTwok(@Body GetTwok sid);



}
