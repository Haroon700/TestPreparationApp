package com.a1techandroid.test_preperation_app.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.a1techandroid.test_preperation_app.Adapter.GridAdapter;
import com.a1techandroid.test_preperation_app.Adapter.RecyclerAdapter;
import com.a1techandroid.test_preperation_app.MainGridModel;
import com.a1techandroid.test_preperation_app.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private GridView gridLayout;
    private RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmetn_home, container, false);
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
        gridLayout = v.findViewById(R.id.gridLayout);
        recyclerView = v.findViewById(R.id.recyclerview_grid);
    }

    private void loadData(){
        ArrayList<MainGridModel> list = new ArrayList<MainGridModel>();
        list.add(new MainGridModel(getActivity().getResources().getDrawable(R.drawable.army), "Pak Army"));
        list.add(new MainGridModel(getActivity().getResources().getDrawable(R.drawable.navy), "Pak Navy"));
        list.add(new MainGridModel(getActivity().getResources().getDrawable(R.drawable.airforce), "Pak AirForce"));
        list.add(new MainGridModel(getActivity().getResources().getDrawable(R.drawable.app_logo), "History Pak Army"));
        list.add(new MainGridModel(getActivity().getResources().getDrawable(R.drawable.app_logo), "Past Papper"));
        GridAdapter gridAdapter = new GridAdapter(getActivity(), list);
        gridLayout.setAdapter(gridAdapter);
        gridAdapter.notifyDataSetChanged();

        RecyclerAdapter dynamicFieldAdapter = new RecyclerAdapter(list, getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
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
