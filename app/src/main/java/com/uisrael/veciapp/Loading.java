package com.uisrael.veciapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Loading extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
    }

    public void cargar(View view){

            VeciSQLiteOpenHelper admin = new VeciSQLiteOpenHelper(this,"administracion",null,1);
            SQLiteDatabase BasedeDatos = admin.getWritableDatabase();//modo lectura escritura

            Cursor fila = BasedeDatos.rawQuery("select descripcion,precio from articulos ", null); //deja aplicar select

            if(fila.moveToFirst()){
                BasedeDatos.close();
                Intent sig = new Intent(this,navegador.class);
                startActivity(sig);

            }else{
                Toast.makeText(this, "NO SE ENCUENTRA REGISTRADO", Toast.LENGTH_SHORT).show();
                Intent sig = new Intent(this,registro.class);
                startActivity(sig);
                BasedeDatos.close();
            }

    }
}
