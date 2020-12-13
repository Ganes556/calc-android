package com.example.calc;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calc.databinding.ActivityMainBinding;

import static com.example.calc.R.color.darkModeBG;
import static com.example.calc.R.color.darkModeText;
import static com.example.calc.R.color.lightModeBG;
import static com.example.calc.R.color.lightModeText;
import static com.example.calc.R.drawable;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    public static final String THEME_PREFS = "themePrefs";
    public static final String KEY_THEME_UPDATE = "themeMode";
    private boolean isDarkMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnC.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public boolean onLongClick(View v) {
                if (isDarkMode) {
                    isDarkMode = false;
                    saveTheme();
                } else {
                    isDarkMode = true;
                    saveTheme();
                }
                updateView();
                return true;
            }
        });
        loadTheme();
        updateView();
    }

    public void darkMode() {
        binding.viewTxt.setTextColor(getResources().getColor(darkModeText));
        binding.typeTxt.setTextColor(getResources().getColor(darkModeText));
        binding.bgMain.setBackgroundResource(darkModeBG);
        binding.btnC.setBackgroundResource(drawable.btn_outside_style_dark);
        binding.btnPercent.setBackgroundResource(drawable.btn_outside_style_dark);
        binding.btnDelete.setBackgroundResource(drawable.btn_outside_style_dark);
        binding.btnDivide.setBackgroundResource(drawable.btn_outside_style_dark);
        binding.btnMultiply.setBackgroundResource(drawable.btn_outside_style_dark);
        binding.btnMinus.setBackgroundResource(drawable.btn_outside_style_dark);
        binding.btnPlus.setBackgroundResource(drawable.btn_outside_style_dark);
        binding.btnEquals.setBackgroundResource(drawable.btn_equals_style_dark);
        binding.btnZero.setBackgroundResource(drawable.btn_inside_style_dark);
        binding.btnDot.setBackgroundResource(drawable.btn_inside_style_dark);
        binding.btnOne.setBackgroundResource(drawable.btn_inside_style_dark);
        binding.btnTwo.setBackgroundResource(drawable.btn_inside_style_dark);
        binding.btnThree.setBackgroundResource(drawable.btn_inside_style_dark);
        binding.btnFour.setBackgroundResource(drawable.btn_inside_style_dark);
        binding.btnFive.setBackgroundResource(drawable.btn_inside_style_dark);
        binding.btnSix.setBackgroundResource(drawable.btn_inside_style_dark);
        binding.btnSeven.setBackgroundResource(drawable.btn_inside_style_dark);
        binding.btnEight.setBackgroundResource(drawable.btn_inside_style_dark);
        binding.btnNine.setBackgroundResource(drawable.btn_inside_style_dark);
    }

    public void lightMode() {
        binding.viewTxt.setTextColor(getResources().getColor(lightModeText));
        binding.typeTxt.setTextColor(getResources().getColor(lightModeText));
        binding.bgMain.setBackgroundResource(lightModeBG);
        binding.btnC.setBackgroundResource(drawable.btn_outside_style_light);
        binding.btnPercent.setBackgroundResource(drawable.btn_outside_style_light);
        binding.btnDelete.setBackgroundResource(drawable.btn_outside_style_light);
        binding.btnDivide.setBackgroundResource(drawable.btn_outside_style_light);
        binding.btnMultiply.setBackgroundResource(drawable.btn_outside_style_light);
        binding.btnMinus.setBackgroundResource(drawable.btn_outside_style_light);
        binding.btnPlus.setBackgroundResource(drawable.btn_outside_style_light);
        binding.btnEquals.setBackgroundResource(drawable.btn_equals_style_light);
        binding.btnZero.setBackgroundResource(drawable.btn_inside_style_light);
        binding.btnDot.setBackgroundResource(drawable.btn_inside_style_light);
        binding.btnOne.setBackgroundResource(drawable.btn_inside_style_light);
        binding.btnTwo.setBackgroundResource(drawable.btn_inside_style_light);
        binding.btnThree.setBackgroundResource(drawable.btn_inside_style_light);
        binding.btnFour.setBackgroundResource(drawable.btn_inside_style_light);
        binding.btnFive.setBackgroundResource(drawable.btn_inside_style_light);
        binding.btnSix.setBackgroundResource(drawable.btn_inside_style_light);
        binding.btnSeven.setBackgroundResource(drawable.btn_inside_style_light);
        binding.btnEight.setBackgroundResource(drawable.btn_inside_style_light);
        binding.btnNine.setBackgroundResource(drawable.btn_inside_style_light);
    }

    public boolean isDarkMode() {
        return isDarkMode;
    }

    public void saveTheme() {
        SharedPreferences sharedPreferences = getSharedPreferences(THEME_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean(KEY_THEME_UPDATE, isDarkMode);

        editor.apply();
    }

    public void loadTheme() {
        SharedPreferences sharedPreferences = getSharedPreferences(THEME_PREFS, MODE_PRIVATE);
        isDarkMode = sharedPreferences.getBoolean(KEY_THEME_UPDATE, true);
    }

    public void updateView() {
        if (isDarkMode) {
            darkMode();
        } else if (!isDarkMode) {
            lightMode();
        }
    }
}

