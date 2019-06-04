package com.example.baltarfj_4_5_frameanimation;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
{
    Button btnIniciar,btnDetener;
    ImageView imageView;
    AnimationDrawable anim;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIniciar = (Button)findViewById(R.id.btnRun);
        btnDetener = (Button)findViewById(R.id.btnStop);
        imageView = (ImageView)findViewById(R.id.imageView);

        if (imageView==null) throw new AssertionError();

        imageView.setBackgroundResource(R.drawable.animation);
        imageView.setVisibility(View.INVISIBLE);

        anim = (AnimationDrawable)imageView.getBackground();

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setVisibility(View.VISIBLE);

                if (anim.isRunning())
                    anim.stop();
                anim.start();
            }
        });
        btnDetener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anim.stop();
            }
        });

    }
}
