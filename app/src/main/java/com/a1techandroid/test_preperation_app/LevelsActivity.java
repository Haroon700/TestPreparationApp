package com.a1techandroid.test_preperation_app;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.a1techandroid.test_preperation_app.Adapter.LevelAdapter;

import java.util.ArrayList;

public class LevelsActivity extends AppCompatActivity {

    LevelAdapter levelAdapter;
    ListView listViewOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.option_detail_fragment);
        initView();
        loadData();
    }

    private void loadData() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Easy");
        list.add("Medium");
        list.add("Hard");
        levelAdapter= new LevelAdapter(getApplicationContext(), list);
        listViewOption.setAdapter(levelAdapter);
        levelAdapter.notifyDataSetChanged();
    }

    private void initView() {
        listViewOption= findViewById(R.id.listViewOption);
    }
}
