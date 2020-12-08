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
        TextView displayed = binding.textView;
        TextView displayed2 = binding.textView2;
        switch(v.getId()){
            // light mode
            case R.id.buttonClear:
                if(lightMod){
                    displayed.setTextColor(Color.parseColor("#282828"));
                    displayed2.setTextColor(Color.parseColor("#282828"));

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
                    displayed2.setTextColor(Color.parseColor("#FFFFFF"));

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

    private char operatorSet = '\0';

    public void onClickNumbering(View v){
        textView = binding.textView;
        String displayNumber = textView.getText().toString();
        // change size text number if length number is 12
        if(displayNumber.length() == 12){
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,62);
        }
        if(operatorSet != '\0'){
            displayNumber = "";
            operatorSet = '\0';
        }
        // force scroll to right
        HorizontalScrollView hrw = binding.hzw;
        hrw.fullScroll(View.FOCUS_RIGHT);

        HorizontalScrollView hrw2 = binding.hzw2;
        hrw2.fullScroll(View.FOCUS_RIGHT);
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



    private float value = 0f;
    // check operator for sum
    private char sumType;
    public void onClickOperator(View v){

        try {
           String text = textView.getText().toString();
           String text2 = binding.textView2.getText().toString();
            switch (v.getId()){
                case R.id.buttonClear:
                    textView.setText("");
                    binding.textView2.setText("");
                    break;

                case R.id.buttonAdd:
                    // checked last char for add symbol cannot duplicate in same times

//                    String lastChar = text.substring(text.length()-1);
//                    if(!lastChar.equals(" ")) {
                    binding.textView2.setText(text2 + text + " + ");
                    value += Float.parseFloat(text);
                    operatorSet = '+';
                    sumType = '+';
//                    }
                    break;

                case R.id.buttonSum:

                    switch (sumType){
                        case '+':
                            System.out.println(text);
                            value += Float.parseFloat(text);
                            textView.setText(String.valueOf(this.value));
                            operatorSet = '+';
                            this.value = 0;
                    }
                    break;

                default:
                    break;
            }
        }catch (Exception e){}
    }


}

