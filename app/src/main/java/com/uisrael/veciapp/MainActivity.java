package com.uisrael.veciapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.security.PrivateKey;

public class MainActivity extends AppCompatActivity {
    //Universidad Israel
    //Integrantes:
    //Carlos Gonzales
    //Jairo Pulgarin
    //9no C Sistemas

    //Variables d los objetos en el activity
    private EditText ob_pt_nombre;
    private EditText ob_pt_apellido;
    private EditText ob_pt_correo;
    private EditText ob_pt_usuario;
    private EditText ob_pt_clave;
    private EditText ob_pt_repclave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Se asignan las variables a los objetos creados en el activity
        ob_pt_nombre = (EditText) findViewById(R.id.pt_nombre);
        ob_pt_apellido = (EditText) findViewById(R.id.pt_apellido);
        ob_pt_correo = (EditText) findViewById(R.id.pt_correo);
        ob_pt_usuario = (EditText) findViewById(R.id.pt_usuario);
        ob_pt_clave = (EditText) findViewById(R.id.pw_clave);
        ob_pt_repclave = (EditText) findViewById(R.id.pw_repclave);

    }

    public void siguiente(View view){
        Intent sig = new Intent(this,InformacionNegocio.class);
        startActivity(sig);
    }
}
