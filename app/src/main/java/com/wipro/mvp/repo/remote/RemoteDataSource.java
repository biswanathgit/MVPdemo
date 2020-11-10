package com.wipro.mvp.repo.remote;

import android.util.Log;

import com.wipro.mvp.repo.DataSource;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RemoteDataSource implements DataSource {
    private static RemoteDataSource INSTANCE;

    // Prevent direct instantiation.
    private RemoteDataSource() {}


    public static RemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RemoteDataSource();
        }
        return INSTANCE;
    }

    @Override
    public void getRemoteData(String value, final GetCallback callback) {
        final ApiClient.GetData getData = ApiClient.getApiClient().create(ApiClient.GetData.class);
        final Call<List<HolderModel>> getDataCall = getData.getDataCall();
        getDataCall.enqueue(new Callback<List<HolderModel>>() {
            @Override
            public void onResponse(Call<List<HolderModel>> call, Response<List<HolderModel>> response) {
                callback.onSuccess(response.toString());
            }

            @Override
            public void onFailure(Call<List<HolderModel>> call, Throwable t) {
                callback.onError(t.getLocalizedMessage());
            }
        });
    }
}
