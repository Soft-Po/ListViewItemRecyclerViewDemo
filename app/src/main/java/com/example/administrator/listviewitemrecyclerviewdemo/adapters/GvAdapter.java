package com.example.administrator.listviewitemrecyclerviewdemo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.administrator.listviewitemrecyclerviewdemo.R;

/**
 * Created by Administrator on 2016/1/17.
 */
public class GvAdapter extends BaseAdapter {
    public GvAdapter(Context context) {
        this.context = context;
    }

    private Context context;


    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
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
            ret = LayoutInflater.from(context).inflate(R.layout.gv_item,null);
        }

        ViewHolder holder = (ViewHolder) ret.getTag();

        if (holder == null) {
            holder = new ViewHolder();

            holder.gv_image = ((ImageView) ret.findViewById(R.id.gv_image));

            ret.setTag(holder);
        }

        holder.gv_image.setImageResource(R.mipmap.ic_launcher);
        return ret;
    }

    private static class ViewHolder{
        private ImageView gv_image;
    }

}
