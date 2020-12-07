package com.example.calc;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calc.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {
    ActivityMainBinding binding;
    // variable used in many function
    private ConstraintLayout constlay;
    private LinearLayout boardOfBtn;
    private TextView textView;
    private boolean lightMod = true;

    private Button btnClear;
    private Button btnDelete;
    private Button btnPercent;
    private Button btnMultiple;
    private Button btnDivide;
    private Button btnSubtract;
    private Button btnAdd;
    private Button btnSum;

    @Override
    public boolean onLongClick(View v) {
        TextView displayed = findViewById(R.id.textView);

        switch(v.getId()){
            // light mode
            case R.id.buttonClear:
                if(lightMod){
                    displayed.setTextColor(Color.parseColor("#282828"));

                    btnClear.setBackgroundResource(R.drawable.ellipse_purple);
                    btnDelete.setBackgroundResource(R.drawable.ellipse_purple);
                    btnPercent.setBackgroundResource(R.drawable.ellipse_purple);
                    btnMultiple.setBackgroundResource(R.drawable.ellipse_purple);
                    btnSubtract.setBackgroundResource(R.drawable.ellipse_purple);
                    btnDivide.setBackgroundResource(R.drawable.ellipse_purple);
                    btnAdd.setBackgroundResource(R.drawable.ellipse_purple);

                    btnSum.setBackgroundResource(R.drawable.purple_sum);
//                    btnClear.setBackground(ContextCompat.getDrawable(MainActivity.this,R.drawable.ellipse_purple));
                    constlay.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    boardOfBtn.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    this.lightMod = false;
                }else{
                    displayed.setTextColor(Color.parseColor("#FFFFFF"));

                    btnClear.setBackground(ContextCompat.getDrawable(MainActivity.this,R.drawable.ellipse_yellow));
                    btnDelete.setBackgroundResource(R.drawable.ellipse_yellow);
                    btnPercent.setBackgroundResource(R.drawable.ellipse_yellow);
                    btnMultiple.setBackgroundResource(R.drawable.ellipse_yellow);
                    btnSubtract.setBackgroundResource(R.drawable.ellipse_yellow);
                    btnDivide.setBackgroundResource(R.drawable.ellipse_yellow);
                    btnAdd.setBackgroundResource(R.drawable.ellipse_yellow);

                    btnSum.setBackgroundResource(R.drawable.yellow_sum);
                    constlay.setBackgroundColor(Color.parseColor("#2B2B2B"));
                    boardOfBtn.setBackgroundColor(Color.parseColor("#2B2B2B"));
                    this.lightMod = true;
                }

                break;

        }
        return false;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        constlay = binding.constLay;
        boardOfBtn = binding.boardBtn;

        btnClear = binding.buttonClear;

        btnDelete = binding.buttonDelete;
        btnDivide = binding.buttonDivide;
        btnPercent = binding.buttonPercent;
        btnAdd = binding.buttonAdd;
        btnSubtract = binding.buttonSubtract;
        btnMultiple = binding.buttonMultiple;

        btnSum = binding.buttonSum;
        btnClear.setOnLongClickListener(this);






//        buttonClear.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                Toast.makeText(MainActivity.this, "Background Dark Theme", Toast.LENGTH_LONG).show();
//                return true;
//            }
//        });

    }


    public void onClickNumbering(View v){
        textView = binding.textView;
        String displayNumber = textView.getText().toString();
        // change size text number if length number is 12
        if(displayNumber.length() == 12){
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,36);
        }
        // force scroll to right
        HorizontalScrollView hrw = binding.hzw;
        hrw.fullScroll(View.FOCUS_RIGHT);
        // numbering button had a same behavior
        for (int i = 0; i < 10; i++) {
            int id = getResources().getIdentifier("button"+i, "id", getPackageName());
            if(v.getId() == id){
                textView.setText(displayNumber + i);
                break;
            }
            if(v.getId() == R.id.buttonComma){
                textView.setText(displayNumber + ".");
                break;
            }

        }
    }


    // next build click for all operator adding
    public void onClickOperator(View v){
        String text = textView.getText().toString();
        switch (v.getId()){
            case R.id.buttonClear:
                textView.setText("");
                break;
            case R.id.buttonAdd:
                // checked last char for add symbol cannot duplicate in same times
                String lastChar = text.substring(text.length()-1);
                if(!lastChar.equals(" ")) {
                    textView.setText(text + " + ");
                }
                break;
            case R.id.buttonSum:
                System.out.println(text.length());
                break;
        }
    }


}

