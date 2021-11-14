package com.a1techandroid.test_preperation_app.Adapter;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.a1techandroid.test_preperation_app.R;

import java.util.ArrayList;

public class MainCategoryAdapter extends BaseAdapter {

    public Context context;
    public  ArrayList<String> list;
    MainCategoryAdapter(Context context, ArrayList<String> list){
        this.context = context;
        this.list = list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder {
        public TextView text_cat;
        public ImageView imgage_cat;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
                convertView = mInflater.inflate(R.layout.main_category, null);
            viewHolder = new ViewHolder();

            viewHolder.text_cat = convertView.findViewById(R.id.txt);
            viewHolder.imgage_cat= convertView.findViewById(R.id.img);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final String events = list.get(position);
        return convertView;
    }
}
