package com.a1techandroid.test_preperation_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class TestSection extends AppCompatActivity {
    ListView listView;
    CardView test, video, fitness;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_section);
        init();
        loadData();
    }

    private void loadData() {

    }

    public void init(){
        test=findViewById(R.id.cvStartQuiz);
        video=findViewById(R.id.cvStartQuiz1);
        fitness=findViewById(R.id.cvStartQuiz2);

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TestSection.this,TestMainActivity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TestSection.this,VideoListView.class);
                i.putExtra("type", "1");
                startActivity(i);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

        fitness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TestSection.this,VideoListView.class);
                i.putExtra("type", "2");
                startActivity(i);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

    }
}
