package com.example.lenovo.daxiongmaozaixian.bean;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by lenovo on 2017/11/27.
 */
public class MyAdapter extends FragmentPagerAdapter{
    private ArrayList<Fragment> mList;
    private ArrayList<String> list;
    public MyAdapter(FragmentManager fm,ArrayList<Fragment> mList,ArrayList<String> list) {
        super(fm);
        this.mList = mList;
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.isEmpty()?0:mList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }
}
