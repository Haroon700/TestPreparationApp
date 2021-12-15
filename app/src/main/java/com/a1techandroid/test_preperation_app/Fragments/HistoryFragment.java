package com.a1techandroid.test_preperation_app.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.a1techandroid.test_preperation_app.Adapter.HistoryAdapter;
import com.a1techandroid.test_preperation_app.Adapter.QuestionListAdapter;
import com.a1techandroid.test_preperation_app.Custom.HistoryModel;
import com.a1techandroid.test_preperation_app.Custom.Question;
import com.a1techandroid.test_preperation_app.LevelOneActivity;
import com.a1techandroid.test_preperation_app.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HistoryFragment extends Fragment {

    DatabaseReference myRef;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    FirebaseUser user;
    ArrayList<HistoryModel> list = new ArrayList<>();
    ListView listView;
    TextView label;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        user = auth.getCurrentUser();
        myRef = database.getReference("History").child(user.getEmail().replace(".",""));

        initView(view);
        return view;
    }

    private void initView(View v){
        listView = v.findViewById(R.id.listView);
        label = v.findViewById(R.id.label);
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dss: snapshot.getChildren()){
                    String key = dss.getKey();
                    HistoryModel question = dss.getValue(HistoryModel.class);
                    list.add(question);
                    if (list.size() > 1){
                        label.setVisibility(View.GONE);
                    }
                    final HistoryAdapter questionAdapter=new HistoryAdapter(getActivity(),list);
                    listView.setAdapter(questionAdapter);
                    questionAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(), "error", Toast.LENGTH_SHORT).show();
            }
        });

    }


}

