package com.uisrael.veciapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class InformacionNegocio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_negocio);
    }

    public void regresar(View view){
        Intent regr = new Intent(this,MainActivity.class);
        startActivity(regr);
    }
}
