package com.uisrael.veciapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.security.ConfirmationAlreadyPresentingException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.database.sqlite.SQLiteDatabase;

public class registro extends AppCompatActivity {

    private EditText pt_correo, pw_contrasena1, pw_contrasena2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        pt_correo = (EditText) findViewById(R.id.pt_correo);
        pw_contrasena1 = (EditText) findViewById(R.id.pw_clave);
        pw_contrasena2 = (EditText) findViewById(R.id.pw_repclave);
    }

    public void Registrar(View view){
        String v_correo = pt_correo.getText().toString();
        String v_clave1 = pw_contrasena1.getText().toString();
        String v_clave2 = pw_contrasena2.getText().toString();
        int v_existe = 0;

        if(!v_correo.isEmpty() && !v_clave1.isEmpty() && !v_clave2.isEmpty() ) {
            if (v_clave1 == v_clave2) {//Se verifica que la contraseña y la confirmacion sea la misma
                try {
                    VeciSQLiteOpenHelper admin = new VeciSQLiteOpenHelper(this,"administracion",null,1);
                    SQLiteDatabase BasedeDatos = admin.getWritableDatabase();

                    Cursor fila = BasedeDatos.rawQuery("select * from usuario where correo_electronico='"+pt_correo+"'", null);
                    if(fila.moveToFirst()){
                        v_existe = 1;
                    }else {
                        v_existe = 0;
                    }

                    if (v_existe == 1) {//Se confirma si el usuaio ya existe para que no se repita
                        Toast.makeText(this, "El usuario ya existe", Toast.LENGTH_SHORT).show();
                    } else {
                        try {
                            //Integer id_usuario = 1;
                            String correo = pt_correo.getText().toString();
                            String clave = pw_contrasena1.getText().toString();
                            String tipo = "usuario normal";

                            ContentValues registro = new ContentValues();
                            //registro.put("id_usuario", id_usuario);
                            registro.put("correo_electronico", correo);
                            registro.put("t_usuario", tipo);
                            registro.put("clave", clave);

                            BasedeDatos.insert("usuario", null, registro);
                            BasedeDatos.close();

                            pt_correo.setText("");
                            pw_contrasena1.setText("");
                            pw_contrasena2.setText("");

                            Toast.makeText(this, "Registro correcto", Toast.LENGTH_SHORT).show();

                            Intent sig = new Intent(this, navegador.class);
                            startActivity(sig);
                        } catch (Error e) {
                            Toast.makeText(this, "Un error ha ocurrido: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                    BasedeDatos.close();
                }catch(Error e){
                    Toast.makeText(this, "Se produjo el siguiente error: "+e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "La Contraseña y su confirmacion no coinciden", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Debe llenar todos los campos.", Toast.LENGTH_SHORT).show();
        }
    }
}
