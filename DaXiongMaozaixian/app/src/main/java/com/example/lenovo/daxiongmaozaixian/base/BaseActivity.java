package com.example.lenovo.daxiongmaozaixian.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.lenovo.daxiongmaozaixian.app.App;
import com.example.lenovo.daxiongmaozaixian.utils.Tutils;

/**
 * Created by lenovo on 2017/11/27.
 */
public abstract class BaseActivity<P extends BasePresenter,M extends BaseModel> extends AppCompatActivity {
    public P mPresenter;
    public M mModle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        App.baseActivity = this;
        mPresenter = Tutils.getT(this,0);
        mModle = Tutils.getT(this,1);
        if (this instanceof BaseView){
            mPresenter.setMV(mModle,this);
        }
        initView();

    }

    public abstract void initView();

    protected abstract int getLayoutId();


}
