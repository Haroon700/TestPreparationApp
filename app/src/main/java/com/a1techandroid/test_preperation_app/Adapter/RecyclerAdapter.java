package com.a1techandroid.test_preperation_app.Adapter;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.a1techandroid.test_preperation_app.Common;
import com.a1techandroid.test_preperation_app.Fragments.HomeFragment;
import com.a1techandroid.test_preperation_app.Fragments.OptionDetailFragment;
import com.a1techandroid.test_preperation_app.LevelsActivity;
import com.a1techandroid.test_preperation_app.MainGridModel;
import com.a1techandroid.test_preperation_app.R;
import com.a1techandroid.test_preperation_app.VideoPlayer;
import com.a1techandroid.test_preperation_app.past_papers;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RecyclerAdapter  extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    Context context;
    private ArrayList<MainGridModel> fieldName;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView img;
        TextView name;

        public MyViewHolder(View view) {
            super(view);

            name = view.findViewById(R.id.txt);
            img = view.findViewById(R.id.img);
        }
    }


    public RecyclerAdapter(ArrayList<MainGridModel> fieldName, Context context) {
        this.fieldName = fieldName;
        this.context=context;
    }
    public void RefreshList(int id)
    {
        this.notifyDataSetChanged();
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_category, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder,final int position) {
        try {
            final MainGridModel dynamicFieldModel = fieldName.get(position);
            holder.name.setText(dynamicFieldModel.getName());
            holder.img.setImageDrawable(dynamicFieldModel.getImage());

            holder.img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int item = position;
                    if (position == 0){
                        Common.setForceType("army", context);
                        view.getContext().startActivity(new Intent(context, LevelsActivity.class));
                    }else if (position == 1){
                        Common.setForceType("navy", context);
                        view.getContext().startActivity(new Intent(context, LevelsActivity.class));
                    }else if (position == 2){
                        Common.setForceType("air", context);
                        view.getContext().startActivity(new Intent(context, LevelsActivity.class));
                    }else {
                        view.getContext().startActivity(new Intent(context, past_papers.class));
                    }

                }
            });

        }catch (Exception ex){}
    }

    @Override
    public int getItemCount() {
        return fieldName.size();
    }

    @Override
    public long getItemId(int position) {
            return super.getItemId(position);
    }
}
