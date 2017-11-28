package com.example.lenovo.daxiongmaozaixian.login;

import com.example.lenovo.daxiongmaozaixian.base.BaseModel;
import com.example.lenovo.daxiongmaozaixian.base.BasePresenter;
import com.example.lenovo.daxiongmaozaixian.base.BaseView;

/**
 * Created by lenovo on 2017/11/27.
 */
public interface LoginContract {

    interface View extends BaseView {
      void show(String url);
    }

    interface Model extends BaseModel {
        void getModle(String url,CallBacks callBacks);
    }

    abstract static class Presenter extends BasePresenter<Model, View> {

        @Override
        public void onStart() {

        }
        public abstract void Loginas(String url);
    }
}