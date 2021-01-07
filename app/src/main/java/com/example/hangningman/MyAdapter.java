package com.example.hangningman;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends ArrayAdapter<ScoreListData> {

    public MyAdapter(Context context, List<ScoreListData> scoreList) {
        super(context, 0, scoreList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ScoreListData data = getItem(position);
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter, parent, false);
        }
        TextView word = convertView.findViewById(R.id.word);
        TextView score = convertView.findViewById(R.id.score);

        word.setText(data.getWord());
        score.setText(data.getScore());

        return convertView;
    }
}
