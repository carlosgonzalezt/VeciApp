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
        veciDB.execSQL("create table usuario(id_usuario integer primary key autoincrement,correo_electronico text,t_usuatio text, clave text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }   //usamos herencia
}
