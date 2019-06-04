package com.example.baltarfj_labo_json;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    String json_string;

    RecyclerView recyclerView;
    RecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById( R.id.idRecyclerView);
        new Proceso().execute();
    }

    private class Proceso extends AsyncTask<Void, Void, String>
    {
        String json_url;

        @Override
        protected String doInBackground(Void... Voids)
        {
            String cadena="";
            json_url = "https://api.myjson.com/bins/8zjyq";

            try {
                        URL url = new URL(json_url);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        int respuesta = httpURLConnection.getResponseCode();

                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                        StringBuilder stringBuilder = new StringBuilder();

                        if (respuesta == HttpURLConnection.HTTP_OK)
                        {
                            String abc=json_string;

                            while ((json_string = bufferedReader.readLine()) != null)
                            {
                                stringBuilder.append(json_string + "\n");
                            }
                            bufferedReader.close();
                            inputStream.close();
                            httpURLConnection.disconnect();
                            cadena = stringBuilder.toString().trim();
                        }
                } catch (MalformedURLException e)
                {
                    e.printStackTrace();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            return cadena;
        }

        @Override
        protected void onPostExecute(String result)
        {
            List<AlumnosITT> alumnos = new ArrayList<>();
            try {
                    JSONArray alumno = new JSONArray( result );

                    for (int i = 0; i < alumno.length(); i++)
                    {
                        JSONObject c = alumno.getJSONObject(i);

                        int numControl = c.getInt("Nctrl");
                        String name = c.getString("Name");
                        int unidad1 = c.getInt("u1");
                        int unidad2 = c.getInt("u2");
                        int unidad3 = c.getInt("u3");

                        alumnos.add( new AlumnosITT(numControl,name,unidad1,unidad2,unidad3));
                    }
                        recyclerView = (RecyclerView)findViewById(R.id.idRecyclerView);
                        mAdapter = new RecyclerAdapter(MainActivity.this, alumnos);
                        recyclerView.setAdapter(mAdapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

            } catch (JSONException e)
            {
                Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_LONG).show();
            }
        }

        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Void... values)
        {
            super.onProgressUpdate(values);
        }
    }
}
