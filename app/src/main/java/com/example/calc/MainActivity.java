package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.RelativeLayout;

import static com.example.calc.R.color.darkModeBG;
import static com.example.calc.R.color.darkModeText;
import static com.example.calc.R.color.lightModeBG;
import static com.example.calc.R.color.lightModeText;
import static com.example.calc.R.drawable;

import com.example.calc.databinding.ActivityMainBinding;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;


public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {
    ActivityMainBinding binding;
    // layout var
    private RelativeLayout bgMain;
    private RelativeLayout boardOfBtn;

    // textView var
    private AppCompatTextView inputOutput;
    private AppCompatTextView operatorView;

    // called class ThemeSwitch
    private final ThemeSwitch themeSwitch = new ThemeSwitch();

    // button operator var
    private AppCompatButton btnClear;
    private AppCompatButton btnDelete;
    private AppCompatButton btnPercent;
    private AppCompatButton btnMultiple;
    private AppCompatButton btnDivide;
    private AppCompatButton btnMinus;
    private AppCompatButton btnPlus;
    private AppCompatButton btnSum;

    // change theme code
    @Override
    public boolean onLongClick(View v) {

        switch(v.getId()){
            // light mode
            case R.id.btnC:
                if(themeSwitch.isToLightMode()){
                    themeSwitch.isToDarkMode(false);
                    bgMain.setBackgroundResource(lightModeBG);
                    inputOutput.setTextColor(getResources().getColor(lightModeText));
                    operatorView.setTextColor(getResources().getColor(lightModeText));
                    btnClear.setBackgroundResource(drawable.btn_outside_style_light);
                    btnDelete.setBackgroundResource(drawable.btn_outside_style_light);
                    btnPercent.setBackgroundResource(drawable.btn_outside_style_light);
                    btnMultiple.setBackgroundResource(drawable.btn_outside_style_light);
                    btnMinus.setBackgroundResource(drawable.btn_outside_style_light);
                    btnDivide.setBackgroundResource(drawable.btn_outside_style_light);
                    btnPlus.setBackgroundResource(drawable.btn_outside_style_light);
                    btnSum.setBackgroundResource(drawable.btn_equals_style_light);
                    binding.btn0.setBackgroundResource(drawable.btn_inside_style_light);
                    binding.btnComma.setBackgroundResource(drawable.btn_inside_style_light);
                    binding.btn1.setBackgroundResource(drawable.btn_inside_style_light);
                    binding.btn2.setBackgroundResource(drawable.btn_inside_style_light);
                    binding.btn3.setBackgroundResource(drawable.btn_inside_style_light);
                    binding.btn4.setBackgroundResource(drawable.btn_inside_style_light);
                    binding.btn5.setBackgroundResource(drawable.btn_inside_style_light);
                    binding.btn6.setBackgroundResource(drawable.btn_inside_style_light);
                    binding.btn7.setBackgroundResource(drawable.btn_inside_style_light);
                    binding.btn8.setBackgroundResource(drawable.btn_inside_style_light);
                    binding.btn9.setBackgroundResource(drawable.btn_inside_style_light);

                }else{
                    themeSwitch.isToDarkMode(true);
                    bgMain.setBackgroundResource(darkModeBG);
                    inputOutput.setTextColor(getResources().getColor(darkModeText));
                    operatorView.setTextColor(getResources().getColor(darkModeText));
                    btnClear.setBackgroundResource(drawable.btn_outside_style_dark);
                    btnDelete.setBackgroundResource(drawable.btn_outside_style_dark);
                    btnPercent.setBackgroundResource(drawable.btn_outside_style_dark);
                    btnMultiple.setBackgroundResource(drawable.btn_outside_style_dark);
                    btnMinus.setBackgroundResource(drawable.btn_outside_style_dark);
                    btnDivide.setBackgroundResource(drawable.btn_outside_style_dark);
                    btnPlus.setBackgroundResource(drawable.btn_outside_style_dark);
                    btnSum.setBackgroundResource(drawable.btn_equals_style_dark);
                    btnSum.setBackgroundResource(drawable.btn_equals_style_dark);
                    binding.btn0.setBackgroundResource(drawable.btn_inside_style_dark);
                    binding.btnComma.setBackgroundResource(drawable.btn_inside_style_dark);
                    binding.btn1.setBackgroundResource(drawable.btn_inside_style_dark);
                    binding.btn2.setBackgroundResource(drawable.btn_inside_style_dark);
                    binding.btn3.setBackgroundResource(drawable.btn_inside_style_dark);
                    binding.btn4.setBackgroundResource(drawable.btn_inside_style_dark);
                    binding.btn5.setBackgroundResource(drawable.btn_inside_style_dark);
                    binding.btn6.setBackgroundResource(drawable.btn_inside_style_dark);
                    binding.btn7.setBackgroundResource(drawable.btn_inside_style_dark);
                    binding.btn8.setBackgroundResource(drawable.btn_inside_style_dark);
                    binding.btn9.setBackgroundResource(drawable.btn_inside_style_dark);

                }

                break;

        }
        return false;
    }


    // main initial code
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        bgMain = binding.bgMain;
        boardOfBtn = binding.boardBtn;
        btnClear = binding.btnC;
        btnDelete = binding.btnDelete;
        btnDivide = binding.btnDivide;
        btnPercent = binding.btnPercent;
        btnPlus = binding.btnPlus;
        btnMinus = binding.btnMinus;
        btnMultiple = binding.btnMultiple;
        btnSum = binding.btnSum;
        btnClear.setOnLongClickListener(this);

    }

    // var for check mode operator
    private char operatorSet = '\0';

    // logic when clicking number
    public void onClickNumbering(View v){
        inputOutput = binding.textView;
        operatorView = binding.textView2;

        String displayNumber = inputOutput.getText().toString();
        // change size text number if length number is 12
//        if(displayNumber.length() == 12){
//            inputOutput.setTextSize(TypedValue.COMPLEX_UNIT_SP,62);
//        }

        //check if char have value
        if(operatorSet != '\0'){
            displayNumber = "";
            operatorSet = '\0';
        }

        // force scroll to right
        HorizontalScrollView hrw = binding.hzw;
        hrw.fullScroll(View.FOCUS_RIGHT);

        HorizontalScrollView hrw2 = binding.hzw2;
        hrw2.fullScroll(View.FOCUS_RIGHT);


        DecimalFormat dfDigit = new DecimalFormat("#,###");
        // numbering button had a same behavior
        for (int i = 0; i < 10; i++) {
            int id = getResources().getIdentifier("btn"+i, "id", getPackageName());
            if(v.getId() == id && !displayNumber.contains(",")){
                if(displayNumber.equals("0")){
                    displayNumber = "";
                }else if(displayNumber.contains(".")){
                    displayNumber = displayNumber.replace(".","");
                }
                inputOutput.setText(dfDigit.format(Long.parseLong(displayNumber + i)));
                break;
            }else if(v.getId() == id && displayNumber.contains(",")){
                if(displayNumber.equals("0")){
                    displayNumber = "";
                }
                inputOutput.setText(displayNumber + i);
                break;
            }
            //
            if(v.getId() == R.id.btnComma && !displayNumber.contains(",")){
                inputOutput.setText(displayNumber + ",");
                break;
            }


        }
    }




    // check operator for sum
    private double num,ans;
    private char sumType;
    private boolean sumInOperator = false;

    private final OtherOperatorInOther otherOperatorInOther = new OtherOperatorInOther();
    // logic for operator
    public void onClickOperator(View v){
        // try and catch for not have mistake
        try {
           String textInputOutput = inputOutput.getText().toString().replace(".","").replace(",",".");
           String textOperator = operatorView.getText().toString();
           DecimalFormat df = new DecimalFormat();
            switch (v.getId()){
                case R.id.btnC:
                    sumInOperator = false;
                    sumType = '\0';
                    ans = 0;
                    num = 0;
                    inputOutput.setText("0");
                    operatorView.setText("");
                    break;
                case R.id.btnDelete:
                    int length = inputOutput.getText().length();
                    int number = length-1;

                    if(length > 1){
                        StringBuilder willDelete = new StringBuilder(inputOutput.getText().toString());
                        willDelete.deleteCharAt(number);
                        String store = willDelete.toString();
                        inputOutput.setText(store);
                    }else if(length == 1){
                        sumInOperator = false;
                        sumType = '\0';
                        ans = 0;
                        num = 0;
                        inputOutput.setText("0");
                        operatorView.setText("");
                    }
                    break;

                case R.id.btnPlus:
                    // checked last char for add symbol cannot duplicate in same times

                    if(sumInOperator && sumType == '+'){
                        num += Double.parseDouble(textInputOutput);
                        inputOutput.setText(df.format(num));
                    }else if(sumType != '+'){
                        double result = otherOperatorInOther.getResult(sumType,num,Double.parseDouble(textInputOutput));
                        num = result;
                        inputOutput.setText(df.format(result));
                    }else{
                        sumInOperator = true;
                        num = Double.parseDouble(textInputOutput);
                    }
                    operatorView.setText(textOperator + textInputOutput.replace(".",",") + " + ");
                    operatorSet = '+';
                    sumType = '+';
                    break;
                case R.id.btnMinus:
//                    num = Double.parseDouble(textInputOutput);
                    if(sumInOperator && sumType == '-'){
                        num -= Double.parseDouble(textInputOutput);
                        inputOutput.setText(df.format(num));
                    }else if(sumType != '-'){
                        double result = otherOperatorInOther.getResult(sumType,num,Double.parseDouble(textInputOutput));
                        num = result;
                        inputOutput.setText(df.format(result));
                    }else{
                        sumInOperator = true;
                        num = Double.parseDouble(textInputOutput);
                    }

                    operatorView.setText(textOperator + textInputOutput.replace(".",",") + " - ");
                    operatorSet = '-';
                    sumType = '-';
                    break;
                case R.id.btnMultiple:
//                    num = Double.parseDouble(textInputOutput);
                    if(sumInOperator && sumType == '*'){
                        num *= Double.parseDouble(textInputOutput);
                        inputOutput.setText(df.format(num));
                    }else if(sumType != '*'){
                        double result = otherOperatorInOther.getResult(sumType,num,Double.parseDouble(textInputOutput));
                        num = result;
                        inputOutput.setText(df.format(result));
                    }else{
                        sumInOperator = true;
                        num = Double.parseDouble(textInputOutput);
                    }

                    // U+00D7 itu unicode dari x (kali)
                    operatorView.setText(textOperator + textInputOutput.replace(".",",") + " " + '\u00D7' + " ");
                    operatorSet = '*';
                    sumType = '*';
                    break;
                case R.id.btnDivide:
//                    num = Double.parseDouble(textInputOutput);
                    if(sumInOperator && sumType == '/'){
                        num /= Double.parseDouble(textInputOutput);
                        inputOutput.setText(df.format(num));
                    }else if(sumType != '+'){
                        double result = otherOperatorInOther.getResult(sumType,num,Double.parseDouble(textInputOutput));
                        num = result;
                        inputOutput.setText(df.format(result));
                    }else{
                        sumInOperator = true;
                        num = Double.parseDouble(textInputOutput);
                    }

                    // U+00F7 itu unicode dari / (bagi)
                    operatorView.setText(textOperator + textInputOutput.replace(".",",") + " " + '\u00F7' + " ");
                    operatorSet = '/';
                    sumType = '/';
                    break;

                case R.id.btnPercent:
                    num = Double.parseDouble(textInputOutput)*0.01;

                    inputOutput.setText(textOperator + String.format("%.2f", num));
                    operatorSet = '%';
                    sumType = '%';
                    break;

                // sum checked
                case R.id.btnSum:

                    switch (sumType){
                        case '+':
                            ans = num + Double.parseDouble(textInputOutput);
                            inputOutput.setText(df.format(ans));
                            operatorView.setText("");
                            operatorSet = '+';
                            break;

                        case '-':
                            ans = num - Double.parseDouble(textInputOutput);
                            inputOutput.setText(df.format(ans));
                            operatorView.setText("");
                            operatorSet = '-';
                            break;
                        case '*':
                            ans = num * Double.parseDouble(textInputOutput);
                            inputOutput.setText(df.format(ans));
                            operatorView.setText("");
                            operatorSet = '*';
                            break;

                        case '/':
                            ans = num / Double.parseDouble(textInputOutput);
                            inputOutput.setText(df.format(ans));
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

