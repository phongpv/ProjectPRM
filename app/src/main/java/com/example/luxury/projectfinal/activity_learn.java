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
import android.widget.TextView;

import java.util.ArrayList;

public class activity_learn extends AppCompatActivity {

    boolean isFlipped = true;
    CardView cardFront;
    CardView cardBack;
    ImageView imageViewFront;
    TextView cardTextAnswer, textDescription;
    ArrayList<Learn> data = new ArrayList<>();
    int index = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        data.add(new Learn("@drawable/blackdog", "Con cho", "Con vật mà rất trung thành với chủ nhân 1.", 1));
        data.add(new Learn("@drawable/blackdog", "Con cho1", "Con vật mà rất trung thành với chủ nhân 2.", 1));
        data.add(new Learn("@drawable/blackdog", "Con cho2", "Con vật mà rất trung thành với chủ nhân 3.", 1));
        data.add(new Learn("@drawable/blackdog", "Con cho3", "Con vật mà rất trung thành với chủ nhân 4.", 1));

        imageViewFront = findViewById(R.id.imageViewFront);
        cardTextAnswer = findViewById(R.id.cardTextAnswer);
        textDescription = findViewById(R.id.textDescription);
        // init data for first time
        setData(data.get(index));
    }

    // set data
    void setData(Learn learn) {
        if (!learn.getUrl().equals("")) {
            imageViewFront.setImageDrawable(getDrawable(R.drawable.blackdog));
            if (!learn.getName().equals("")) {
                cardTextAnswer.setText(learn.getName().toString());
            }
            if (!learn.getDescription().equals("")) {
                textDescription.setText(learn.getDescription().toString());
            }
        }
    }

    // go next
    void learnGoNext (View v) {
        if (index < data.size()-1) {
            index++;
            setData(data.get(index));
        }
    }

    // go previous
    void learnGoPrevious (View v) {
        if (index > 0) {
            index--;
            setData(data.get(index));
        }
    }


    // flip card view
    void flipCard(View v) {
        cardFront = findViewById(R.id.cardFrontImageLearn);
        cardBack = findViewById(R.id.cardBackImageLearn);

        if (isFlipped) {
            cardFront.animate().withLayer()
                .rotationY(90)
                .setDuration(400)
                .withEndAction(new Runnable() {
                    @Override public void run() {
                        cardFront.setRotationY(0);
                        cardFront.setVisibility(View.GONE);
                        cardBack.setVisibility(View.VISIBLE);
                        }
                    }
                ).start();

        } else {
            cardBack.animate().withLayer()
                .rotationY(90)
                .setDuration(400)
                .withEndAction(new Runnable() {
                   @Override public void run() {
                       cardBack.setRotationY(0);
                       cardBack.setVisibility(View.GONE);
                       cardFront.setVisibility(View.VISIBLE);
                       }
                   }
                ).start();

        }
        isFlipped = !isFlipped;
    }
}
