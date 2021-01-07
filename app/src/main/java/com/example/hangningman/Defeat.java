package com.example.hangningman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Defeat extends AppCompatActivity implements View.OnClickListener{
    Button prøvIgen ;
    Button mainMenu ;
    TextView theWholeWord;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defeat);



        Intent i = getIntent();
        theWholeWord=findViewById(R.id.theWholeWord);
        theWholeWord.setText("Ordet var: "+i.getStringExtra("theWholeWord"));


        prøvIgen = findViewById(R.id.prøvIgen);
        prøvIgen.setOnClickListener(this);

        mainMenu = findViewById(R.id.mainMenu2);
        mainMenu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mainMenu){
            gåTilMain();
        }else if(v == prøvIgen) {
            startSpilIgen();
        }
    }
    private void gåTilMain() {
        Intent Main = new Intent(this,MainActivity.class);
        startActivity(Main);
    }

    private void startSpilIgen() {
        Intent gåTilSpil = new Intent(this, GameScreen.class);
        startActivity(gåTilSpil);
    }
}