package com.example.cursosrecyclerviewbrfj;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDatos extends SQLiteOpenHelper {
    public BaseDatos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE PROPIETARIO(IDP VARCHAR(200) PRIMARY KEY NOT NULL, NOMBRE VARCHAR(200), SALARIO VARCHAR(500))");
        db.execSQL("INSERT INTO PROPIETARIO VALUES('1','Angel','220000')");
        db.execSQL("INSERT INTO PROPIETARIO VALUES('2','Adrian','300000')");
        db.execSQL("INSERT INTO PROPIETARIO VALUES('3','Lopez','123100')");
        db.execSQL("INSERT INTO PROPIETARIO VALUES('4','Baltazar','783200')");
        db.execSQL("INSERT INTO PROPIETARIO VALUES('5','Ramirez','222300')");
        db.execSQL("INSERT INTO PROPIETARIO VALUES('6','Francisco','32300')");
        db.execSQL("INSERT INTO PROPIETARIO VALUES('7','Javier','12400')");
        db.execSQL("INSERT INTO PROPIETARIO VALUES('8','Baltazar','99000')");
        db.execSQL("INSERT INTO PROPIETARIO VALUES('9','Ramirez','93200')");
        db.execSQL("INSERT INTO PROPIETARIO VALUES('10','Cachanilla','9000')");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
