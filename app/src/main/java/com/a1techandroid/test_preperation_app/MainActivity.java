package com.a1techandroid.test_preperation_app;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setUpClick();
        loadFragment();
    }

    private void init(){
        tabbar = findViewById(R.id.bottomBar);
        btnnn = findViewById(R.id.btnnn);
        Log.i("test", "test");
    }

    private void setUpClick(){
        tabbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
            }
        });



//        tabbar.setOnItemSelectedListener(new OnItemSelectedListener() {
//            @Override
//            public boolean onItemSelect(int i) {
//                Toast.makeText(MainActivity.this, "er"+i, Toast.LENGTH_SHORT).show();
//                return false;
//            }
//        });

        tabbar.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public boolean onItemSelect(int i) {
                if (i == 0){
                    final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frameLayout, new HomeFragment());
                    transaction.addToBackStack(null);
                    transaction.commit();
                }else if (i == 1){
                    final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frameLayout, new HistoryFragment());
                    transaction.addToBackStack(null);
                    transaction.commit();
                }else if (i == 2){
                    final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frameLayout, new SettingFragment());
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
                return false;
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