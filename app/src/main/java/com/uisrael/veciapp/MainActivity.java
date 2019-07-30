package com.uisrael.veciapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
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
    private TextView ob_tv_dnegocio;
    private Spinner ob_sp_negocio;
    private EditText ob_pt_nomnegocio;
    private MapView ob_mp_mapa;
    private GoogleMap mapaReg;
    private int idactual=0,idactualPU=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Se asignan las variables a los objetos creados en el activity
        ob_pt_nombre =  findViewById(R.id.pt_nombre);
        ob_pt_apellido = findViewById(R.id.pt_apellido);
        ob_pt_correo =  findViewById(R.id.pt_correo);
        ob_pt_clave =  findViewById(R.id.pw_clave);
        ob_tv_dnegocio = findViewById(R.id.tv_dnegocion);
        ob_sp_negocio = findViewById(R.id.sp_negocio);
        ob_pt_nomnegocio = findViewById(R.id.pt_nombrenegocio);
        //mapaReg = findViewById(R.id.mapaRegistro);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapaRegistro);
        mapFragment.getMapAsync( this);
        buscar();
    }

    //METODO BUSCAR
    public void buscar(){

        VeciSQLiteOpenHelper admin = new VeciSQLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase BasedeDatos = admin.getWritableDatabase();//modo lectura escritura

        Cursor fila = BasedeDatos.rawQuery("select * from usuario", null); //deja aplicar select

        if(fila.moveToFirst()){
            idactual=fila.getInt(0);
            ob_pt_correo.setText(fila.getString(1)); //siempre el primero es 0
            ob_pt_clave.setText(fila.getString(3));
            BasedeDatos.close();
        }else{
            Toast.makeText(this, "NO EXISTE USUARIO ", Toast.LENGTH_SHORT).show();
            BasedeDatos.close();
        }
        VeciSQLiteOpenHelper admin2 = new VeciSQLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase BasedeDatos2 = admin2.getWritableDatabase();//modo lectura escritura
        Cursor filaPU = BasedeDatos2.rawQuery("select * from perfil_usuario", null); //deja aplicar select
        if(filaPU.moveToFirst()){
            idactualPU=filaPU.getInt(0);
            ob_pt_nombre.setText(filaPU.getString(2)); //siempre el primero es 0
            ob_pt_apellido.setText(filaPU.getString(3));
            BasedeDatos.close();
        }else{
            Toast.makeText(this, "NO EXISTE USUARIO ", Toast.LENGTH_SHORT).show();
            BasedeDatos.close();
        }
    }
    //METODO MODIFICAR
    public void modificar(View view){
        VeciSQLiteOpenHelper admin = new VeciSQLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase BasedeDatos = admin.getWritableDatabase();

        String correo= ob_pt_correo.getText().toString();
        String clave = ob_pt_clave.getText().toString();
        String nombre=ob_pt_nombre.getText().toString();
        String apellido=ob_pt_apellido.getText().toString();
        if(!correo.isEmpty() && !clave.isEmpty() && !nombre.isEmpty()&& !apellido.isEmpty()){

            ContentValues registro= new ContentValues();
            registro.put("correo", correo);
            registro.put("clave", clave);
            ContentValues registroPU= new ContentValues();
            registroPU.put("nombres",nombre);
            registroPU.put("apellidos",apellido);

            int cantidad = BasedeDatos.update("usuario",registro,"id_usuario="+idactual,null);
            int cantidadpu = BasedeDatos.update("perfil_usuario",registroPU,"id_usuario="+idactualPU,null);

            BasedeDatos.close();

            if(cantidad==1 && cantidadpu==1 ){
                Toast.makeText(this, "SE HA MODIFICADO CORRECTAMENTE", Toast.LENGTH_SHORT).show();
            }else{

                Toast.makeText(this, "NO EXISTE EL USUARIO", Toast.LENGTH_SHORT).show();
            }
        }else{

            Toast.makeText(this, "CAMPOS VACIOS", Toast.LENGTH_SHORT).show();
        }
    }

    //Seleccion de tipo de usuario
    public void S_U_Simple(View view){
        ob_tv_dnegocio.setVisibility(View.INVISIBLE);
        ob_sp_negocio.setVisibility(View.INVISIBLE);
        ob_pt_nomnegocio.setVisibility(View.INVISIBLE);
        //ob_mp_mapa.setVisibility(View.INVISIBLE);

    }

    public void S_U_Negocio(View view){
        ob_tv_dnegocio.setVisibility(View.VISIBLE);
        ob_sp_negocio.setVisibility(View.VISIBLE);
        ob_pt_nomnegocio.setVisibility(View.VISIBLE);
        //ob_mp_mapa.setVisibility(View.VISIBLE);
    }
    //https://www.movilzona.es/tutoriales/android/desarrollo/curso-de-desarrollo-android-tema-18-webview-que-es-y-como-funciona-la-vista-de-navegacion-web/

    //Muestra la posicion del usaurio
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapaReg = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng uisrael = new LatLng(-0.1972037, -78.4921892);
        mapaReg.addMarker(new MarkerOptions().position(uisrael).title("Quito"));
        mapaReg.moveCamera(CameraUpdateFactory.newLatLng(uisrael));
    }
}
