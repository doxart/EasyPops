package com.doxart.easypops;

import android.util.Log;

public class DatePickerStyle {
    protected static int NOT_SET = -999999999;

    private int backgroundColor = NOT_SET;
    private int titleColor = NOT_SET;
    private int messageColor = NOT_SET;
    private int positiveButtonColor = NOT_SET;
    private int positiveButtonTextColor = NOT_SET;
    private int negativeButtonColor = NOT_SET;
    private int negativeButtonTextColor = NOT_SET;

    public DatePickerStyle() {}

    public DatePickerStyle(int backgroundColor, int titleColor, int messageColor, int positiveButtonColor, int positiveButtonTextColor, int negativeButtonColor, int negativeButtonTextColor) {
        this.backgroundColor = backgroundColor;
        this.titleColor = titleColor;
        this.messageColor = messageColor;
        this.positiveButtonColor = positiveButtonColor;
        this.positiveButtonTextColor = positiveButtonTextColor;
        this.negativeButtonColor = negativeButtonColor;
        this.negativeButtonTextColor = negativeButtonTextColor;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public int getTitleColor() {
        return titleColor;
    }

    public void setTitleColor(int titleColor) {
        this.titleColor = titleColor;
    }

    public int getMessageColor() {
        return messageColor;
    }

    public void setMessageColor(int messageColor) {
        this.messageColor = messageColor;
    }

    public int getPositiveButtonColor() {
        return positiveButtonColor;
    }

    public void setPositiveButtonColor(int positiveButtonColor) {
        this.positiveButtonColor = positiveButtonColor;
    }

    public int getPositiveButtonTextColor() {
        return positiveButtonTextColor;
    }

    public void setPositiveButtonTextColor(int positiveButtonTextColor) {
        this.positiveButtonTextColor = positiveButtonTextColor;
    }

    public int getNegativeButtonColor() {
        return negativeButtonColor;
    }

    public void setNegativeButtonColor(int negativeButtonColor) {
        this.negativeButtonColor = negativeButtonColor;
    }

    public int getNegativeButtonTextColor() {
        return negativeButtonTextColor;
    }

    public void setNegativeButtonTextColor(int negativeButtonTextColor) {
        this.negativeButtonTextColor = negativeButtonTextColor;
    }
}
