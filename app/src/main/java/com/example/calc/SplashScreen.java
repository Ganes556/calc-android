package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.example.calc.databinding.ActivitySplashScreenBinding;

import static com.example.calc.R.color.darkModeBG;
import static com.example.calc.R.color.lightModeBG;
public class SplashScreen extends AppCompatActivity implements Themes{
    private final int SPLASH_DISPLAY_LENGTH = 1500;
    private ActivitySplashScreenBinding binding;
    private boolean isToDarkMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadTheme();

        viewThemeUpdate();

        // control of length splash screen
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent goToMainActivity = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(goToMainActivity);
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);

    }

    @Override
    public void isToLightMode() {
        binding.bgSplash.setBackgroundResource(lightModeBG);
    }

    @Override
    public void isToDarkMode() {
        binding.bgSplash.setBackgroundResource(darkModeBG);
    }

    @Override
    public void loadTheme() {
        isToDarkMode = getSharedPreferences(MainActivity.THEME_PREFS, MODE_PRIVATE).getBoolean(MainActivity.KEY_THEME_UPDATE,true);
    }

    @Override
    public void viewThemeUpdate() {
        if(isToDarkMode){
            isToDarkMode();
        }else{
            isToLightMode();
        }
    }
}