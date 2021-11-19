package com.a1techandroid.test_preperation_app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentTransaction;



import com.a1techandroid.test_preperation_app.Fragments.HistoryFragment;
import com.a1techandroid.test_preperation_app.Fragments.HomeFragment;
import com.a1techandroid.test_preperation_app.Fragments.SettingFragment;
import com.google.firebase.auth.FirebaseAuth;


import me.ibrahimsn.lib.OnItemSelectedListener;
import me.ibrahimsn.lib.SmoothBottomBar;

public class MainActivity extends AppCompatActivity {
    private SmoothBottomBar tabbar;
    private Button btnnn;
    CardView cvStartQuiz;
    CardView cvRule;
    CardView cvHistory;
    CardView cvEditPassword;
    CardView cvLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_new);
        init();
        setUpClick();
//        loadFragment();
    }

    private void init(){
         cvStartQuiz = findViewById(R.id.cvStartQuiz);
         cvRule = findViewById(R.id.cvRule);
         cvHistory = findViewById(R.id.cvHistory);
         cvEditPassword = findViewById(R.id.cvEditPassword);
         cvLogout = findViewById(R.id.cvLogout);
//        tabbar = findViewById(R.id.bottomBar);
//        btnnn = findViewById(R.id.btnnn);
        Log.i("test", "test");
    }

    private void setUpClick(){
        cvStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this,QuizOptionActivity.class));
            }
        });

        cvRule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this,RuleActivity.class));
            }
        });

        cvHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this,HistoryActivity.class));
            }
        });

        cvEditPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this,EditPasswordActivity.class));
            }
        });

        cvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getActivity(), LoginActivty.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
            }
        });
    }

    private  void loadFragment(){
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, new HomeFragment());
        transaction.addToBackStack(null);
        transaction.commit();
    }
}