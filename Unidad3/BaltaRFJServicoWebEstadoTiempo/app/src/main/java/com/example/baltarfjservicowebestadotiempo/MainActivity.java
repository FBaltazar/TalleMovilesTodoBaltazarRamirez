package com.example.baltarfjservicowebestadotiempo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements  AsyncResponse{

    ConexionWeb conexionWeb;
    TextView txtCli,txtCli2,txtCli3,edtCiudad,clima;
    Button btnBuscar;
    String cadena="";


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCli = findViewById(R.id.Uno);
        txtCli2 = findViewById(R.id.Dos);
        txtCli3 = findViewById(R.id.Tres);
        clima = findViewById(R.id.climat);
        btnBuscar = findViewById(R.id.btnCiudades);
        edtCiudad = findViewById(R.id.editText);
        Clima();

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadena = edtCiudad.getText().toString();
                Clima();
            }
        });
    }

    public void Clima()
    {
        try {
            conexionWeb = new ConexionWeb(MainActivity.this);
            URL direcciopn = new URL("http://api.openweathermap.org/data/2.5/weather?q="+cadena+",mx&APPID=043746939e7268316c8bbe640799c06d&units=metric");
            conexionWeb.execute(direcciopn);
        }
        catch (MalformedURLException e)
        {
            Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    public void proceso(String r)
    {
        try {
            JSONObject object = new JSONObject(r);
            JSONArray clima = object.getJSONArray("weather");

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < clima.length(); i++) {
                JSONObject objeto = clima.getJSONObject(i);

                String main = objeto.getString("main");
                String des = objeto.getString("description");
                sb.append(main+" : "+des+"         ");
            }
            JSONObject  clima3j= object.getJSONObject("wind");
            txtCli.setText(sb+"visibilidad: "+ object.getString("id")+"\n"+"Velocidad : "+clima3j.getString("speed")+"\n"+" Grados: "+clima3j.getString("deg"));
            JSONObject  clima2j= object.getJSONObject("main");
            JSONObject  climaj= object.getJSONObject("coord");
            txtCli2.setText("\n"
                    +"Temperatura: "+clima2j.getString("temp")+ "\n"
                    +"Humedad: "+clima2j.getString("humidity")+ "\n"
                    +"temperatura minima: "+clima2j.getString("temp_min")+"\n"
                    +"temperatura maxima: "+clima2j.getString("temp_max"));

            txtCli3.setText("\n"
                    +"Longitud: "+climaj.getString("lon")+ "\n"
                    +"Latitud: "+climaj.getString("lat"));
        }catch (JSONException e){
            System.out.println(""+e);
        }
    }
}
