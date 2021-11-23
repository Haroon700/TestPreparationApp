package com.a1techandroid.test_preperation_app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.a1techandroid.test_preperation_app.Custom.NotificationService;
import com.a1techandroid.test_preperation_app.Custom.Question;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Start_Quiz_Activity extends AppCompatActivity {

        ArrayList<Question> questions;
        String []answers;
        Toolbar toolbar;
        ScrollView scrollView;
        RecyclerView recyclerView;
        LinearLayout indexLayout;
        GridView quesGrid;
        ArrayList<String> list;
        ArrayList<String> arrayList;
        int flag_controller = 1;
        long timer;// =((Test) getIntent().getExtras().get("Questions")).getTime()*60*1000;
        popGridAdapter popGrid;
        Button next,prev;
        TextView textView;
//        private DatabaseReference mDatabase;
        private FirebaseAuth auth;
        private String TESTNAME;
        private RadioGroup group;
        private int countPaused = 0;
        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
//            mDatabase = FirebaseDatabase.getInstance().getReference();
            auth= FirebaseAuth.getInstance();
            setContentView(R.layout.start_quiz_activity);
//            questions=((Test) getIntent().getExtras().get("Questions")).getQuestions();
//            TESTNAME = (String) getIntent().getExtras().get("TESTNAME");
            toolbar=findViewById(R.id.toolbar);
            toolbar.setTitleTextColor(getResources().getColor(android.R.color.black));
//            answers=new String[questions.size()];
            setSupportActionBar(toolbar);
            toolbar.setTitleTextColor(getResources().getColor(android.R.color.black));
//            scrollView = findViewById(R.id.discrete);
            recyclerView = findViewById(R.id.recycler);
            questions = new ArrayList<>();
            questions.add(new Question(1, "It takes 3 minutes to boil an egg. How much time will it take to boil 6 eggs together?","18","6","3","0", "clear answer"));
            questions.add(new Question(2, "Camera is to photographer as _____ Is to the soldier","Lens","Enemy","Photo","Gun", "clear answer"));
            questions.add(new Question(3, "Complete the series","6","5","12","10", "clear answer"));
            questions.add(new Question(4, "Which choice answers the following question? Islamabad is famous because:","It is a very clear city","Numerous foreigners live in it","The President lives in it","It is the capital of Pakistan", "clear answer"));
            questions.add(new Question(5, "","","","","", "clear answer"));
            answers=new String[questions.size()];

            final QuestionAdapter questionAdapter=new QuestionAdapter(questions);
            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
//        recyclerView.addItemDecoration(new SpacesItemDecoration(spacingInPixels));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(questionAdapter);
            questionAdapter.notifyDataSetChanged();
//            scrollView.(questionAdapter);
            prev=findViewById(R.id.prev);
            next=findViewById(R.id.next);
            prev.setText("Submit");
            next.setText("Next");
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    recyclerView.smoothScrollToPosition(questionAdapter.getCurrentItem() + 1);

                    if(recyclerView.getChildCount()==questions.size()-1){
                        showPopUp();
                    }else {
                        //setNextPrevButton(scrollView.getCurrentItem() + 1);
//                        recyclerView.smoothScrollToPosition(questionAdapter.getCurrentItem() + 1);
                    }
                }
            });

            prev=findViewById(R.id.prev);
//            prev.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if(scrollView.getCurrentItem()!=0){
//                        //setNextPrevButton(scrollView.getCurrentItem()-1);
//                        scrollView.smoothScrollToPosition(scrollView.getCurrentItem()-1);
//                    }
//                }
//            });

//            setNextPrevButton(scrollView.getCurrentItem());
            indexLayout=findViewById(R.id.index_layout);
            indexLayout.setAlpha(.5f);
            quesGrid=findViewById(R.id.pop_grid);
            popGrid=new popGridAdapter(Start_Quiz_Activity.this);
            quesGrid.setAdapter(popGrid);
            quesGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                    scrollView.smoothScrollToPosition(i+1);
                    slideUp(indexLayout);
                }
            });
