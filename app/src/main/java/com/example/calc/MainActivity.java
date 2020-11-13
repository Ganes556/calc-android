package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;


public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    private  ConstraintLayout constlay;
    private Switch switchButton;
    // Switch control
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        // on switch had true
        boolean darkMode = isChecked;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        constlay = findViewById(R.id.constLay);
        switchButton = findViewById(R.id.switch1);

        switchButton.setOnCheckedChangeListener(this);
    }

}
