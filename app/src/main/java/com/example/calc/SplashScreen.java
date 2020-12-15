package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import com.example.calc.databinding.ActivitySplashScreenBinding;

import static com.example.calc.R.color.darkModeBG;
import static com.example.calc.R.color.lightModeBG;
public class SplashScreen extends AppCompatActivity{
    private final int SPLASH_DISPLAY_LENGTH = 1500;
    private ActivitySplashScreenBinding binding;
//    private boolean isToDarkMode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent goToMainActivity = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(goToMainActivity);
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);

    }



}