//            scrollView.addScrollListener(new DiscreteScrollView.ScrollListener<RecyclerView.ViewHolder>() {
//                @Override
//                public void onScroll(float scrollPosition, int currentPosition, int newPosition, @Nullable RecyclerView.ViewHolder currentHolder, @Nullable RecyclerView.ViewHolder newCurrent) {
//                    setNextPrevButton(newPosition);
//                }
//            });

            timer=600*1000;
        }
        void showPopUp(){
            AlertDialog.Builder builder=new AlertDialog.Builder(Start_Quiz_Activity.this);
            builder.setMessage("Do you want to submit?");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    submit();
//                setAlertDialog(answerText);
                    dialogStart();
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

        /*submit result to database**/
        void submit(){
            flag_controller = 0;
            int score=0;
            list = new ArrayList<>();
            arrayList = new ArrayList<>();
            for(int i=0;i<answers.length;i++){
                if(answers[i]!=null&&answers[i].equals(questions.get(i).getAnswer())){
                    score++;
                }
                String temp = (answers[i]!=null) ? answers[i]+") ":"null) ";

                list.add("Your choice ("+
                        temp +
                        "Right choice is("+ questions.get(i).getAnswer()+")");
                arrayList.add(questions.get(i).getQuestion());
            }

            try {
//                mDatabase.child("Results").child(((Test) getIntent().getExtras().get("Questions")).getName())
//                        .child(auth.getUid()).setValue(score);
            }catch (Exception e){
                Log.e("Result Update Failed " ,e.getMessage());
            }
        }

        void dialogStart() {

            final AlertDialog.Builder builderSingle = new AlertDialog.Builder(Start_Quiz_Activity.this);
            builderSingle.setIcon(R.mipmap.ic_launcher_round);
            builderSingle.setTitle(TESTNAME+" Answers");
            final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>
                    (Start_Quiz_Activity.this, android.R.layout.select_dialog_singlechoice);
            final ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<>
                    (Start_Quiz_Activity.this,android.R.layout.select_dialog_singlechoice);

            for(String y : arrayList) {
                arrayAdapter1.add(y);
            }
            for(String x: list){
                arrayAdapter.add(x);
            }

            builderSingle.setCancelable(false);
            builderSingle.setNegativeButton("Done!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                    dialog.dismiss();
                }
            });

            builderSingle.setAdapter(arrayAdapter1, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String strName = arrayAdapter.getItem(which);
                    AlertDialog.Builder builderInner = new AlertDialog.Builder(Start_Quiz_Activity.this);
                    builderInner.setMessage(strName);
                    builderInner.setCancelable(false);
                    builderInner.setTitle("Your Selected Question Answer is");
                    builderInner.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog,int which) {
//                        finish();
                            builderSingle.show();
//                        dialog.dismiss();
                        }
                    });
                    builderInner.show();
                }
            });
            builderSingle.show();

        }

        @Override
        protected void onPause() {
            super.onPause();
            if(countPaused<=2 && countPaused >=0 && flag_controller == 1)
                startService(new Intent(Start_Quiz_Activity.this,
                        NotificationService.class));
            countPaused++;
        }

        @Override
        protected void onResume() {
            super.onResume();
            stopService(new Intent(Start_Quiz_Activity.this, NotificationService.class));
            if(countPaused>2) {
                Toast.makeText(this, "Thank you! Your response has been submitted.", Toast.LENGTH_SHORT).show();

                countPaused = -1000;
                submit();
                dialogStart();
            }
        }

        @Override
        protected void onRestart() {
            super.onRestart();
            stopService(new Intent(Start_Quiz_Activity.this, NotificationService.class));
        }

        void setNextPrevButton(int pos){
            if(pos==0){
//            prev.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
                prev.setText("Submit");
                next.setText("Next");
            }else {
//            prev.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                prev.setText("Previous");
            }
            if(pos==questions.size()-1){
                next.setText("Submit");
//            next.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
            }else {
                next.setText("Next");
//            next.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
            }
        }

        @Override
        public void onBackPressed() {
            showPopUp();
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {

            super.onCreateOptionsMenu(menu);

            getMenuInflater().inflate(R.menu.attempt_menu, menu);
            final MenuItem counter = menu.findItem(R.id.counter);

            new CountDownTimer(timer, 1000) {
                public void onTick(long millisUntilFinished) {
                    long millis = millisUntilFinished;
                    long hr= TimeUnit.MILLISECONDS.toHours(millis),mn=(TimeUnit.MILLISECONDS.toMinutes(millis)-
                            TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis))),
                            sc=TimeUnit.MILLISECONDS.toSeconds(millis) -
                                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis));


                    String  hms =format(hr)+":"+format(mn)+":"+format(sc) ;
                    counter.setTitle(hms);
                    timer = millis;
                }
                String format(long n){
                    if(n<10)
                        return "0"+n;
                    else return ""+n;
                }

                public void onFinish() {
                    submit();
                    dialogStart();
                }
            }.start();

            return  true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();
            if(id==R.id.submit){
                showPopUp();

                return true;
            }else if(id==R.id.info){
                togglePopUp();
            }
            return super.onOptionsItemSelected(item);
        }


        void togglePopUp(){
            if(indexLayout.getVisibility()==View.GONE){
                slideDown(indexLayout);
            }else slideUp(indexLayout);
        }

        class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder> {

            private int itemHeight;
            private ArrayList<Question> data;

            QuestionAdapter(ArrayList<Question> data) {
                this.data = data;
                this.notifyDataSetChanged();
            }



            @Override
            public void onAttachedToRecyclerView(RecyclerView recyclerView) {
                super.onAttachedToRecyclerView(recyclerView);
                Activity context = (Activity) recyclerView.getContext();
                Point windowDimensions = new Point();
                context.getWindowManager().getDefaultDisplay().getSize(windowDimensions);
                itemHeight = Math.round(windowDimensions.y * 0.6f);
            }

            @NotNull
            @Override
            public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                View v = inflater.inflate(R.layout.frag_test, parent, false);
                ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        itemHeight);
                v.setLayoutParams(params);
                return new ViewHolder(v);
            }

            @Override
            public void onBindViewHolder(final ViewHolder holder, final int position) {
                holder.questionText.setText(data.get(position).getQuestion());
                holder.r1.setText(data.get(position).getOpt_A());
                holder.r2.setText(data.get(position).getOpt_B());
                holder.r3.setText(data.get(position).getOpt_C());
                holder.r4.setText(data.get(position).getOpt_D());
                holder.r5.setText("Clear Selected");

                holder.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        final int selectedId = holder.radioGroup.getCheckedRadioButtonId();
                        if(i==R.id.radioButton){
                            answers[position]="A";
                        }  else if(i==R.id.radioButton2){
                            answers[position]="B";
                        }else if(i==R.id.radioButton3){
                            answers[position]="C";
                        }else if(i==R.id.radioButton4){
                            answers[position]="D";
                        }
                        else if(i==R.id.radioButton5) {
                            holder.radioGroup.clearCheck();
                            answers[position] = null;
                        }
                        popGrid.notifyDataSetChanged();
                    }
                });

                holder.next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        recyclerView.getLayoutManager().smoothScrollToPosition(recyclerView, null, position+1);
                    }
                });

                holder.prev.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (data.size() == position){

                        }else {
                            recyclerView.getLayoutManager().smoothScrollToPosition(recyclerView, null, position-1);
                        }
                    }
                });


                if(answers[position]==null) {
                    holder.radioGroup.clearCheck();
                }else if(answers[position].equals("A")) {
                    holder.radioGroup.check(R.id.radioButton);
                }else if(answers[position].equals("B")) {
                    holder.radioGroup.check(R.id.radioButton2);
                }else if(answers[position].equals("C")) {
                    holder.radioGroup.check(R.id.radioButton3);
                }else if(answers[position].equals("D")) {
                    holder.radioGroup.check(R.id.radioButton4);
                }
            }

            @Override
            public int getItemCount() {
                return data.size();
            }

            class ViewHolder extends RecyclerView.ViewHolder {

                private View overlay;
                private  TextView questionText;
                private RadioGroup radioGroup;
                private RadioButton r1,r2,r3,r4,r5;
                Button next, prev;

                ViewHolder(View itemView) {
                    super(itemView);
                    questionText =  itemView.findViewById(R.id.questionTextView);
                    radioGroup=itemView.findViewById(R.id.radioGroup);
                    r1=itemView.findViewById(R.id.radioButton);
                    r2=itemView.findViewById(R.id.radioButton2);
                    r3=itemView.findViewById(R.id.radioButton3);
                    r4=itemView.findViewById(R.id.radioButton4);
                    r5 = itemView.findViewById(R.id.radioButton5);
                    next = itemView.findViewById(R.id.next);
                    next.setText("Next");
                    prev = itemView.findViewById(R.id.prev);
                    prev.setText("Previous");
                }

                public void setOverlayColor(@ColorInt int color) {
                    overlay.setBackgroundColor(color);
                }

                public void unCheck() {

                    int selectedId = radioGroup.getCheckedRadioButtonId();
                    if(radioGroup.getCheckedRadioButtonId() == R.id.radioButton) {
                        r1.setChecked(true);
                    }
                    else if(radioGroup.getCheckedRadioButtonId() == R.id.radioButton2) {
                        r2.setChecked(true);
                    }
                    else if(radioGroup.getCheckedRadioButtonId() == R.id.radioButton3) {
                        r3.setChecked(true);
                    }
                    else if(radioGroup.getCheckedRadioButtonId() == R.id.radioButton4) {
                        r4.setChecked(true);
                    }
                    else if(radioGroup.getCheckedRadioButtonId() ==R.id.radioButton5) {
                        r5.setChecked(true);
                    }
                }
            }
        }

        class popGridAdapter extends BaseAdapter {
            Context mContext;
            popGridAdapter(Context context){
                mContext=context;
            }
            @Override
            public Object getItem(int i) {
                return null;
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public int getCount() {
                return 10;
            }

            @Override
            public View getView(final int i, View view, ViewGroup viewGroup) {
                View convertView;
                if(view==null){
                    convertView=new Button(mContext);
                }else convertView=view;
                if(answers[i]==null)
                    (convertView).setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
                else
                    (convertView).setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));

                ((Button)convertView).setText(""+(i+1));

                (convertView).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //setNextPrevButton(i);
//                        scrollView.smoothScrollToPosition(i);
                    }
                });
                return convertView;
            }
        }

        public void slideUp(View view){
            TranslateAnimation animate = new TranslateAnimation(
                    0,                 // fromXDelta
                    0,                 // toXDelta
                    0,  // fromYDelta
                    -view.getHeight());                // toYDelta
            animate.setDuration(500);
            view.startAnimation(animate);
            view.setVisibility(View.GONE);
        }

        // slide the view from its current position to below itself
        public void slideDown(View view){
            view.setVisibility(View.VISIBLE);
            TranslateAnimation animate = new TranslateAnimation(
                    0,                 // fromXDelta
                    0,                 // toXDelta
                    -view.getHeight(),                 // fromYDelta
                    0); // toYDelta
            animate.setDuration(500);
            view.startAnimation(animate);

        }

        @Override
        protected void onDestroy() {
            submit();
            super.onDestroy();
        }
    }
