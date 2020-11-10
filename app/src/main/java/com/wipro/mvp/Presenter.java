package com.wipro.mvp;

import android.util.Log;

import com.wipro.mvp.Contract;
import com.wipro.mvp.repo.DataSource;
import com.wipro.mvp.repo.Repository;

public class Presenter implements Contract.Presenter {
    private static final String TAG = "Presenter";
    private final Repository mRepository;

    private final Contract.View mView;

    public Presenter(Repository repository, Contract.View view) {
        mRepository = repository;
        mView = view;

        mView.setPresenter(this);
    }

    @Override
    public void getData() {
        mRepository.getRemoteData("hello repo", new DataSource.GetCallback() {
            @Override
            public void onSuccess(String st) {
                mView.setData(st);
            }

            @Override
            public void onError(String error) {
                Log.d(TAG, "onError: " +error);
            }
        });
    }

    @Override
    public void start() {

    }
}
