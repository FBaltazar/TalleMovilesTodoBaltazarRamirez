package com.example.baltarfj_proyectoanimacion;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    Button btnIniciar,btnDetener,btnIniciar2,btnDetener2;
    ImageView imageView,imageView2,imageView3,imageView4;
    AnimationDrawable anim,anim2,anim3;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIniciar = (Button)findViewById(R.id.btnRun);
        btnDetener = (Button)findViewById(R.id.btnStop);
        btnIniciar2 = (Button)findViewById(R.id.btnRun2);
        btnDetener2 = (Button)findViewById(R.id.btnStop2);

        imageView = (ImageView)findViewById(R.id.imageView);
        imageView2 = (ImageView)findViewById(R.id.imageView1);
        imageView3 = (ImageView)findViewById(R.id.imageView4);
        imageView4 = (ImageView)findViewById(R.id.imageView5);

        mp = MediaPlayer.create(this,R.raw.sonidito);

        if (imageView==null) throw new AssertionError();
        if (imageView2==null) throw new AssertionError();
        if (imageView3==null) throw new AssertionError();

        imageView.setBackgroundResource(R.drawable.animation);
        imageView2.setBackgroundResource(R.drawable.animation2);
        imageView3.setBackgroundResource(R.drawable.animation3);

        imageView.setVisibility(View.INVISIBLE);
        imageView2.setVisibility(View.INVISIBLE);
        imageView3.setVisibility(View.VISIBLE);

        anim = (AnimationDrawable)imageView.getBackground();
        anim2 = (AnimationDrawable)imageView2.getBackground();
        anim3 = (AnimationDrawable)imageView3.getBackground();

        anim3.start();

        mp.start();

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (anim3.isRunning())
                    anim3.stop();
                imageView3.setVisibility(View.INVISIBLE);
                imageView4.setVisibility(View.INVISIBLE);

            }
        });

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setVisibility(View.VISIBLE);
                    //mp.isPlaying();

                if (anim.isRunning())
                    anim.stop();
                anim.start();
            }
        });
        btnDetener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                anim.stop();

            }
        });

        btnIniciar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView2.setVisibility(View.VISIBLE);

                if (anim2.isRunning())
                    anim2.stop();
                anim2.start();
            }
        });
        btnDetener2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anim2.stop();
            }
        });



    }
}
