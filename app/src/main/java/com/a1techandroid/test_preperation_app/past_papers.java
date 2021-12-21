package com.a1techandroid.test_preperation_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.a1techandroid.test_preperation_app.Adapter.LevelAdapter;
import com.a1techandroid.test_preperation_app.Adapter.player_list_adapter;

import java.util.ArrayList;

public class past_papers extends AppCompatActivity {
    ListView listView;
    player_list_adapter adapter;
    String type;
    LinearLayout army, air, navy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.past_papers);

        init();
//        loadData();
    }

    public void init(){
        army = findViewById(R.id.army);
        navy = findViewById(R.id.navy);
        air = findViewById(R.id.air);

        army.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), LevelsActivity.class));
            }
        });

        navy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), LevelsActivity.class));
            }
        });

        air.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), LevelsActivity.class));
            }
        });
    }


}