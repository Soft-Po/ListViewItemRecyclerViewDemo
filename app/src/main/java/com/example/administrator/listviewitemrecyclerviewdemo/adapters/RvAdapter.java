package com.example.administrator.listviewitemrecyclerviewdemo.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.listviewitemrecyclerviewdemo.R;

/**
 * Created by Administrator on 2016/1/17.
 */
public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {

    private Context context;

    public RvAdapter(Context context) {
        Log.d("flag","------------------------->RvAdapter: 执行构造方法");
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.re_item,null);

        ViewHolder ret = new ViewHolder(view);
        return ret;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Log.d("flag","------------------->RvAdapter: "+position);
        holder.imageView.setImageResource(R.mipmap.ic_launcher);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.re_image);
        }
    }
}
