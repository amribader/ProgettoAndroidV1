package com.example.simplenav.CommucationController;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {
    String BASE_URL = "https://develop.ewlab.di.unimi.it/mc/twittok/";

    @POST("getTwok")
    Call<GetTwok> getTwok(@Body GetTwok sid);

//    @POST("getPicture")
//    Call<GetPicture> getPicture(@Body String body);

    @FormUrlEncoded
    @POST("getPicture")
    Call<GetPicture> getPicture(@Field("sid") String sid, @Field("uid") String uid);

//    @FormUrlEncoded
//    @POST("setProfile")
//    void setProfile(@Field("sid") String sid, @Field("name") String name, @Field("picture") String picture);

    @POST("setProfile")
    Call<Void> setProfile(@Body setProfileI profile);
    
    @POST("getProfile")
    Call<setProfileI> getProfile(@Body String sid);




}
