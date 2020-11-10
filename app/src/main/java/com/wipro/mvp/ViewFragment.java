package com.wipro.mvp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewFragment extends Fragment implements Contract.View {
    private static final String TAG = "ViewFragment";
    TextView textView;
    Contract.Presenter mPresenter;
    public ViewFragment() {
        // Required empty public constructor
    }

    public static ViewFragment newInstance() {
        ViewFragment fragment = new ViewFragment();
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View  v = inflater.inflate(R.layout.frag_main, container, false);
        textView = v.findViewById(R.id.textView);
        return v;

    }
    @Override
    public void onResume() {
        super.onResume();
        mPresenter.getData();
    }

    @Override
    public void setData(String st) {
        textView.setText("Hello \n" + st);
    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public void setPresenter(Contract.Presenter presenter) {
        mPresenter = presenter;
    }
}