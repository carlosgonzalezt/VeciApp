package com.uisrael.veciapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.maps.MapView;

public class InformacionNegocio extends AppCompatActivity {

    private TextView ob_tv_titulo2;
    private Spinner ob_sp_negocio;
    private EditText ob_pt_nombrenegocio;
    private MapView ob_mapView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_negocio);

        ob_tv_titulo2 = (TextView) findViewById(R.id.tv_titulo2);
        ob_sp_negocio = (Spinner) findViewById(R.id.sp_negocio);
        ob_pt_nombrenegocio = (EditText) findViewById(R.id.pt_nombrenegocio);
        ob_mapView1 = (MapView) findViewById(R.id.mapView1);

        //Asignar los valores al spiner para seleccionar
        String[] opciones = {"Tienda", "Verduleria / Fruteria o similares", "Carniceria", "Papeleria", "Centro de computo", "Ferreteria", "Farmacia", "Costureria", "Otros"};
        ArrayAdapter<String> objeto_adapter = new ArrayAdapter<String>(this, R.layout.sppiner, opciones);
        ob_sp_negocio.setAdapter(objeto_adapter);
    }

    public void regresar(View view){
        Intent regr = new Intent(this,MainActivity.class);
        startActivity(regr);
    }
}
