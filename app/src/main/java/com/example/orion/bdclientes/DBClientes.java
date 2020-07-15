package com.example.orion.bdclientes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Orion on 18/03/2017.
 */

public class DBClientes extends SQLiteOpenHelper {

    String SQL = "create table clientes(idcte int primary key, nombre varchar(25), direccion varchar(30), sexo char(1), estado varchar(25), edad int default 18, telefono char(12), email varchar(30))";

    public DBClientes(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
