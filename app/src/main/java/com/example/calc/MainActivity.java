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

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {
    ActivityMainBinding binding;
    // variable used in many function
    private ConstraintLayout constlay;
    private LinearLayout boardOfBtn;
    private TextView inputOutput;
    private TextView operatorView;
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

//    private boolean operatorNonKomulatif;
    public void onClickNumbering(View v){
        inputOutput = binding.textView;
        operatorView = binding.textView2;

        String displayNumber = inputOutput.getText().toString();
        // change size text number if length number is 12
        if(displayNumber.length() == 12){
            inputOutput.setTextSize(TypedValue.COMPLEX_UNIT_SP,62);
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
                if(displayNumber.equals("0")){
                    displayNumber = "";
                }
                inputOutput.setText(displayNumber + i);
                break;
            }
            if(v.getId() == R.id.buttonComma && !displayNumber.contains(".")){
                inputOutput.setText(displayNumber + ".");
                break;
            }

        }
    }




    // check operator for sum
    private double num,ans;
    private char sumType;
    public void onClickOperator(View v){

        try {
           String textInputOutput = inputOutput.getText().toString();
           String textOperator = operatorView.getText().toString();
            switch (v.getId()){
                case R.id.buttonClear:
                    inputOutput.setText("0");
                    operatorView.setText("");
                    break;
                case R.id.buttonDelete:
                    int length = textInputOutput.length();
                    int number = length-1;

                    if(length > 1){
                        StringBuilder willDelete = new StringBuilder(textInputOutput);
                        willDelete.deleteCharAt(number);
                        String store = willDelete.toString();
                        inputOutput.setText(store);
                    }else if(length == 1){
                        inputOutput.setText("0");
                    }
                    break;

                case R.id.buttonAdd:
                    // checked last char for add symbol cannot duplicate in same times
                    num = Double.parseDouble(textInputOutput);
                    inputOutput.setText("");
                    operatorView.setText(textOperator + textInputOutput + " + ");
                    operatorSet = '+';
                    sumType = '+';
                    break;
                case R.id.buttonSubtract:
                    num = Double.parseDouble(textInputOutput);
                    inputOutput.setText("");
                    operatorView.setText(textOperator + textInputOutput + " - ");
                    operatorSet = '-';
                    sumType = '-';
                    break;
                case R.id.buttonMultiple:
                    num = Double.parseDouble(textInputOutput);
                    inputOutput.setText("");
                    operatorView.setText(textOperator + textInputOutput + " * ");
                    operatorSet = '*';
                    sumType = '*';
                    break;
                case R.id.buttonDivide:
                    num = Double.parseDouble(textInputOutput);
                    inputOutput.setText("");
                    operatorView.setText(textOperator + textInputOutput + " " + '\u00F7' + " ");
                    operatorSet = '/';
                    sumType = '/';
                    break;

                case R.id.buttonPercent:
                    num = Double.parseDouble(textInputOutput)*0.01;

                    inputOutput.setText(textOperator + String.format("%.2f", num).replace(',','.'));
                    operatorSet = '%';
                    sumType = '%';
                    break;

                case R.id.buttonSum:
                    switch (sumType){
                        case '+':
                            ans = num + Double.parseDouble(textInputOutput);
                            if(textOperator.contains(".")){
                                inputOutput.setText(Double.toString(ans));
                            }else{
                                int sumInteger = (int) ans;
                                inputOutput.setText(Integer.toString(sumInteger));
                            }

//                            inputOutput.setText(String.valueOf(this.value));
                            operatorView.setText("");
                            operatorSet = '+';
                            break;

                        case '-':
                            ans = num - Double.parseDouble(textInputOutput);
                            if(textOperator.contains(".")){
                                inputOutput.setText(Double.toString(ans));
                            }else{
                                int sumInteger = (int) ans;
                                inputOutput.setText(Integer.toString(sumInteger));
                            }
                            operatorView.setText("");
                            operatorSet = '-';
                            break;
                        case '*':
                            ans = num * Double.parseDouble(textInputOutput);
                            if(textOperator.contains(".")){
                                inputOutput.setText(Double.toString(ans));
                            }else{
                                int sumInteger = (int) ans;
                                inputOutput.setText(Integer.toString(sumInteger));
                            }
                            operatorView.setText("");
                            operatorSet = '*';
                            break;

                        case '/':
                            ans = num / Double.parseDouble(textInputOutput);
                            if(textOperator.contains(".") || Double.toString(ans).contains(".")){
                                inputOutput.setText(Double.toString(ans));
                            }else{
                                int sumInteger = (int) ans;
                                inputOutput.setText(Integer.toString(sumInteger));
                            }
                            operatorView.setText("");
                            operatorSet = '/';
                            break;

                    }
                    break;
                default:
                    break;
            }
        }catch (Exception e){}
    }


}

