package com.example.baltarfj_giroscopio;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.juang.jplot.PlotPlanitoXY;

public class MainActivity extends AppCompatActivity implements SensorEventListener
{
    private Sensor mySensor;
    private SensorManager senMan;
    TextView txt_X,txt_Y,txt_Z;



    private PlotPlanitoXY plot;
    private LinearLayout pantalla;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context=this;
        pantalla= (LinearLayout) (findViewById(R.id.pantalla));

        senMan = (SensorManager) getSystemService(SENSOR_SERVICE);
        mySensor= senMan.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        txt_X=(TextView)findViewById(R.id.txtX);
        txt_Y=(TextView)findViewById(R.id.txtY);
        txt_Z=(TextView)findViewById(R.id.txtZ);
        senMan.registerListener(this,mySensor,SensorManager.SENSOR_DELAY_NORMAL);

        //float x[]={2,3,4,5};
        //float y[]={4,3,6,9};
        float x[]={};
        float y[]={};
        plot = new PlotPlanitoXY(context,"TitulinCHi","EQUIS","YEE");
        plot.SetSerie1(x,y,"graph 1",5,true);
        plot.SetHD(true);
        plot.SetTouch(true);
       // plot.SetColorFondo(230,55,100);

        /*String xs=txt_X.getText().toString();
        Float XS= Float.parseFloat(xs);*/

        pantalla.addView(plot);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        float g;
        txt_X.setText(""+event.values[0]);

        txt_Y.setText(""+event.values[1]);
        txt_Z.setText(""+event.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
