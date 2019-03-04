package com.example.cursosrecyclerviewbrfj;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private BaseDatos base;

    String [] clave= new String[10];
    String [] nombres= new String[10];
    String [] domicilio= new String[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        base=new BaseDatos(this, "primera",null,1); //clase de conexion BaseDatos y la bd se llama primera
        try{
            SQLiteDatabase tabla= base.getReadableDatabase();
            String SQL ="SELECT * FROM PROPIETARIO";

            Cursor resultado =tabla.rawQuery(SQL, null);
            if(resultado.moveToFirst()) {
                int i=0;
                while(!resultado.isAfterLast()){
                    clave[i]=resultado.getString(0);
                    nombres[i]=resultado.getString(1);
                    domicilio[i]=resultado.getString(2);
                    i++;
                    resultado.moveToNext();
                }
            }
            tabla.close();
        }catch (SQLiteException e){
            Toast.makeText(this, "NO SE PUDO REALIZAR"+e.toString(), Toast.LENGTH_LONG).show();
        }

        // Crear referencias hacia el componente RecycleriView
        recyclerView = findViewById(R.id.recycler_id);

        // Crear un objeto de tipo RecyclerAdapter que recibe un arreglo de cadenas
        adapter = new RecyclerAdapter(clave,nombres,domicilio, this);

        // Crea un objeto de tipo LinearLayoutManager
        layoutManager = new LinearLayoutManager(this);

        // Establecer el LayautManager
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        // Establecer el Adapter
        recyclerView.setAdapter(adapter);

    }
}
