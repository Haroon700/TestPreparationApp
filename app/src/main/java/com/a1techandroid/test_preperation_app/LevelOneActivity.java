package com.a1techandroid.test_preperation_app;

import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.a1techandroid.test_preperation_app.Adapter.QuestionListAdapter;
import com.a1techandroid.test_preperation_app.Custom.Question;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class LevelOneActivity extends AppCompatActivity {
    ArrayList<Question> questions;
    String []answers;
    Toolbar toolbar;
    ScrollView scrollView;
    RecyclerView recyclerView;
    int type;
    DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_one_activity);
        type = getIntent().getIntExtra("level",0);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        String type1 = Common.getForceType(getApplicationContext());
        switch (type1){
            case "army":
                if (type == 0){
                    myRef = database.getReference("Question").child("Easy");
                    retrieveData();
                }else if (type == 1){
                    myRef = database.getReference("Question").child("Medium");
                    retrieveData();
                }else if(type == 2){
                    myRef = database.getReference("Question").child("Hard");
                    retrieveData();
                }
                break;
            case "navy":
                if (type == 0){
                    myRef = database.getReference("Question1").child("Navy").child("Easy");
                    retrieveData();
                }else if (type == 1){
                    myRef = database.getReference("Question1").child("Navy").child("Medium");
                    retrieveData();
                }else if(type == 2){
                    myRef = database.getReference("Question1").child("Navy").child("Hard");
                    retrieveData();
                }
                break;
            case "air":
                if (type == 0){
                    myRef = database.getReference("Question1").child("Air").child("Easy");
                    retrieveData();
                }else if (type == 1){
                    myRef = database.getReference("Question1").child("Air").child("Medium");
                    retrieveData();
                }else if(type == 2){
                    myRef = database.getReference("Question1").child("Air").child("Hard");
                    retrieveData();
                }
                break;
        }

        initView();
        loadData();
    }

    private void loadData() {

    }

    private void initView() {
        toolbar=findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.black));
//            answers=new String[questions.size()];
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.black));
//            scrollView = findViewById(R.id.discrete);
        recyclerView = findViewById(R.id.recycler);

    }

    public void retrieveData(){
        questions = new ArrayList<>();



        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dss: snapshot.getChildren()){
                    Question question = dss.getValue(Question.class);
                    questions.add(question);
                    final QuestionListAdapter questionAdapter=new QuestionListAdapter(LevelOneActivity.this,questions);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(questionAdapter);
                    questionAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(LevelOneActivity.this, "error", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
