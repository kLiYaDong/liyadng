package com.example.lenovo.daxiongmaozaixian;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lenovo.daxiongmaozaixian.base.BaseActivity;
import com.example.lenovo.daxiongmaozaixian.bean.MyAdapter;
import com.example.lenovo.daxiongmaozaixian.fragment.FragmentTest1;
import com.example.lenovo.daxiongmaozaixian.fragment.FragmentTest2;
import com.example.lenovo.daxiongmaozaixian.fragment.FragmentTest3;
import com.example.lenovo.daxiongmaozaixian.fragment.FragmentTest4;
import com.example.lenovo.daxiongmaozaixian.fragment.FragmentTest5;
import com.example.lenovo.daxiongmaozaixian.login.LoginModel;
import com.example.lenovo.daxiongmaozaixian.login.LoginPresenter;

import java.util.ArrayList;

public class MainActivity extends BaseActivity<LoginPresenter,LoginModel> implements View.OnClickListener{
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MyAdapter adapter;
    private ArrayList<Fragment> mList = new ArrayList<>();
    private ArrayList<String> list = new ArrayList<>();
    private FragmentTest1 fragmentTest1;
    private FragmentTest2 fragmentTest2;
    private FragmentTest3 fragmentTest3;
    private FragmentTest4 fragmentTest4;
    private FragmentTest5 fragmentTest5;
    private Button mBut;
    @Override
    public void initView() {
        mBut = (Button) findViewById(R.id.Buton);
        mBut.setOnClickListener(this);
        tabLayout = (TabLayout) findViewById(R.id.TabLayout);
        viewPager = (ViewPager) findViewById(R.id.ViewPager);
        list.add("电影");
        list.add("新闻");
        list.add("热点");
        list.add("购物");
        list.add("学校");
        fragmentTest1 = new FragmentTest1();
        fragmentTest2 = new FragmentTest2();
        fragmentTest3 = new FragmentTest3();
        fragmentTest4 = new FragmentTest4();
        fragmentTest5 = new FragmentTest5();
        mList.add(fragmentTest1);
        mList.add(fragmentTest2);
        mList.add(fragmentTest3);
        mList.add(fragmentTest4);
        mList.add(fragmentTest5);
        adapter = new MyAdapter(getSupportFragmentManager(),mList,list);
        viewPager.setAdapter(adapter);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.Buton:
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
                break;
        }
    }
}
