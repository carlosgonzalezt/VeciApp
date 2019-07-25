package com.uisrael.veciapp;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class navegador extends AppCompatActivity implements OnMapReadyCallback{

    private GoogleMap mapa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navegador);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.vecimap);
        mapFragment.getMapAsync( this);
    }

    public void BPerfil(View view){
        Intent sig = new Intent(this, MainActivity.class);
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
