package com.a1techandroid.test_preperation_app.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.a1techandroid.test_preperation_app.LevelsActivity;
import com.a1techandroid.test_preperation_app.MainGridModel;
import com.a1techandroid.test_preperation_app.R;
import com.a1techandroid.test_preperation_app.VideoPlayer;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class player_list_adapter extends BaseAdapter {

    ArrayList<Drawable> list = new ArrayList<>();
    Context context;
    String type;

    public player_list_adapter(ArrayList<Drawable> list, Context context, String type) {
        this.list = list;
        this.context = context;
        this.type = type;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
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
                if (type.equals("1")){
                    if (position == 0){
                        v.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(" https://www.youtube.com/watch?v=_dPsVeUvPBQ")));


                    }else if (position == 1){
                        v.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=X_Ecckjbnxo")));

                    }else if (position == 2){
                        v.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=9Jfx7uLVXgk")));

                    }else if (position == 3){
                        v.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=Crbnyl5jUGA")));

                    }else if (position == 4){
                        v.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=CDih_fJS81I")));

                    }else if (position == 5){
                        v.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=KCNp42O0ZnU")));
                    }else if (position == 6){
                        v.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=smQaiSuhU94")));

                    }else if (position == 7){
                        v.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=cPJOJTuyn_I")));

                    }else if (position == 8){
                        v.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=lvq3PzKzcnU")));

                    }else if (position == 9){
                        v.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=pu_5aWZX7wg")));

                    }
                }else {
                    if (position == 0){
                        v.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=2B1ViBg54as")));

                    }else if (position == 1){
                        v.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=ikiImqXZZQY")));

                    }else if (position == 2){
                        v.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=cRQkVfyw3Wc")));

                    }else if (position == 3){
                        v.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=_bgrpvILJns")));

                    }else if (position == 4){
                        v.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=YrBevIlq2-g")));

                    }else if (position == 5){
                        v.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=3jsnkt7Yy9M")));

                    }else if (position == 6){
                        v.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=6w4xvmw6jEk")));

                    }else if (position == 7){
                        v.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=MlrtfWm8OZ4")));

                    }else if (position == 8){
                        v.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=pKLrVJ32wbQ")));

                    }else if (position == 9){
                        v.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=4uh7nffSPz0")));

                    }
                }

//                Intent i = new Intent(context, VideoPlayer.class);
//                String pos = String.valueOf(position);
//                i.putExtra("id", pos);
//                i.putExtra("type", type);
//                v.getContext().startActivity(i);
            }
        });
        viewHolder.text_cat.setVisibility(View.GONE);
        viewHolder.image_cat.setImageDrawable(list.get(position));
        return convertView;
    }
}
