package com.example.baltarfj_4_1asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button boton2;
    TextView txtContador;
    EditText edtNumero;
    ProgressBar progressBar1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton2 =  findViewById(R.id.btn2);
        txtContador =  findViewById(R.id.textView);
        edtNumero =  findViewById(R.id.edtNumero);
        progressBar1 =  findViewById(R.id.progressBar1);

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtNumero.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Ingrese Número", Toast.LENGTH_SHORT).show();
                }
                else{
                    AsyncTarea asyncTarea = new AsyncTarea();
                    asyncTarea.execute(Integer.parseInt(edtNumero.getText().toString()));
                }
            }
        });
    }

    private void UnSegundo() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private class  AsyncTarea extends AsyncTask<Integer, Integer,Boolean> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Boolean doInBackground(Integer... params) {
            progressBar1.setMax(params[0]);
            for (int i=1; i<=params[0]; i++){
                UnSegundo();

                publishProgress(i);

                if (isCancelled()){
                    break;
                }
            }
            return true;
        }


        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            progressBar1.setProgress(values[0].intValue());
            txtContador.setText(""+((values[0].intValue())));
        }

    }
}