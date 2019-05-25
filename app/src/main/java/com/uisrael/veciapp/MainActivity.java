package com.uisrael.veciapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    //Universidad Israel
    //Integrantes:
    //Carlos Gonzales
    //Jairo Pulgarin
    //9no C Sistemas

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void siguiente(View view){
        Intent sig = new Intent(this,InformacionNegocio.class);
        startActivity(sig);
    }
}
