package com.example.lenovo.daxiongmaozaixian.fragment;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bartoszlipinski.recyclerviewheader.RecyclerViewHeader;
import com.bumptech.glide.Glide;
import com.example.lenovo.daxiongmaozaixian.R;
import com.example.lenovo.daxiongmaozaixian.base.BaseFragment;
import com.example.lenovo.daxiongmaozaixian.bean.MyAdapter1;
import com.example.lenovo.daxiongmaozaixian.bean.Student;
import com.example.lenovo.daxiongmaozaixian.login.LoginContract;
import com.example.lenovo.daxiongmaozaixian.login.LoginModel;
import com.example.lenovo.daxiongmaozaixian.login.LoginPresenter;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/27.
 */
public class FragmentTest1 extends BaseFragment<LoginPresenter, LoginModel> implements LoginContract.View {
    private RecyclerView recyclerView;
    private MyAdapter1 mAdapter;
    private RecyclerViewHeader recycle;
    private Banner banner;
    private ArrayList<String> arr = new ArrayList<>();
    private boolean boo = true;
    @Override
    protected void initData() {

    }

    @Override
    public int getLayoutIdFragment() {
        return R.layout.fragment_one;
    }

    @Override
    protected void initView(View view) {
        recycle = (RecyclerViewHeader) view.findViewById(R.id.Recycler);
        banner = (Banner) view.findViewById(R.id.Banner);
        recyclerView = (RecyclerView) view.findViewById(R.id.RecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        presenter.Loginas("http://mapi.univs.cn/mobile/index.php?app=mobile&type=mobile&controller=content&catid=14&page=1&action=index&time=0");
        if (boo){
            arr.add("http://upload.univs.cn/2017/0424/1493040123828.jpg");
            arr.add("http://upload.univs.cn/2017/0424/thumb_640_314_1493022268406.jpg");
            arr.add("http://upload.univs.cn/2017/0417/thumb_640_314_1492433907753.png");
            boo = false;
        }
        banner.setImages(arr)
                .setDelayTime(2000)
                .setBannerStyle(BannerConfig.NUM_INDICATOR)
                .setImageLoader(new Gilders())
                .setIndicatorGravity(BannerConfig.CENTER)
                .start();
        recycle.attachTo(recyclerView,true);

    }

    @Override
    public void show(String url) {
        Gson gson = new Gson();
        Student student = gson.fromJson(url, Student.class);
        List<Student.DataBean> data = student.getData();
        mAdapter = new MyAdapter1(data,getActivity().getApplicationContext());
        recyclerView.setAdapter(mAdapter);
    }
    public class Gilders extends ImageLoader{

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    }
}
