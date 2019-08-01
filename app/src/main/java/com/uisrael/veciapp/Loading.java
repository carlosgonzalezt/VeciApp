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

        try {
            VeciSQLiteOpenHelper admin = new VeciSQLiteOpenHelper(this, "administracion", null, 1);
            SQLiteDatabase veciDB = admin.getWritableDatabase();//modo lectura escritura

            Cursor fila = veciDB.rawQuery("select correo from usuario ", null); //deja aplicar select

            if(fila.moveToFirst()){
                veciDB.close();
                Intent sig = new Intent(this,navegador.class);
                startActivity(sig);
            }else{
                Intent sig = new Intent(this,login.class);
                startActivity(sig);
                veciDB.close();
            }
        }catch(Error e){
            Toast.makeText(this, "Salio un error. "+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
