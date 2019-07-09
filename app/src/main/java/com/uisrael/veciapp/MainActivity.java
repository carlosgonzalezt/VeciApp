package com.uisrael.veciapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    private int idactual=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Se asignan las variables a los objetos creados en el activity
        ob_pt_nombre =  findViewById(R.id.pt_nombre);
        ob_pt_apellido = findViewById(R.id.pt_apellido);
        ob_pt_correo =  findViewById(R.id.pt_correo);
        ob_pt_clave =  findViewById(R.id.pw_clave);
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


    }
    //METODO MODIFICAR
    public void modificar(View view){
        VeciSQLiteOpenHelper admin = new VeciSQLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase BasedeDatos = admin.getWritableDatabase();

        String correo= ob_pt_correo.getText().toString();
        String clave = ob_pt_clave.getText().toString();

        if(!correo.isEmpty() && !clave.isEmpty() ){

            ContentValues registro= new ContentValues();
            registro.put("correo", correo);
            registro.put("clave", clave);

            int cantidad = BasedeDatos.update("usuario",registro,"id_usuario="+idactual,null);
            BasedeDatos.close();

            if(cantidad==1){
                Toast.makeText(this, "SE HA MODIFICADO CORRECTAMENTE", Toast.LENGTH_SHORT).show();
            }else{

                Toast.makeText(this, "NO EXISTE EL USUARIO", Toast.LENGTH_SHORT).show();
            }
        }else{

            Toast.makeText(this, "CAMPOS VACIOS", Toast.LENGTH_SHORT).show();
        }
    }


    //https://www.movilzona.es/tutoriales/android/desarrollo/curso-de-desarrollo-android-tema-18-webview-que-es-y-como-funciona-la-vista-de-navegacion-web/

}
