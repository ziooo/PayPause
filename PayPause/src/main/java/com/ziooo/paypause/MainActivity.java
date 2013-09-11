package com.ziooo.paypause;

import android.os.Bundle;
import android.app.Activity;
import android.os.SystemClock;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private EditText salaire;
    private Button start;
    private Button stop;
    private TextView resultat;

    private Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        salaire = (EditText) findViewById(R.id.salaire);
        start = (Button) findViewById(R.id.startChrono);
        stop = (Button) findViewById(R.id.stopChrono);
        chronometer = (Chronometer) findViewById(R.id.chronometer);
        resultat = (TextView) findViewById(R.id.resultat);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.stop();
                // Calcul par heure
                if (!"".equals(salaire.getText())) {

                    double heures = ((double)(SystemClock.elapsedRealtime() - chronometer.getBase())) / (1000*60*60);
                    double result = (Float.parseFloat(salaire.getText().toString()) * heures);
                    resultat.setText("Vous avez gagné " + result + " €");
//                    resultat.setText("Vous avez gagné " + heures + " €");
                }
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
