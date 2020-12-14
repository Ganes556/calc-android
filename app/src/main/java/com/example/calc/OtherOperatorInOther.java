package com.example.calc;

public class OtherOperatorInOther {
    private char operator;
    private double num,num1;

    double getResult(char operator,double num,double num1){
        this.operator = operator;
        double result;

        switch (operator){
            case '+':
                result = num + num1;
                break;
            case '-':
                result = num - num1;
                break;
            case '*':
                result = num * num1;
                break;
            case '/':
                result = num / num1;
                break;
            default:
                result = num1;
                break;
        }
        return result;
    }

}
