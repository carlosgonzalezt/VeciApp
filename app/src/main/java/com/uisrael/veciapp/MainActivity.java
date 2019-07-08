package com.uisrael.veciapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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
    private EditText ob_pt_repclave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Se asignan las variables a los objetos creados en el activity
        ob_pt_nombre = (EditText) findViewById(R.id.pt_nombre);
        ob_pt_apellido = (EditText) findViewById(R.id.pt_apellido);
        ob_pt_correo = (EditText) findViewById(R.id.pt_correo);
        ob_pt_clave = (EditText) findViewById(R.id.pw_clave);
        ob_pt_repclave = (EditText) findViewById(R.id.pw_repclave);

        String [] archivos=fileList();
        if(ExisteArchivo(archivos,"locales.txt")){
            try{
                InputStreamReader archivo = new InputStreamReader(openFileInput("locales.txt"));
                BufferedReader br= new BufferedReader(archivo);
                String linea = br.readLine();
                String notas[]=new String[99];
                int count=0;
                while(linea!=null){
                    notas[count]=linea;
                    linea = br.readLine();
                    count++;

                }
                br.close();
                archivo.close();
                ob_pt_nombre.setText(notas[0]);
                ob_pt_apellido.setText(notas[1]);
                ob_pt_correo.setText(notas[2]);
                ob_pt_usuario.setText(notas[3]);
            }catch (IOException e){

            }

        }

    }
    private boolean ExisteArchivo(String[] archivos, String nombreArchivo){

        for(int i=0;i<archivos.length;i++){
            if(nombreArchivo.equals(archivos[i]))
                return true;
            return false;
        }
        return false;
    }

    public void siguiente(View view){

        if(ob_pt_clave.getText().length()>1){
            String nombre = ob_pt_nombre.getText().toString();
            String apellido = ob_pt_apellido.getText().toString();
            String correo = ob_pt_correo.getText().toString();
            String usuario = ob_pt_usuario.getText().toString();
            String clave = ob_pt_clave.getText().toString();

            Intent sig = new Intent(this,InformacionNegocio.class);
            sig.putExtra("main_nombre",nombre.toString());
            sig.putExtra("main_apellido",apellido.toString());
            sig.putExtra("main_correo",correo.toString());
            sig.putExtra("main_usuario",usuario.toString());
            sig.putExtra("main_clave",clave.toString());
            startActivity(sig);
        }else{
            ob_pt_clave.setError("Este campo no deve estar en blanco");
        }

    }

    //https://www.movilzona.es/tutoriales/android/desarrollo/curso-de-desarrollo-android-tema-18-webview-que-es-y-como-funciona-la-vista-de-navegacion-web/

}
