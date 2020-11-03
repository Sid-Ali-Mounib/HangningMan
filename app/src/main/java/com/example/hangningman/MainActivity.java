package com.example.hangningman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button startButton ;
    Button helpButton ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.startButton);
        startButton.setOnClickListener(this);

        helpButton = findViewById(R.id.helpButton);
        helpButton.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        if(v == startButton){
            start();
        }else if(v == helpButton) {
            hjælp();
        }
    }


    private void start() {
        Intent Start = new Intent(this,GameScreen.class);
        startActivity(Start);
    }

    private void hjælp() {
        Intent Help = new Intent(this, HowToPlay.class);
        startActivity(Help);
    }
}