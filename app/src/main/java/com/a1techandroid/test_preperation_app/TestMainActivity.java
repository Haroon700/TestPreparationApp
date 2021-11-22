package com.a1techandroid.test_preperation_app;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.a1techandroid.test_preperation_app.Adapter.GridAdapter;
import com.a1techandroid.test_preperation_app.Adapter.RecyclerAdapter;

import java.util.ArrayList;

public class TestMainActivity extends AppCompatActivity {
    private GridView gridLayout;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragmetn_home);
        initView();
        loadData();
//        setUpClick();
//        loadFragment();
    }

    private void initView(){
        gridLayout = findViewById(R.id.gridLayout);
        recyclerView = findViewById(R.id.recyclerview_grid);
    }

    private void loadData(){
        ArrayList<MainGridModel> list = new ArrayList<MainGridModel>();
        list.add(new MainGridModel(getApplicationContext().getResources().getDrawable(R.drawable.army), "Pak Army"));
        list.add(new MainGridModel(getApplicationContext().getResources().getDrawable(R.drawable.navy), "Pak Navy"));
        list.add(new MainGridModel(getApplicationContext().getResources().getDrawable(R.drawable.airforce), "Pak AirForce"));
        list.add(new MainGridModel(getApplicationContext().getResources().getDrawable(R.drawable.app_logo), "History Pak Army"));
        list.add(new MainGridModel(getApplicationContext().getResources().getDrawable(R.drawable.app_logo), "Past Papper"));
        GridAdapter gridAdapter = new GridAdapter(getApplicationContext(), list);
        gridLayout.setAdapter(gridAdapter);
        gridAdapter.notifyDataSetChanged();

        RecyclerAdapter dynamicFieldAdapter = new RecyclerAdapter(list, getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
//        recyclerView.addItemDecoration(new SpacesItemDecoration(spacingInPixels));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(dynamicFieldAdapter);
        dynamicFieldAdapter.notifyDataSetChanged();

//        StaggeredGridLayoutManager lm =
//                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(lm);
//        // recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
//        dashBoardAdapter = new DashBoardAdapter(new int[]{1,2,3,4,5,6,7}, getActivity(),dashBoardUpdates);
//        recyclerView.setAdapter(dashBoardAdapter);
    }
}
