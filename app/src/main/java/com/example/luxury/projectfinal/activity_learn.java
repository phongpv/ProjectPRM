package com.example.luxury.projectfinal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

public class activity_learn extends AppCompatActivity {

    boolean isFront = true, isFlipped = true;
    CardView cardFront;
    CardView cardBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
    }

    void flipCard(View v) {
        cardFront = findViewById(R.id.cardFrontImageLearn);
        cardBack = findViewById(R.id.cardBackImageLearn);

        final ImageView imageView = findViewById(R.id.imageViewFront);
        cardFront = findViewById(R.id.cardFrontImageLearn);
        imageView.animate().withLayer()
            .rotationY(90)
            .setDuration(300)
            .withEndAction(new Runnable() {
                    @Override public void run() {
                if (isFront) {
                    cardFront.setVisibility(View.GONE);
                    cardBack.setVisibility(View.VISIBLE);
                } else {
                    cardFront.setVisibility(View.VISIBLE);
                    cardBack.setVisibility(View.GONE);
                }
                isFront = !isFront;
                imageView.setRotationY(-90);
                imageView.animate().withLayer()
                    .rotationY(0)
                    .setDuration(300)
                    .start();
                    }
                }
            ).start();
    }
}
