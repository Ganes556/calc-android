package com.example.calc;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calc.databinding.ActivitySplashScreenBinding;

import static com.example.calc.R.color.darkModeBG;
import static com.example.calc.R.color.lightModeBG;


public class SplashScreen extends AppCompatActivity implements Theme {

    private ActivitySplashScreenBinding binding;
    private boolean isDarkMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadTheme();
        viewThemeUpdate();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent goToMainActivity = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(goToMainActivity);
                finish();
            }
        }, 1500);
    }


    @Override
    public void darkMode() {
        binding.bgSplash.setBackgroundResource(darkModeBG);
    }

    @Override
    public void lightMode() {
        binding.bgSplash.setBackgroundResource(lightModeBG);
    }

    @Override
    public void loadTheme() {
        isDarkMode = getSharedPreferences(MainActivity.THEME_PREFS, MODE_PRIVATE).getBoolean(MainActivity.KEY_THEME_UPDATE, true);
    }

    @Override
    public void viewThemeUpdate() {
        if (isDarkMode) {
            darkMode();
        } else if (!isDarkMode) {
            lightMode();
        }
    }
}