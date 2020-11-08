package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void switch1(View view){
        Switch switchButton;
        ConstraintLayout constlay;

        constlay = (ConstraintLayout ) findViewById(R.id.constLay);
        switchButton = (Switch) findViewById(R.id.switch1);
        boolean darkMode = switchButton.isChecked();
        if(darkMode){
            switchButton.setText("Dark");
            constlay.setBackgroundColor(Color.parseColor("#000000"));
        }else{
            switchButton.setText("Light");
            constlay.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }
    }

}
