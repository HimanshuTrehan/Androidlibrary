package com.himanshu.customergludemolibrary;



import com.himanshu.customergludemolibrary.Modal.EventData;
import com.himanshu.customergludemolibrary.Modal.RegisterModal;
import com.himanshu.customergludemolibrary.Modal.RegisterObject;
import com.himanshu.customergludemolibrary.Modal.RewardModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @POST("user/v1/user/sdk?token=true")
    @FormUrlEncoded
    Call<RegisterModal> doRegister(
            @Field("userId") String userId,
            @Field("writeKey") String writeKey);


    @POST("user/v1/user/sdk?token=true")

    Call<RegisterModal> doRegisterWithNotification(
            @Body RegisterObject registerObject
            );

    @GET("reward/v1.1/user")
    Call<RewardModel> customerRetrieveData(
            @Query("type") String type
    );
    @POST("https://stream.customerglu.com/v3/server")
    Call<RegisterModal> sendEvents(@Header("x-api-key") String key,
            @Body EventData eventData);




}
