package com.example.lenovo.daxiongmaozaixian.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.daxiongmaozaixian.utils.Tutils;

/**
 * A simple {@link Fragment} subclass.
 */
public  abstract class BaseFragment<P extends BasePresenter,M extends BaseModel>  extends Fragment{
    public P presenter;
    public M model;
    private View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        presenter = Tutils.getT(this, 0);
        model = Tutils.getT(this, 1);
        if (this instanceof BaseView) {
            presenter.setMV(model,this);
        }

        view = inflater.inflate(getLayoutIdFragment(), container, false);
        initView(view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();
    }

    protected abstract void initData();

    public abstract int getLayoutIdFragment();

    protected abstract void initView(View view);


}
