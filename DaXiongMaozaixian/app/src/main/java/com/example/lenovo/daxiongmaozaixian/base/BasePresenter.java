package com.example.lenovo.daxiongmaozaixian.base;

/**
 * Created by lenovo on 2017/11/27.
 */
public abstract class BasePresenter<M,V> {
    public M baseModle;
    public V baseView;
    public void setMV(M m,V v){
        baseModle = m;
        baseView = v;
        this.onStart();
    }
    public abstract void onStart();
}
