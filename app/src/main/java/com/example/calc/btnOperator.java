package com.example.calc;


import android.content.Context;
import android.view.View;



public class btnOperator implements View.OnClickListener {
    private Context Activity;

    btnOperator (Context activity){
        this.Activity = activity;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.buttonClear:

        }
    }
}
