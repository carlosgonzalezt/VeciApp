package com.uisrael.veciapp;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class VeciSQLiteOpenHelper extends SQLiteOpenHelper {

    public VeciSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase veciDB) {//nombre de la base de datos
        veciDB.execSQL("create table usuario(id_usuario integer primary key, correo text,t_usuatio text, clave text)");
        veciDB.execSQL("create table perfil_usuario(id_datos_us integer primary key, id_usuario integer,nombres text,apellidos text)");
        veciDB.execSQL("create table tipo_negocio(id_tnegocio integer primary key, descripcion text)");
        veciDB.execSQL("create table negocio(id_negocio integer primary key, id_usuario integer, id_tnegocio integer, nom_negocio text,logo text, coordenadas text)");
        veciDB.execSQL("create table evaluacion(id integer primary key, id_negocio integer, calificacion integer, comentario text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }   //usamos herencia
}
