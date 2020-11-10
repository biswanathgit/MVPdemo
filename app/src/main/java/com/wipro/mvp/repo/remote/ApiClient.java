package com.wipro.mvp.repo.remote;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public class ApiClient {
    private static final String url = "https://jsonplaceholder.typicode.com/";



    public static Retrofit getApiClient() {
        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public interface GetData {
        @Headers("Content-Type: application/json")
        @GET("/photos")
        Call<List<HolderModel>> getDataCall();
    }

}

