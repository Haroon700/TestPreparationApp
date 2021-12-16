package com.a1techandroid.test_preperation_app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.a1techandroid.test_preperation_app.Custom.Question;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class VideoPlayer extends AppCompatActivity {
    ListView listView;
    String id;
    String type;
    Uri uri;
    DatabaseReference myRef;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_player);
        listView = findViewById(R.id.exoPlayer);
        FirebaseUser currentUser = mAuth.getCurrentUser();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("History");

        // rtrdy

    }

    public void  test(){
        // this is for git test
    }

    public void testForGEt(){
        ArrayList<Question> questions = new ArrayList<>();
        questions.add(new Question(1, "The latest version of Hatf-5 is","Ghauri-1","Hataf","Abdali","Shaheen", "clear answer"));
        questions.add(new Question(2, "Zafar Ahmed Chaudhry was the first Chief of Air Staff of ","Pak Army","Air Force","Navy","None of them", "clear answer"));
        questions.add(new Question(3, "Frank Meseri was the first C-in-C of"," Pak Army","Air Force","Navy","None of them", "clear answer"));
        questions.add(new Question(4, "Urdu is a word of Turkish language, it means","IWth","Arms","Army","Literature", "clear answer"));
        questions.add(new Question(5, "The Supreme commander of Pakistan Armed Forces is?","Army Chief","Prime Minister","President","Governor", "clear answer"));
        questions.add(new Question(6, "Article 58(2b) of constitution 1973 is about","Power of President to dismiss Army Chief","Power of President to dissolve Provincial Assemblies","Power of President to dissolve National Assembly","Power of President to dissolve Senate", "clear answer"));
        questions.add(new Question(7, "How many U.S. states border the Pacific Ocean","Four","Three","Five","Seven", "clear answer"));
        questions.add(new Question(8, "Mojave Desert desert is located in","Afghanistan","India","Australia","USA", "clear answer"));
        questions.add(new Question(9, "The creator of the popular numbers puzzle Sudoku","Maki Kaji","Shinzo Teng","Mami Suzuki","Hiroko Akutsu", "clear answer"));
        questions.add(new Question(10, "What is the new name of the island of Madagascar","Haitti","Malagasy","Mozambique","Maputo", "clear answer"));

        questions.add(new Question(11, "","","","","", "clear answer"));
        questions.add(new Question(12, "","","","","", "clear answer"));
        questions.add(new Question(13, "","","","","", "clear answer"));
        questions.add(new Question(14, "","","","","", "clear answer"));
        questions.add(new Question(15, "","","","","", "clear answer"));
        questions.add(new Question(16, "","","","","", "clear answer"));
        questions.add(new Question(17, "","","","","", "clear answer"));
        questions.add(new Question(18, "","","","","", "clear answer"));
        questions.add(new Question(19, "","","","","", "clear answer"));
        questions.add(new Question(20, "","","","","", "clear answer"));


        questions.add(new Question(21, "","","","","", "clear answer"));
        questions.add(new Question(22, "","","","","", "clear answer"));
        questions.add(new Question(23, "","","","","", "clear answer"));
        questions.add(new Question(24, "","","","","", "clear answer"));
        questions.add(new Question(25, "","","","","", "clear answer"));
        questions.add(new Question(26, "","","","","", "clear answer"));
        questions.add(new Question(27, "","","","","", "clear answer"));
        questions.add(new Question(28, "","","","","", "clear answer"));
        questions.add(new Question(29, "","","","","", "clear answer"));
        questions.add(new Question(30, "","","","","", "clear answer"));


        questions.add(new Question(31, "","","","","", "clear answer"));
        questions.add(new Question(32, "","","","","", "clear answer"));
        questions.add(new Question(33, "","","","","", "clear answer"));
        questions.add(new Question(34, "","","","","", "clear answer"));
        questions.add(new Question(35, "","","","","", "clear answer"));
        questions.add(new Question(36, "","","","","", "clear answer"));
        questions.add(new Question(37, "","","","","", "clear answer"));
        questions.add(new Question(38, "","","","","", "clear answer"));
        questions.add(new Question(39, "","","","","", "clear answer"));
        questions.add(new Question(40, "","","","","", "clear answer"));

    }



}
