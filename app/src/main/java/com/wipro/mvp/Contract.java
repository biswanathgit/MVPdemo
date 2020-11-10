package com.wipro.mvp;

import com.wipro.mvp.common.BasePresenter;
import com.wipro.mvp.common.BaseView;

public interface Contract {
    interface View extends BaseView<Presenter> {

        void setData(String st);

        boolean isActive();
    }

    interface Presenter extends BasePresenter {
        void getData();
    }
}
