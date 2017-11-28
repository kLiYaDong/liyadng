package com.example.lenovo.daxiongmaozaixian.bean;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.daxiongmaozaixian.R;

import java.util.List;

/**
 * Created by lenovo on 2017/11/27.
 */
public class MyAdapter1 extends RecyclerView.Adapter<MyAdapter1.Holder> {
    private List<Student.DataBean> mList;
    private Context context;

    public MyAdapter1(List<Student.DataBean> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter, parent, false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Student.DataBean dataBean = mList.get(position);
        holder.mName.setText(dataBean.getTitle());
        holder.mName1.setText(dataBean.getDescription());
        String img1 = dataBean.getThumb();
        Glide.with(context).load(img1).into(holder.mImage);
    }

    @Override
    public int getItemCount() {
        return mList.isEmpty() ? 0 : mList.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        private ImageView mImage;
        private TextView mName,mName1;
        public Holder(View itemView) {
            super(itemView);
            mImage = (ImageView) itemView.findViewById(R.id.mImage);
            mName = (TextView) itemView.findViewById(R.id.Text_Name);
            mName1 = (TextView) itemView.findViewById(R.id.Text_Name1);
        }
    }
}
