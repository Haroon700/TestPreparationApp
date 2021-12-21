package com.a1techandroid.test_preperation_app.Fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.a1techandroid.test_preperation_app.Adapter.GridAdapter;
import com.a1techandroid.test_preperation_app.Adapter.RecyclerAdapter;
import com.a1techandroid.test_preperation_app.Adapter.SliderAdapter;
import com.a1techandroid.test_preperation_app.Custom.SliderItem;
import com.a1techandroid.test_preperation_app.LoginActivty;
import com.a1techandroid.test_preperation_app.MainActivity;
import com.a1techandroid.test_preperation_app.MainGridModel;
import com.a1techandroid.test_preperation_app.R;
import com.a1techandroid.test_preperation_app.Start_Quiz_Activity;
import com.a1techandroid.test_preperation_app.TestSection;
import com.a1techandroid.test_preperation_app.UpdatePasswordActivity;
import com.a1techandroid.test_preperation_app.VideoPlayer;
import com.google.firebase.auth.FirebaseAuth;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

import static com.facebook.FacebookSdk.getApplicationContext;

public class HomeFragment extends Fragment {
    private GridView gridLayout;
    private RecyclerView recyclerView;
    CardView cvStartQuiz;
    CardView cvRule;
    CardView cvHistory;
    CardView cvEditPassword;
    CardView cvLogout;
    CardView cvSchedule;
    NestedScrollView mScrollView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main_new, container, false);
        initView(view);
        loadData();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
//        loadData();
    }

    private void initView(View v){
        cvStartQuiz = v.findViewById(R.id.cvStartQuiz);
        cvRule = v.findViewById(R.id.cvRule);
        cvHistory = v.findViewById(R.id.cvHistory);
        cvEditPassword = v.findViewById(R.id.cvEditPassword);
        cvLogout = v.findViewById(R.id.cvLogout);
        cvSchedule = v.findViewById(R.id.cvSchedule);
        mScrollView = v.findViewById(R.id.scrollView);
//        mScrollView.setSmoothScrollingEnabled(true);
//        tabbar = findViewById(R.id.bottomBar);
//        btnnn = findViewById(R.id.btnnn);
        ArrayList<SliderItem> sliderItems = new ArrayList<>();
        sliderItems.add(new SliderItem("",getActivity().getResources().getDrawable(R.drawable.issbbb)));
        sliderItems.add(new SliderItem("",getActivity().getResources().getDrawable(R.drawable.issb2)));
        sliderItems.add(new SliderItem("",getActivity().getResources().getDrawable(R.drawable.issb3)));
        sliderItems.add(new SliderItem("",getActivity().getResources().getDrawable(R.drawable.issb4)));
        sliderItems.add(new SliderItem("Army",getActivity().getResources().getDrawable(R.drawable.army)));
        sliderItems.add(new SliderItem("Navy",getActivity().getResources().getDrawable(R.drawable.navy)));
        sliderItems.add(new SliderItem("AirForce",getActivity().getResources().getDrawable(R.drawable.airforce)));
        SliderView sliderView = v.findViewById(R.id.imageSlider);
        sliderView.setSliderAdapter(new SliderAdapter(getApplicationContext(), sliderItems));
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.startAutoCycle();
    }

    private void loadData(){
        cvStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Start_Quiz_Activity.class));
            }
        });

        cvRule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), TestSection.class));
                getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

            }
        });

        cvHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id, new HistoryFragment()).addToBackStack("history")
                        .commit();            }
        });

        cvEditPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), UpdatePasswordActivity.class));
                getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

        cvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopUp();
            }
        });

        cvSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), VideoPlayer.class);
                intent.putExtra("type","issb");
                startActivity(intent);
            }
        });
    }

    void showPopUp(){
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle("Are you sure?");
        builder.setMessage("Want to logout");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(), LoginActivty.class));
                getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
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
