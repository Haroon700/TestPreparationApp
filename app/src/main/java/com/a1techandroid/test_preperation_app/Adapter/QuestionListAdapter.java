package com.a1techandroid.test_preperation_app.Adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.recyclerview.widget.RecyclerView;

import com.a1techandroid.test_preperation_app.Custom.HistoryModel;
import com.a1techandroid.test_preperation_app.Custom.Question;
import com.a1techandroid.test_preperation_app.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class QuestionListAdapter extends RecyclerView.Adapter<QuestionListAdapter.ViewHolder> {

    private int itemHeight;
    private ArrayList<Question> data;
    Context context;
    DatabaseReference myRef;
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    public QuestionListAdapter(Context context, ArrayList<Question> data) {
        myRef = database.getReference("History");
        this.data = data;
        this.context = context;
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
        View v = inflater.inflate(R.layout.answer_adapter, parent, false);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                itemHeight);
        v.setLayoutParams(params);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.questionText.setText(data.get(position).getQuestion());
        holder.answer.setText(data.get(position).getAnswer());
        int index = position + 1;
        holder.number.setText(index+": ");

        if (position == data.size()-1){
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            Date date = new Date();
            DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(context);
            String dateStr =  dateFormat.format(date);
            HistoryModel model = new HistoryModel(user.getEmail(),dateStr,"Attempt","1");
            myRef.child(user.getEmail().replace(".","")).push().setValue(model);

        }


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private View overlay;
        private TextView questionText, answer, number;


        ViewHolder(View itemView) {
            super(itemView);
            questionText =  itemView.findViewById(R.id.questionTextView);
            answer=itemView.findViewById(R.id.answer);
            number=itemView.findViewById(R.id.number);

        }

        public void setOverlayColor(@ColorInt int color) {
            overlay.setBackgroundColor(color);
        }

    }
}
