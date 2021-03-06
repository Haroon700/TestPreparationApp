package com.a1techandroid.test_preperation_app.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.a1techandroid.test_preperation_app.Common;
import com.a1techandroid.test_preperation_app.LevelsActivity;
import com.a1techandroid.test_preperation_app.MainGridModel;
import com.a1techandroid.test_preperation_app.R;
import com.a1techandroid.test_preperation_app.VideoPlayer;
import com.a1techandroid.test_preperation_app.past_papers;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {
    public Context context;
    public ArrayList<MainGridModel> list;

    public GridAdapter(Context context, ArrayList<MainGridModel> list) {
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
        public ImageView image_cat;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.main_category, null);
            viewHolder = new ViewHolder();

            viewHolder.text_cat = convertView.findViewById(R.id.txt);
            viewHolder.image_cat = convertView.findViewById(R.id.img);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 0){
                    Common.setForceType("army", context);
                    v.getContext().startActivity(new Intent(context, LevelsActivity.class));

                }else if (position == 1){
                    Common.setForceType("navy", context);
                    v.getContext().startActivity(new Intent(context, LevelsActivity.class));

                }else if (position == 2){
                    Common.setForceType("air", context);
                    v.getContext().startActivity(new Intent(context, LevelsActivity.class));

                }else if (position == 3){
                    Intent intent = new Intent(context, VideoPlayer.class);
                    intent.putExtra("type","history");
                    v.getContext().startActivity(intent);

                }else {
                    v.getContext().startActivity(new Intent(context, past_papers.class));

                }
            }
        });

        final MainGridModel events = list.get(position);
        viewHolder.text_cat.setText(events.getName());
        viewHolder.image_cat.setImageDrawable(events.getImage());
        return convertView;
    }
}