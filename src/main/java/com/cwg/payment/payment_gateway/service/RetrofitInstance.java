/*
 * Copyright (c) 2020. Magicfinger
 * Email: mikeossaiofficial@gmail.com
 * Tel: 07086737758
 */

package com.cwg.payment.payment_gateway.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;


public class RetrofitInstance {
    private static String BASE_URL = "http://app.kreer.ng/";
    private static String BASE_URL2 = "https://api.paystack.co";
    public static WebServices getService() {
        Interceptor authorizationInterceptor = chain -> {
            Request.Builder requestBuilder;
            Request original = chain.request();
            requestBuilder = original.newBuilder()
                    .header("Accept", "application/json")
                    .header("Content-Type", "application/json")
                    .method(original.method(), original.body());
            Request request = requestBuilder.build();
            // Response response = chain.proceed(request);
            return chain.proceed(request);
        };
        return getRetrofitBuilder(BASE_URL)
                .client(buildHttpClient(authorizationInterceptor))
                .build()
                .create(WebServices.class);
    }

    public static WebServices getPaystackService() {
        Interceptor authorizationInterceptor = chain -> {
            Request.Builder requestBuilder;
            Request original = chain.request();
            requestBuilder = original.newBuilder()
                    .header("Accept", "application/json")
                    .header("Content-Type", "application/json")
                    .header("Authorization","Bearer sk_test_32dec3511794fb3cfd9a4b6854c240ef6de55041")
                    .method(original.method(), original.body());
            Request request = requestBuilder.build();
            // Response response = chain.proceed(request);
            return chain.proceed(request);
        };
        return getRetrofitBuilder(BASE_URL2)
                .client(buildHttpClient(authorizationInterceptor))
                .build()
                .create(WebServices.class);
    }

    private static OkHttpClient buildHttpClient(Interceptor authorizationInterceptor) {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS);
        httpClientBuilder.addInterceptor(authorizationInterceptor);
        httpClientBuilder.addInterceptor(getLoggingInterceptor());
        return httpClientBuilder.build();
    }

    private static HttpLoggingInterceptor getLoggingInterceptor() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        return logging;
    }

    private static Retrofit.Builder getRetrofitBuilder(String baseUrl) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson));
    }
}