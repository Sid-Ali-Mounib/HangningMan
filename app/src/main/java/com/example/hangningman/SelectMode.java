package com.example.hangningman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectMode extends AppCompatActivity  implements View.OnClickListener   {


    Button startRandom;
    Button startCounty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_mode);






        startCounty = findViewById(R.id.pickCounty);
        startCounty.setOnClickListener(this);

        startRandom = findViewById(R.id.getWordFromDr);
        startRandom.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        if(v == startRandom){
            startGameWithRandomWord();
        }else if(v == startCounty) {
            countryPage();
        }

    }

    private void startGameWithRandomWord() {
        Intent Start = new Intent(this,GameScreen.class);
        startActivity(Start);
    }

    private void countryPage(){
        Intent listview= new Intent(this, ListViewActivity.class);
        startActivity(listview);
    }
}