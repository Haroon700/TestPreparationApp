package com.a1techandroid.test_preperation_app;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentTransaction;


import com.a1techandroid.test_preperation_app.Adapter.SliderAdapter;
import com.a1techandroid.test_preperation_app.Custom.SliderItem;
import com.a1techandroid.test_preperation_app.Fragments.HistoryFragment;
import com.a1techandroid.test_preperation_app.Fragments.HomeFragment;
import com.a1techandroid.test_preperation_app.Fragments.SettingFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;


import java.util.ArrayList;

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
        ArrayList<SliderItem> sliderItems = new ArrayList<>();
        sliderItems.add(new SliderItem("",getApplicationContext().getResources().getDrawable(R.drawable.issbbb)));
        sliderItems.add(new SliderItem("",getApplicationContext().getResources().getDrawable(R.drawable.issb2)));
        sliderItems.add(new SliderItem("",getApplicationContext().getResources().getDrawable(R.drawable.issb3)));
        sliderItems.add(new SliderItem("",getApplicationContext().getResources().getDrawable(R.drawable.issb4)));
        sliderItems.add(new SliderItem("Army",getApplicationContext().getResources().getDrawable(R.drawable.army)));
        sliderItems.add(new SliderItem("Navy",getApplicationContext().getResources().getDrawable(R.drawable.navy)));
        sliderItems.add(new SliderItem("AirForce",getApplicationContext().getResources().getDrawable(R.drawable.airforce)));
        SliderView sliderView = findViewById(R.id.imageSlider);
        sliderView.setSliderAdapter(new SliderAdapter(getApplicationContext(), sliderItems));
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.startAutoCycle();

//        sliderView.notifyAll();
        Log.i(  "test", "test");
    }

    private void setUpClick(){
        cvStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Start_Quiz_Activity.class));
            }
        });

        cvRule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,TestSection.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

            }
        });

        cvHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,VideoPlayer.class));
            }
        });

        cvEditPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), UpdatePasswordActivity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                           }
        });

        cvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopUp();
            }
        });
    }

    void showPopUp(){
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Are you sure?");
        builder.setMessage("Want to logout");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(), LoginActivty.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.show();

    }


}