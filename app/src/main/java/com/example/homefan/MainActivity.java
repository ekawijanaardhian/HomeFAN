package com.example.homefan;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.animation.LinearInterpolator;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    ToggleButton toggleButton;
    ImageView imageView;
    ObjectAnimator rotateanimator;
    Switch switchButton;
    SeekBar seekBar;
    final int SPEED[] = {0, 5000, 3000, 1000};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GradientDrawable gd = new GradientDrawable();

        imageView = (ImageView) findViewById(R.id.imageView);
        rotateanimator = ObjectAnimator.ofFloat(imageView,"rotation",0,360);
        rotateanimator.setDuration(1000);
        rotateanimator.setRepeatCount(ValueAnimator.INFINITE);
        rotateanimator.setInterpolator(new LinearInterpolator());


        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        if (toggleButton.isChecked()){
            rotateanimator.setDuration(SPEED[2]);
            rotateanimator.start();
        }
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    rotateanimator.setDuration(SPEED[2]);
                    rotateanimator.start();
                } else rotateanimator.end();
            }
        });
    }
}