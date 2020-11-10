package com.wipro.mvp.repo;

public interface DataSource {
    interface GetCallback {

        void onSuccess(String st);

        void onError(String st);
    }
    void getRemoteData(String value, GetCallback callback);
}
