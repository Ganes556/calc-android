package com.example.calc;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calc.databinding.ActivitySplashScreenBinding;

import static com.example.calc.R.color.darkModeBG;
import static com.example.calc.R.color.lightModeBG;

public class SplashScreen extends AppCompatActivity {

    private final ThemeSwitch themeSwitch = new ThemeSwitch();
    private ActivitySplashScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        switchTheme();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent goToMainActivity = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(goToMainActivity);
                finish();
            }
        }, 1500);

    }

    private void switchTheme() {
        if (themeSwitch.isDarkMode()) {
            binding.bgSplash.setBackgroundResource(darkModeBG);
        } else if (!themeSwitch.isDarkMode()) {
            binding.bgSplash.setBackgroundResource(lightModeBG);
        }
    }
}