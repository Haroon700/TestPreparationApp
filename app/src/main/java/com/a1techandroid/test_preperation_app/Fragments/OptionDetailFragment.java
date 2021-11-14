package com.a1techandroid.test_preperation_app.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.a1techandroid.test_preperation_app.Adapter.LevelAdapter;
import com.a1techandroid.test_preperation_app.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class OptionDetailFragment extends Fragment {
    LevelAdapter levelAdapter;
    ListView listViewOption;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.option_detail_fragment, container, false);
        initView(view);
        loadData();
        return view;
    }



    @Override
    public void onResume() {
        super.onResume();
//        loadData();
    }

    private void loadData() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Level 1");
        list.add("Level 2");
        list.add("Level 3");
        list.add("Level 4");
        list.add("Level 5");
        levelAdapter= new LevelAdapter(getActivity(), list);
        listViewOption.setAdapter(levelAdapter);
        levelAdapter.notifyDataSetChanged();
    }

    private void initView(View view) {
        listViewOption= view.findViewById(R.id.listViewOption);
    }
}
