package com.wipro.mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.wipro.mvp.common.ActivityUtils;
import com.wipro.mvp.repo.Repository;
import com.wipro.mvp.repo.local.LocalDataSource;
import com.wipro.mvp.repo.remote.RemoteDataSource;

public class MainActivity extends AppCompatActivity {

    ViewFragment viewFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewFragment = (ViewFragment) getSupportFragmentManager()
                .findFragmentById(R.id.contentFrame);

        ViewFragment viewFragment = (ViewFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);

        if (viewFragment == null) {
            viewFragment = ViewFragment.newInstance();

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), viewFragment, R.id.contentFrame);
        }

        // Create the presenter
        new Presenter(Repository.getInstance(RemoteDataSource.getInstance(),new LocalDataSource()),viewFragment);
        Log.d("Bis", "onCreate: ");
    }

}