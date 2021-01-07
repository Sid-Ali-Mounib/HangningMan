package com.example.hangningman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;





public class ListViewActivity extends AppCompatActivity implements OnItemClickListener {
    ListView listView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        String[] ord = {"danmark", "norge", "sverige", "finland", "holland", "italien", "tyskland",
                "frankrig", "spanien", "portugal", "nepal", "indien", "kina", "japan", "thailand","el salvador","kirgisistan"};



        listView = findViewById(R.id.listcode);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, ord);
        listView.setOnItemClickListener(this);
        listView.setAdapter(adapter);



    }

    public void onItemClick(AdapterView<?> liste, View v, int position, long id) {
        String wordPicked = liste.getItemAtPosition(position).toString();
        Intent sendWord = new Intent(this,GameScreen.class);
        sendWord.putExtra("WordFromList",wordPicked);
        startActivity(sendWord);
    }
}