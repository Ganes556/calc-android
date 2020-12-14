package com.example.calc;

public class ThemeSwitch {
    private boolean toLightMode = true;

    public boolean isToLightMode(){
        return this.toLightMode;
    }
    public void isToDarkMode(boolean toDarkMode){
        this.toLightMode = toDarkMode;
    }
}
