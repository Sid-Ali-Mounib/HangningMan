package com.example.hangningman;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class HighScoreListActivity extends AppCompatActivity {
    private ListView listView;
    private List<ScoreListData> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score_list);

        arrayList = PreferenceManagerClass.getInstance().readData(this);
        if (arrayList == null){
            arrayList = new ArrayList<>();
        }
        MyAdapter myAdapter = new MyAdapter(this,arrayList);


        listView = findViewById(R.id.highScoreCode);

        listView.setAdapter(myAdapter);
    }
}