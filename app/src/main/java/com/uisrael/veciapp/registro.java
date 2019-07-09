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
import android.database.sqlite.SQLiteDatabase;

public class registro extends AppCompatActivity {

    private EditText pt_correo, pw_contrasena1, pw_contrasena2;
    private  int id=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        pt_correo =  findViewById(R.id.pt_correo2);
        pw_contrasena1 =  findViewById(R.id.pw_clave2);
        pw_contrasena2 =  findViewById(R.id.pw_repclave2);
    }

    public boolean Confirmacion(){
        boolean resultado = false;
        String clave1 = pw_contrasena1.getText().toString();
        String clave2 = pw_contrasena2.getText().toString();

        if(clave1.length()>0 && clave2.length()>0) {
            if (clave1.equals(clave2)){
                resultado = true;
            }else {
                resultado = false;
            }
        }else{
            Toast.makeText(this, "Debe llenar los campos de contraseña.", Toast.LENGTH_SHORT).show();
        }

        return resultado;
    }

    public boolean ExisUsuario(){
        boolean existe = false;

        VeciSQLiteOpenHelper admin = new VeciSQLiteOpenHelper(this,"administracion",null,1);
        SQLiteDatabase BasedeDatos = admin.getWritableDatabase();

        String correo = pt_correo.getText().toString();

        if(!correo.isEmpty()){
            Cursor fila = BasedeDatos.rawQuery("select id_usuario from usuario where correo='"+pt_correo+"'", null);
            if(fila.moveToFirst()){
                existe = true;
            }else {
                existe = false;
            }
        }else{
            Toast.makeText(this, "Debe llenar el campo del correo electronico.", Toast.LENGTH_SHORT).show();
        }
        BasedeDatos.close();

        return existe;
    }

    public void Registrar(View view){

        if (Confirmacion()){//Se verifica que la contraseña y la confirmacion sea la misma
            if(ExisUsuario()){//Se confirma si el usuaio ya existe para que no se repita
                Toast.makeText(this, "El usuario ya existe", Toast.LENGTH_SHORT).show();
            }else{
                try {
                    //Aqui va el codigo de guardado
                    VeciSQLiteOpenHelper admin = new VeciSQLiteOpenHelper(this, "administracion", null, 1);
                    SQLiteDatabase BasedeDatos = admin.getWritableDatabase();//abre la BD de modo lectura escritura

                    //para crear y guardar el usuario
                    Cursor fila = BasedeDatos.rawQuery("select MAX(id_usuario) as id from usuario ", null);
                    int id_usuario = 0;
                    try{
                        id_usuario = fila.getInt(fila.getPosition());
                    }catch(Error e){
                        id_usuario = 1;
                    }
                    String correo = pt_correo.getText().toString();
                    String clave = pw_contrasena1.getText().toString();
                    String tipo = "usuario normal";

                    ContentValues registro = new ContentValues();
                    registro.put("id_usuario",id_usuario);
                    registro.put("correo", correo);
                    registro.put("t_usuatio", tipo);
                    registro.put("clave", clave);

                    BasedeDatos.insert("usuario", null, registro);

                    //para crear y guardar el perfil del usuario
                    Cursor fila_pu = BasedeDatos.rawQuery("select MAX(id_datos_us) as id from perfil_usuario ", null);
                    ContentValues registro_pu = new ContentValues();

                    int id_pusuario = 0;
                    try{
                        id_pusuario = fila_pu.getInt(fila_pu.getPosition());
                    }catch(Error e){
                        id_pusuario = 1;
                    }

                    registro.put("id_datos_us",id_pusuario);
                    registro.put("id_usuario", id_usuario);
                    registro.put("nombres", "");
                    registro.put("apellidos", "");

                    BasedeDatos.insert("perfil_usuario", null, registro_pu);

                    BasedeDatos.close();

                    pt_correo.setText("");
                    pw_contrasena1.setText("");
                    pw_contrasena2.setText("");

                    Toast.makeText(this, "Registro correcto", Toast.LENGTH_SHORT).show();

                    Intent sig = new Intent(this, navegador.class);
                    startActivity(sig);
                }catch(Error e){
                    Toast.makeText(this, "Un error ha ocurrido: "+e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }else{
            Toast.makeText(this, "la Contraseña y su confirmacion no coiciden", Toast.LENGTH_SHORT).show();
        }
    }
}
