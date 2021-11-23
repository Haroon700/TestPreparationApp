package com.a1techandroid.test_preperation_app;

import android.os.Bundle;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.a1techandroid.test_preperation_app.Custom.Question;

import java.util.ArrayList;

public class LevelOneActivity extends AppCompatActivity {
    ArrayList<Question> questions;
    String []answers;
    Toolbar toolbar;
    ScrollView scrollView;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_one_activity);
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
        questions = new ArrayList<>();
        questions.add(new Question(1, "GHQ Stands for:","General Head Quarters","General High Quarters","General High Quartermaster","None of them", "clear answer"));
        questions.add(new Question(2, "KRL Stands for:","Khan Research Laboratories","Kahuta Research Laboratories","Karachi Research Laboratories","None of them", "clear answer"));
        questions.add(new Question(3, "Who was the first C-in-C of Pakistan Navy?","Gefford James"," R.L Archy","Frank Meseri","None of them", "clear answer"));
        questions.add(new Question(4, "Frank Meseri was the first C-in-C of","Pak Army","Air Force","Navy","None of them", "clear answer"));
        questions.add(new Question(5, "Paery Cane was the first C-in-C of’","Pakistan Air Force","Armed Forces","Navy","None of them", "clear answer"));
        questions.add(new Question(6, "The first Chief of Staff of Pak Army was","General Takka Khan","General Ziaul Haq","General Sharif","General Ayub Khan", "clear answer"));
        questions.add(new Question(7, "Zafar Ahmed Chaudhry was the first Chief of Air Staff of "," Pak Army","Air Force","Navy","None of them", "clear answer"));
        questions.add(new Question(8, "Defence day is observed on","Afghanistan","6th September","11th September","7th September", "None of them"));
        questions.add(new Question(9, "The headquarters of Air Force is located in","Islamabad","Rawalpindi","Peshawar","Karachi", "clear answer"));
        questions.add(new Question(10, "The highest official rank of Air Force is ","Air Marshal","Supreme Marshal","Air Chief Marshal","Chief of Air Force", "clear answer"));


        final Start_Quiz_Activity.QuestionAdapter questionAdapter=new Start_Quiz_Activity.QuestionAdapter(questions);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
//        recyclerView.addItemDecoration(new SpacesItemDecoration(spacingInPixels));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(questionAdapter);
        questionAdapter.notifyDataSetChanged();
    }
}
