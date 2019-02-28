package mx.edu.ittepic.p1_recetasdecocinabaltazarramirezfj;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDatos extends SQLiteOpenHelper
{
    public BaseDatos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override //onCreate signigica que se ejecuta cuando se abre la aplicacion
    public void onCreate(SQLiteDatabase db) { //SQLiteDatabase db este es el parametro para ejecutar. SQLiteDatabase esta es capas de realizar cualquier tipo de transaccion que nosotros conoscamos
        //Se ejecuta cuando la aplicacion (DADM_U4_Practica1) se ejecuta en el CEL
        //Sirve para construir en el SQLITE que esta en el CEL las tablas que la APP requiere para funcionar
        //Inserta datos de SQL que nosotros conoscamos con los comandos que conocemos
        db.execSQL("CREATE TABLE RECETAS(ID INTEGER PRIMARY KEY, NOMBRE VARCHAR(200), INGREDIENTES VARCHAR(1000),PREPARACION VARCHAR(1000),OBSERVACIONES VARCHAR(500))");//esta instruccion puede realizartodo mennos el selecct, FUNCIONA PARA insert,create_table,delete,update.
        //CHAR -> Se utiliza y si no se ocupatodo los demas espacios se ocupan con algo
        //VARCHAR -> Se utiliza solo lo que se va a iimplementar
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {//adbdate acuatilizaciones menores y //adgrade actualizacion mayo (modificando datos al modificar las tablas y eso)
        //Las versiones no se decrementan
        //se ejecuta cuando el oncreate crea las tablas, toda la alteracion
        //Solo se puede subir de actualizacion y no se puede poner una actualizacion menor a la actual
    }
}
