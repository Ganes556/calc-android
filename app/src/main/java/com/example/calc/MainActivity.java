package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;


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
            // switch Button
            switchButton.setText("Dark");
            switchButton.setBackgroundColor(Color.parseColor("#000000"));
            switchButton.setTextColor(Color.parseColor("#FFFFFF"));

            // constraint layout
            constlay.setBackgroundColor(Color.parseColor("#000000"));
        }else{
            // switch Button
            switchButton.setText("Light");
            switchButton.setTextColor(Color.parseColor("#000000"));
            switchButton.setBackgroundColor(Color.parseColor("#FFFFFF"));
            // constraint layout
            constlay.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }
    }

}
