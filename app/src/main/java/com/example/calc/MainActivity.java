package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.HorizontalScrollView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener{
    // variable used in many function
    private  ConstraintLayout constlay;
    private Switch switchButton;
    private TextView textView;

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
    public void onClick(View v) {
        textView = findViewById(R.id.textView);
//        for (int i = 0; i < 10;) {
//            int id = getResources().getIdentifier("button"+i, "id", getPackageName());
//            Button button = findViewById(id);
//            textView.setText(button.getText());
//            i++;
//        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        constlay = findViewById(R.id.constLay);
        switchButton = findViewById(R.id.switch1);
        switchButton.setOnCheckedChangeListener(this);

    }
    public void onClickNumbering(View v){
        textView = findViewById(R.id.textView);
        String displayNumber = textView.getText().toString();
        // force scroll to right
        HorizontalScrollView hrw = findViewById(R.id.hzw);
        hrw.fullScroll(View.FOCUS_RIGHT);
        // numbering button had a same behavior
        for (int i = 0; i < 10;) {
            int id = getResources().getIdentifier("button"+i, "id", getPackageName());
            if(v.getId() == id){
                textView.setText(displayNumber + i);
                break;
            }
            if(v.getId() == R.id.buttonComma){
                textView.setText(displayNumber + ".");
                break;
            }
            i++;
        }
    }
    // next build click for all operator adding
    public void onClickOperator(View v){

    }


}

