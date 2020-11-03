package com.example.hangningman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public class GameScreen extends AppCompatActivity implements View.OnClickListener {
    Galgelogik logik;
    TextView antalForsøg;
    TextView bogstaverGættet;
    TextView ord;
    ImageView baggrund;
    EditText gætInput;
    Button indsendKnap;


    Executor bgThread = Executors.newSingleThreadExecutor(); // en baggrundstråd
    Handler uiThread = new Handler(Looper.getMainLooper());  // forgrundstråden


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        logik = new Galgelogik();
        logik.startNytSpil();
        hentOrdFraThread();
        initialisere();
        indsendKnap.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {

        logik.gætBogstav(gætInput.getText().toString());
        ord.setText(logik.getSynligtOrd());
        bogstaverGættet.setText("Gæt: " + logik.getBrugteBogstaver());
        billedeHåndtering(logik.getAntalForkerteBogstaver());
        antalForsøg.setText("Antal forsøg tilbage: "+Integer.toString(6 - logik.getAntalForkerteBogstaver()));
        gætInput.getText().clear();
        spilleUdfaldet();
    }


    private void initialisere() {
        baggrund = findViewById(R.id.imageView);
        gætInput = findViewById(R.id.gætInput);
        bogstaverGættet = findViewById(R.id.bogstaverGættet);
        antalForsøg = findViewById(R.id.antalForsøg);
        indsendKnap = findViewById(R.id.indsendGæt);
    }



    public void billedeHåndtering(int fejl) {
        switch(fejl){

            case 1:
                baggrund.setImageResource(R.drawable.forkert1);
                break;
            case 2:
                baggrund.setImageResource(R.drawable.forkert2);
                break;
            case 3:
                baggrund.setImageResource(R.drawable.forkert3);
                break;
            case 4:
                baggrund.setImageResource(R.drawable.forkert4);
                break;
            case 5:
                baggrund.setImageResource(R.drawable.forkert5);
                break;
            case 6:
                baggrund.setImageResource(R.drawable.forkert6);
                break;
        }
    }

    public void spilleUdfaldet(){

        if (logik.erSpilletVundet()) {
        vundet();
        }
        if (logik.erSpilletTabt()){
        tabt();
        }
    }


    public void vundet(){
        Intent victory = new Intent(this, Victory.class);
        victory.putExtra("amountOfTries", Integer.toString(logik.getAntalForkerteBogstaver()));
        startActivity(victory);
        finish();
    }



    public void tabt(){
        Intent defeat = new Intent(this, Defeat.class);
        defeat.putExtra("theWholeWord", logik.getOrdet());
        startActivity(defeat);
        finish();
    }



    public void hentOrdFraThread(){

        ord = findViewById(R.id.wordText);
        bgThread.execute(() -> {
            try {
                logik.hentOrdFraDr();
                uiThread.post(() -> {
                    ord.setText(logik.getSynligtOrd());
                });
            } catch (Exception e) {
                e.printStackTrace();
                uiThread.post(() -> {
                    ord.setText("Opstod en fejl under afhenting af ordet.");
                });
            }
        });
    }

}



