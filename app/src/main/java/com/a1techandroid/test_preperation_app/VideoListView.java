package com.a1techandroid.test_preperation_app;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.a1techandroid.test_preperation_app.Adapter.player_list_adapter;

import java.util.ArrayList;

public class VideoListView  extends AppCompatActivity {
    ListView listView;
    player_list_adapter adapter;
    String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videolist);
        Intent intent = getIntent();
        type = intent.getStringExtra("type");
        init();
        loadData();
    }

    public void init(){
    listView=findViewById(R.id.listView);
    }

    public void loadData(){

        if (type.equals("1")){
            ArrayList<Drawable> list = new ArrayList<>();
            list.add(getResources().getDrawable(R.drawable.th1));
            list.add(getResources().getDrawable(R.drawable.thumb2));
            list.add(getResources().getDrawable(R.drawable.th3));
            list.add(getResources().getDrawable(R.drawable.th4));
            list.add(getResources().getDrawable(R.drawable.th5));
            list.add(getResources().getDrawable(R.drawable.th6));
            list.add(getResources().getDrawable(R.drawable.th7));
            list.add(getResources().getDrawable(R.drawable.th8));
            list.add(getResources().getDrawable(R.drawable.th9));
            list.add(getResources().getDrawable(R.drawable.th10));


            adapter = new player_list_adapter(list, VideoListView.this, type);
            listView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }else {
            ArrayList<Drawable> list = new ArrayList<>();
            list.add(getResources().getDrawable(R.drawable.th11));
            list.add(getResources().getDrawable(R.drawable.th12));
            list.add(getResources().getDrawable(R.drawable.th13));
            list.add(getResources().getDrawable(R.drawable.th14));
            list.add(getResources().getDrawable(R.drawable.th15));
            list.add(getResources().getDrawable(R.drawable.th16));
            list.add(getResources().getDrawable(R.drawable.th17));



            adapter = new player_list_adapter(list, VideoListView.this, type);
            listView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }

    }
}