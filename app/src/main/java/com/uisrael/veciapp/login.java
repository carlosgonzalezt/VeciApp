package com.uisrael.veciapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    private EditText pt_usuario, pw_clave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        pt_usuario = findViewById(R.id.pt_usuario);
        pw_clave = findViewById(R.id.pw_clave);
    }

    public void Buscar(View view){
        boolean existe = false;

        VeciSQLiteOpenHelper admin = new VeciSQLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase BasedeDatos = admin.getWritableDatabase();

        String correo = pt_usuario.getText().toString();

        if(!correo.isEmpty()){
            Cursor fila = BasedeDatos.rawQuery("select id_usuario from usuario where correo='"+pt_usuario+"' and clave='"+pw_clave+"'", null);
            if(fila.moveToFirst()){
                Intent sig = new Intent(this, navegador.class);
                startActivity(sig);
            }else {
                Toast.makeText(this, "El usuario o la clave no son correctos.", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Debe llenar el campo del correo electronico.", Toast.LENGTH_SHORT).show();
            pt_usuario.setText("");
            pw_clave.setText("");
        }
        BasedeDatos.close();
    }

    public void Registrar(View view){
        Intent sig = new Intent(this, registro.class);
        startActivity(sig);
    }


}
