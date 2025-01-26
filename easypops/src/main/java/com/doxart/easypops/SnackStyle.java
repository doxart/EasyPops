package com.doxart.easypops;

import android.content.Context;
import android.widget.RelativeLayout;

import androidx.core.content.ContextCompat;

public class SnackStyle {
    protected static int NOT_SET = -999999999;

    public static class Position {
        public static int TOP = RelativeLayout.ALIGN_PARENT_TOP;
        public static int BOTTOM = RelativeLayout.ALIGN_PARENT_BOTTOM;
    }

    public static SnackStyle SNACK_NORMAL(Context context) {
        int primary = ContextCompat.getColor(context, R.color.blat);
        int white = ContextCompat.getColor(context, R.color.white);
        return new SnackStyle(primary, white, white, Position.BOTTOM);
    }
    public static SnackStyle SNACK_ERROR(Context context) {
        int primary = ContextCompat.getColor(context, R.color.red);
        int white = ContextCompat.getColor(context, R.color.white);
        return new SnackStyle(primary, white, white, Position.BOTTOM);
    }
    public static SnackStyle SNACK_SUCCESS(Context context) {
        int primary = ContextCompat.getColor(context, R.color.green);
        int white = ContextCompat.getColor(context, R.color.white);
        return new SnackStyle(primary, white, white, Position.BOTTOM);
    }

    private int backgroundColor = NOT_SET;
    private int messageColor = NOT_SET;
    private int buttonColor = NOT_SET;
    private int position = NOT_SET;

    public SnackStyle() {}

    public SnackStyle(int backgroundColor, int messageColor, int buttonColor, int position) {
        this.backgroundColor = backgroundColor;
        this.messageColor = messageColor;
        this.buttonColor = buttonColor;
        this.position = position;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public int getMessageColor() {
        return messageColor;
    }

    public void setMessageColor(int messageColor) {
        this.messageColor = messageColor;
    }

    public int getButtonColor() {
        return buttonColor;
    }

    public void setButtonColor(int buttonColor) {
        this.buttonColor = buttonColor;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
