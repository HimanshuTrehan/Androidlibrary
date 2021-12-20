package com.himanshu.customergludemolibrary;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.himanshu.customergludemolibrary.URLHelper.BaseUrl;

public class ApiClients {
    public static String bearer_token ="";

    public static Retrofit retrofit = null;
    private static OkHttpClient okHttpClient;
    private static Retrofit retrofit1 = null;
    private static OkHttpClient okHttpClient1;

    public static Retrofit getClient() {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        initOkHttp();

        if (retrofit == null) {

            retrofit = new Retrofit.Builder()
                    .baseUrl(BaseUrl)
                    .client(okHttpClient)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }

        return retrofit;
    }

    private static void initOkHttp() {

        OkHttpClient.Builder httpClient = new OkHttpClient().newBuilder();
        httpClient.connectTimeout(300, TimeUnit.SECONDS)
                .writeTimeout(300, TimeUnit.SECONDS)
                .readTimeout(300, TimeUnit.SECONDS);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(interceptor);
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();

                Request.Builder requestBuilder = original.newBuilder()
                        .addHeader("Content-Type", "application/x-www-form-urlencoded");

                Request request = requestBuilder.build();
                //request.header(token);
                return chain.proceed(request);
            }
        });

        okHttpClient = httpClient.build();
    }

    public static Retrofit getClient_token(String token) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        initOkHttp_token(token);

        if (retrofit1 == null) {
            retrofit1 = new Retrofit.Builder()
                    .baseUrl(BaseUrl)
                    .client(okHttpClient1)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit1;
    }

    private static void initOkHttp_token(String token) {
        System.out.println("token " +token);
        bearer_token = "Bearer "+token;
        OkHttpClient.Builder httpClient = new OkHttpClient().newBuilder();
        httpClient.connectTimeout(300, TimeUnit.SECONDS)
                .writeTimeout(300, TimeUnit.SECONDS)
                .readTimeout(300, TimeUnit.SECONDS);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(interceptor);
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                Request.Builder requestBuilder = original.newBuilder()
                        .addHeader("Accept", "application/json")
                        .header("Content-Type", "application/json")
                        .header("Authorization",bearer_token);
                       // .addHeader("x-api-key", token);

                Request request = requestBuilder.build();
                //request.header(token);
                return chain.proceed(request);
            }
        });

        okHttpClient1 = httpClient.build();


    }


}
