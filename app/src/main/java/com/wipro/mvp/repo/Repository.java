package com.wipro.mvp.repo;

import android.util.Log;

public class Repository implements DataSource{
    private static Repository INSTANCE = null;

    private final DataSource mRemoteDataSource;

    private final DataSource mLocalDataSource;

    // Prevent direct instantiation.
    public Repository(DataSource remoteDataSource, DataSource localDataSource) {
        mRemoteDataSource = remoteDataSource;
        mLocalDataSource = localDataSource;
    }

    public static Repository getInstance(DataSource remoteDataSource,DataSource localDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new Repository(remoteDataSource, localDataSource);
        }
        return INSTANCE;
    }

    @Override
    public void getRemoteData(String value, GetCallback callback) {
        mRemoteDataSource.getRemoteData(value,callback);
    }
}
