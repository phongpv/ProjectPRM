package com.example.luxury.projectfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    ImageView imageView;
    TextView txtNameApp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();

        imageView = (ImageView) findViewById(R.id.imageView);
        txtNameApp = (TextView) findViewById(R.id.txtNameApp);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.splashamin);
        imageView.startAnimation(animation);
        txtNameApp.startAnimation(animation);

        final Intent intent = new Intent(this, MainActivity.class);

        Thread thread = new Thread() {
            public void run() {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(intent);
                    finish();
                }
            }
        };
        thread.start();
    }
}
