package com.example.baltaramirezfjrelojincanvas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(new Relog(this));
    }

    public class Relog extends View {
        private  final long TIEMPO_REFRESCO = 20; // 20 o 1000 velocidad de refresco
        private Paint ColorFondoPintura;
        private Paint ManesillaPintura;
        private Paint relojito;

        public Relog(Context context) {
            super(context);
            init(context, null);
        }
        public Relog(Context context, AttributeSet attrs) {
            super(context, attrs);
            init(context, attrs);
        }
        public Relog(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
            init(context, attrs);
        }

        private void init(Context context, AttributeSet attrs) {
            relojito = new Paint();
            ColorFondoPintura = new Paint();
            //ColorFondoPintura.setColor(Color.WHITE);
            ColorFondoPintura.setAntiAlias(true);
            ManesillaPintura = new Paint();
            ManesillaPintura.setColor(Color.BLUE);
            ManesillaPintura.setAntiAlias(true);
        }

        private Runnable invalidator = new Runnable() {
            @Override
            public void run() {
                invalidate();
            }
        };

        @Override
        protected void onDraw(Canvas canvas) {
            //dibujarFondo(canvas);
            relojitoo(canvas);
            dibjarManecillaHora(canvas);
            dibjarManecillaMinutos(canvas);
            dibjarManecillaSegundos(canvas);
            //dibujarUna(canvas);
            postDelayed(invalidator, TIEMPO_REFRESCO);
        }

        private void relojitoo(Canvas canvas) {
            Bitmap bmp = BitmapFactory.decodeResource(getResources(),
                    R.drawable.ry);
            canvas.drawBitmap(bmp, -2, 2, null);
        }

        private void dibjarManecillaHora(Canvas canvas) {
            float vistaRadio = getWidth() / 2f;
            float manoRadio = getWidth() * 0.2f;
            float espesor = getWidth() * 0.01f;
            ManesillaPintura.setStrokeWidth(espesor);
            double angulo = getAnguloHora();
            float x = getX(vistaRadio, manoRadio, angulo);
            float y = getY(vistaRadio, manoRadio, angulo);
            canvas.drawLine(vistaRadio, vistaRadio, x, y, ManesillaPintura);
        }

        private void dibujarFondo(Canvas canvas) {
            float circuloFondo = getHeight() / 2f;
            canvas.drawCircle(5, 8, 8, ColorFondoPintura);
        }
        private void dibjarManecillaMinutos(Canvas canvas) {
            float vistaRadio = getWidth() / 2f;
            float manoRadio = getWidth() * 0.3f;
            float espesor = getWidth() * 0.01f;
            ManesillaPintura.setStrokeWidth(espesor);
            double angulo = getAnguloMinutos();
            float x = getX(vistaRadio, manoRadio, angulo);
            float y = getY(vistaRadio, manoRadio, angulo);
            canvas.drawLine(vistaRadio, vistaRadio, x, y, ManesillaPintura);
        }

        private void dibjarManecillaSegundos(Canvas canvas) {
            float vistaRadio = getWidth() / 2f;
            float manoRadio = getWidth() * 0.4f;
            float espesor = getWidth() * 0.005f;
            ManesillaPintura.setStrokeWidth(espesor);
            double angulo = getAnguloSegundos();
            float x = getX(vistaRadio, manoRadio, angulo);
            float y = getY(vistaRadio, manoRadio, angulo);
            canvas.drawLine(vistaRadio, vistaRadio, x, y, ManesillaPintura);
        }
        private float getX(float vistaRadio, float manoRadio, double angulo) {
            return (float) (vistaRadio + manoRadio * Math.sin(angulo));
        }
        private float getY(float vistaRadio, float manoRadio, double angulo) {
            return (float) (vistaRadio - manoRadio * Math.cos(angulo));
        }

        /*private void dibujarUna(Canvas canvas) {
            float vistaRadio = getHeight() / 2f;
            float unaRadio = getHeight() * 0.02f;
            canvas.drawCircle(vistaRadio, vistaRadio, unaRadio, ManesillaPintura);
        }*/

        private double getAnguloHora() {
            Calendar c = Calendar.getInstance();
            int horas = c.get(Calendar.HOUR);
            int minutos = c.get(Calendar.MINUTE);
            int minutosInicio = horas * 60 + minutos;
            return (2 * Math.PI * minutosInicio) / 720; //Minutos en 12 horas
        }
        private double getAnguloMinutos() {
            Calendar c = Calendar.getInstance();
            int segundosDesdeElInicio = c.get(Calendar.MINUTE) * 60  + c.get(Calendar.SECOND);
            return (2 * Math.PI * segundosDesdeElInicio) / 3600; // Divide los segundos en una hora
        }

        private double getAnguloSegundos() {
            Calendar c = Calendar.getInstance();
            int millisFromStart = c.get(Calendar.SECOND) * 1000 + c.get(Calendar.MILLISECOND);
            return (2 * Math.PI * millisFromStart) / 60000; // Milisegundos en 1 mnuto
        }
    }
}
