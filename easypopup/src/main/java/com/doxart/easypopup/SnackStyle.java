package com.doxart.easypopup;

import android.content.Context;

import androidx.core.content.ContextCompat;

import com.doxart.easypopup.databinding.CustomSnackbarBinding;

public class SnackStyle {
    public static int SNACK_NORMAL = 0;
    public static int SNACK_ERROR = -1;
    public static int SNACK_SUCCESS = 1;

    private int backgroundColor;
    private int messageColor;
    private int buttonColor;

    public SnackStyle(int backgroundColor, int messageColor, int buttonColor) {
        this.backgroundColor = backgroundColor;
        this.messageColor = messageColor;
        this.buttonColor = buttonColor;
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

    public static void setSnackStyle(Context context, CustomSnackbarBinding b, int style) {
        switch (style)
        {
            case -1:
                b.snackBg.setCardBackgroundColor(ContextCompat.getColor(context, R.color.red));
                break;
            case 1:
                b.snackBg.setCardBackgroundColor(ContextCompat.getColor(context, R.color.green));
                break;
        }
    }
}
