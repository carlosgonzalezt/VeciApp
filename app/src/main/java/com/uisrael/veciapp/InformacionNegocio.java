package com.uisrael.veciapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class InformacionNegocio extends AppCompatActivity implements OnMapReadyCallback {

    private TextView ob_tv_titulo2;
    private Spinner ob_sp_negocio;
    private EditText ob_pt_nombrenegocio;
    private MapView ob_mapView1;

    private String v_nombre = "";
    private String v_apellido = "";
    private String v_correo = "";
    private String v_usuario = "";
    private String v_clave = "";

    private GoogleMap mapa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_negocio);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.vecimap);
        mapFragment.getMapAsync( this);

        ob_tv_titulo2 = findViewById(R.id.tv_titulo2);
        ob_sp_negocio = findViewById(R.id.sp_negocio);
        ob_pt_nombrenegocio = findViewById(R.id.pt_nombrenegocio);
        ob_mapView1 = findViewById(R.id.mapView1);

        //Asignar los valores al spiner para seleccionar
        String[] opciones = {"Tienda", "Verduleria / Fruteria o similares", "Carniceria", "Papeleria", "Centro de computo", "Ferreteria", "Farmacia", "Costureria", "Otros"};
        ArrayAdapter<String> objeto_adapter = new ArrayAdapter<String>(this, R.layout.sppiner, opciones);
        ob_sp_negocio.setAdapter(objeto_adapter);

        v_nombre = getIntent().getStringExtra("main_nombre");
        v_apellido = getIntent().getStringExtra("main_apellido");
        v_correo = getIntent().getStringExtra("main_correo");
        v_usuario = getIntent().getStringExtra("main_usuario");
        v_clave = getIntent().getStringExtra("main_clave");

        ob_tv_titulo2.setText(v_usuario);


    }



    //metodo para guardar
    public void Guardar(View view){

        try{
            //metodo para escribir en un nuevo archivo
            OutputStreamWriter archivo=  new OutputStreamWriter(openFileOutput("locales.txt", Activity.MODE_PRIVATE));
            archivo.write(v_nombre+"\n"+v_apellido+"\n"+v_correo+"\n"+v_usuario+"\n"+v_clave);
            archivo.flush();
            archivo.close();

        }catch (IOException e){

        }

        Toast.makeText(this, "REGISTRO GUARDADOS CORRECTAMENTE", Toast.LENGTH_SHORT).show();
        Intent sig = new Intent(this,navegador.class);
        startActivity(sig);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapa = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng uisrael = new LatLng(-0.1972037, -78.4921892);
        mapa.addMarker(new MarkerOptions().position(uisrael).title("Quito"));
        mapa.moveCamera(CameraUpdateFactory.newLatLng(uisrael));
    }

}
