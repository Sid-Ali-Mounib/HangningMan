package com.example.hangningman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Victory extends AppCompatActivity  implements View.OnClickListener  {
    Button spilIgen ;
    Button mainMenu ;
    Button gemScore;
    TextView amountOfTries;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_victory);

        Intent i = getIntent();
        amountOfTries=findViewById(R.id.amountOfTries);
        amountOfTries.setText("Antal Forsøg :"+i.getStringExtra("amountOfTries"));

        spilIgen= findViewById(R.id.spilIgen);
        spilIgen.setOnClickListener(this);

        mainMenu = findViewById(R.id.mainMenu2);
        mainMenu.setOnClickListener(this);






    }

    @Override
    public void onClick(View v) {
        if(v == mainMenu){
            gåTilMain();
        }else if(v == spilIgen) {
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