package com.a1techandroid.test_preperation_app.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.a1techandroid.test_preperation_app.Custom.HistoryModel;
import com.a1techandroid.test_preperation_app.LevelOneActivity;
import com.a1techandroid.test_preperation_app.R;

import java.util.ArrayList;

public class HistoryAdapter extends BaseAdapter {
    Context context;
    ArrayList<HistoryModel> list;


    public HistoryAdapter(Context context, ArrayList<HistoryModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder {
        public TextView textName, textDate, attemp, textREsult, correct, wrong;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.history_adapter, null);
            viewHolder = new ViewHolder();

            viewHolder.textName = convertView.findViewById(R.id.userName);
            viewHolder.textDate = convertView.findViewById(R.id.date);
            viewHolder.correct = convertView.findViewById(R.id.correct);
            viewHolder.textREsult = convertView.findViewById(R.id.result);
            viewHolder.attemp = convertView.findViewById(R.id.attemp);
            viewHolder.wrong = convertView.findViewById(R.id.wrong);
//            convertView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(context, LevelOneActivity.class);
//                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    intent.putExtra("level",position);
//                    v.getContext().startActivity(intent);
//                }
//            });
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final HistoryModel events = list.get(position);
        viewHolder.textName.setText(events.getName());
        viewHolder.textDate.setText(events.getDate());
        viewHolder.attemp.setText(events.getLeve());
        viewHolder.textREsult.setText(events.getResult());
        viewHolder.wrong.setText(events.getWrong());
        viewHolder.correct.setText(events.getCorrect());
        return convertView;
    }
}
