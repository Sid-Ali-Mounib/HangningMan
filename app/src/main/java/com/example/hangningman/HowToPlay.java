package com.example.hangningman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HowToPlay extends AppCompatActivity implements View.OnClickListener{

    Button backButton ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_play);

        backButton = findViewById(R.id.backbutton);
        backButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == backButton){
            homeScreen();

    }
}

    private void homeScreen() {
        Intent Home= new Intent(this,MainActivity.class);
        startActivity(Home);
    }
}