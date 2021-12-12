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

import com.a1techandroid.test_preperation_app.Custom.Question;
import com.a1techandroid.test_preperation_app.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class QuestionListAdapter extends RecyclerView.Adapter<QuestionListAdapter.ViewHolder> {

    private int itemHeight;
    private ArrayList<Question> data;
    Context context;

    public QuestionListAdapter(Context context, ArrayList<Question> data) {
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




    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private View overlay;
        private TextView questionText, answer;


        ViewHolder(View itemView) {
            super(itemView);
            questionText =  itemView.findViewById(R.id.questionTextView);
            answer=itemView.findViewById(R.id.answer);

        }

        public void setOverlayColor(@ColorInt int color) {
            overlay.setBackgroundColor(color);
        }

    }
}
