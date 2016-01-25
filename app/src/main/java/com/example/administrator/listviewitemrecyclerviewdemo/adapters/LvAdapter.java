package com.example.administrator.listviewitemrecyclerviewdemo.adapters;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.listviewitemrecyclerviewdemo.R;
import com.example.administrator.listviewitemrecyclerviewdemo.widgets.CircleBitmapDisplayer;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2016/1/17.
 */
public class LvAdapter extends BaseAdapter {

    private Context context;

    private List<String> list;
    private final ImageLoader imageLoader;
    private final DisplayImageOptions options;

    private int cWidth = 120;

    private int hSpacing = 10;

    public LvAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
        imageLoader = ImageLoader.getInstance();

        options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .displayer(new CircleBitmapDisplayer())
                .build();
    }

    @Override
    public int getCount() {
        int ret = 0;
        if (list != null) {
            ret = list.size();
        }
        return ret;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View ret = null;

        if (convertView != null) {
            ret = convertView;
        }else {
            ret = LayoutInflater.from(context).inflate(R.layout.item,null);
        }

        ViewHolder holder = (ViewHolder) ret.getTag();

        if (holder == null) {
            holder = new ViewHolder();

            holder.item_image = ((ImageView) ret.findViewById(R.id.item_image));

            holder.item_recyclerView = ((RecyclerView) ret.findViewById(R.id.item_recyclerView));

            holder.item_gridView = ((GridView) ret.findViewById(R.id.item_gridView));

            ret.setTag(holder);
        }

        //加载图片
        imageLoader.displayImage(list.get(position),holder.item_image,options);

        //对recyclerView进行设置
        LinearLayoutManager layout = new LinearLayoutManager(context);

        layout.setOrientation(LinearLayoutManager.HORIZONTAL);

        holder.item_recyclerView.setLayoutManager(layout);

        RvAdapter adapter = new RvAdapter(context);
        holder.item_recyclerView.setAdapter(adapter);

//        GvAdapter adapter = new GvAdapter(context);
//
//        int count = adapter.getCount();
//
//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(count*(120+10), LinearLayout.LayoutParams.WRAP_CONTENT);
//
//        holder.item_gridView.setLayoutParams(params);
//
//        holder.item_gridView.setColumnWidth(cWidth);
//
//        holder.item_gridView.setHorizontalSpacing(hSpacing);
//
//        holder.item_gridView.setNumColumns(count);
//
//        holder.item_gridView.setStretchMode(GridView.NO_STRETCH);
//
//        holder.item_gridView.setAdapter(adapter);
//
//        final int p = position;
//        holder.item_gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Log.d("flag","------------------>点击了： "+ p+",   "+position);
//            }
//        });

        return ret;
    }

    private static class ViewHolder{
        private ImageView item_image;

        private RecyclerView item_recyclerView;

        private GridView item_gridView;
    }
}
