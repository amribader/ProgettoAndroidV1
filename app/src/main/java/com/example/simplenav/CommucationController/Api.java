package com.example.simplenav.CommucationController;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface Api {
    String BASE_URL = "https://develop.ewlab.di.unimi.it/mc/twittok/";

    @POST("getTwok")
    Call<GetTwok> getTwok(@Body GetTwok sid);

//    @POST("getPicture")
//    Call<GetPicture> getPicture(@Body String body);

    @FormUrlEncoded
    @POST("getPicture")
    Call<GetPicture> getPicture(@Field("sid") String sid, @Field("uid") String uid);


}
