package com.a1techandroid.test_preperation_app;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.a1techandroid.test_preperation_app.Adapter.GridAdapter;
import com.a1techandroid.test_preperation_app.Adapter.RecyclerAdapter;
import com.a1techandroid.test_preperation_app.Custom.Question;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import es.dmoral.toasty.Toasty;

public class TestMainActivity extends AppCompatActivity {
    private GridView gridLayout;
    private RecyclerView recyclerView;
    FirebaseDatabase database;
    DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragmetn_home);
         database = FirebaseDatabase.getInstance();
         myRef = database.getReference("Question").child("Easy");
        initView();
        loadData();
//        setUpClick();
//        loadFragment();
//        saveData();
//        retrieveData();
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
//        list.add(new MainGridModel(getApplicationContext().getResources().getDrawable(R.drawable.app_logo), "History Pak Army"));
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

    public void saveData(){
       ArrayList<Question> questions = new ArrayList<>();
        questions.add(new Question(1, "It takes 3 minutes to boil an egg. How much time will it take to boil 6 eggs together?","18","6","3","0", "clear answer"));
        questions.add(new Question(2, "Camera is to photographer as _____ Is to the soldier","Lens","Enemy","Photo","Gun", "clear answer"));
        questions.add(new Question(3, "Complete the series","6","5","12","10", "clear answer"));
        questions.add(new Question(4, "Which choice answers the following question? Islamabad is famous because:","It is a very clear city","Numerous foreigners live in it","The President lives in it","It is the capital of Pakistan", "clear answer"));
        questions.add(new Question(5, "Which country of the South America is known as ‘Granary of Europe’","Chile","Argentina","Brazil","Peru", "clear answer"));
        questions.add(new Question(6, "Which Asian country is home to the most nuclear power plants","China","South Korea","Taiwan","None of these", "clear answer"));
        questions.add(new Question(7, "How many U.S. states border the Pacific Ocean","Four","Three","Five","Seven", "clear answer"));
        questions.add(new Question(8, "Mojave Desert desert is located in","Afghanistan","India","Australia","USA", "clear answer"));
        questions.add(new Question(9, "The creator of the popular numbers puzzle Sudoku","Maki Kaji","Shinzo Teng","Mami Suzuki","Hiroko Akutsu", "clear answer"));
        questions.add(new Question(10, "What is the new name of the island of Madagascar","Haitti","Malagasy","Mozambique","Maputo", "clear answer"));
//        myRef.setValue("hello");
        myRef.setValue(questions).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(@NonNull Void aVoid) {
                Toasty.success(getApplicationContext(), "Saved");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toasty.error(getApplicationContext(), "failed");
            }
        });
    }

//    public void retrieveData(){
//        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                for (DataSnapshot dss: snapshot.getChildren()){
//                    Question question = dss.getValue(Question.class);
//                    Toast.makeText(TestMainActivity.this, ""+question.getId()+question.getOpt_A(), Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(TestMainActivity.this, "error", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
}
