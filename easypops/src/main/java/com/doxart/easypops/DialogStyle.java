package com.doxart.easypops;

import android.content.Context;

import androidx.core.content.ContextCompat;

import com.doxart.easypops.databinding.DialogViewBinding;

public class DialogStyle {
    protected static int NOT_SET = -999999999;

    private int backgroundColor = NOT_SET;
    private int titleColor = NOT_SET;
    private int messageColor = NOT_SET;
    private int positiveButtonColor = NOT_SET;
    private int positiveButtonTextColor = NOT_SET;
    private int negativeButtonColor = NOT_SET;
    private int negativeButtonTextColor = NOT_SET;
    private boolean downloadProgressVisible = false;
    private int progressColor = NOT_SET;
    private int progressTextColor = NOT_SET;
    private int progressBackgroundColor = NOT_SET;

    public static DialogStyle Default_Dialog() {
        return new DialogStyle();
    }

    public static DialogStyle Error_Dialog(Context context) {
        int primary = ContextCompat.getColor(context, R.color.red);
        int white = ContextCompat.getColor(context, R.color.white);
        int black = ContextCompat.getColor(context, R.color.black);
        DialogStyle dialogStyle = new DialogStyle();

        dialogStyle.setBackgroundColor(primary);
        dialogStyle.setTitleColor(white);
        dialogStyle.setMessageColor(white);
        dialogStyle.setPositiveButtonColor(white);
        dialogStyle.setPositiveButtonTextColor(black);
        dialogStyle.setNegativeButtonTextColor(white);

        return dialogStyle;
    }

    public static DialogStyle Success_Dialog(Context context) {
        int primary = ContextCompat.getColor(context, R.color.green);
        int white = ContextCompat.getColor(context, R.color.white);
        int black = ContextCompat.getColor(context, R.color.black);
        DialogStyle dialogStyle = new DialogStyle();

        dialogStyle.setBackgroundColor(primary);
        dialogStyle.setTitleColor(white);
        dialogStyle.setMessageColor(white);
        dialogStyle.setPositiveButtonColor(white);
        dialogStyle.setPositiveButtonTextColor(black);
        dialogStyle.setNegativeButtonTextColor(white);

        return dialogStyle;
    }

    public static DialogStyle Download_Dialog(Context context) {
        int primary = ContextCompat.getColor(context, R.color.green);
        int white = ContextCompat.getColor(context, R.color.white);
        int black = ContextCompat.getColor(context, R.color.black);
        DialogStyle dialogStyle = new DialogStyle();

        dialogStyle.setDownloadProgressVisible(true);

        return dialogStyle;
    }

    public DialogStyle() {}

    public DialogStyle(int backgroundColor, int titleColor, int messageColor, int positiveButtonColor, int positiveButtonTextColor, int negativeButtonColor, int negativeButtonTextColor) {
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

    public boolean isDownloadProgressVisible() {
        return downloadProgressVisible;
    }

    public void setDownloadProgressVisible(boolean downloadProgressVisible) {
        this.downloadProgressVisible = downloadProgressVisible;
    }

    public void setProgressMode() {
        this.downloadProgressVisible = true;
    }

    public int getProgressColor() {
        return progressColor;
    }

    public void setProgressColor(int progressColor) {
        this.progressColor = progressColor;
    }

    public int getProgressTextColor() {
        return progressTextColor;
    }

    public void setProgressTextColor(int progressTextColor) {
        this.progressTextColor = progressTextColor;
    }

    public int getProgressBackgroundColor() {
        return progressBackgroundColor;
    }

    public void setProgressBackgroundColor(int progressBackgroundColor) {
        this.progressBackgroundColor = progressBackgroundColor;
    }

    public static void setDialogStyle(Context context, DialogViewBinding b, int style) {
        switch (style)
        {
            case -1:
                b.askTitle.setTextColor(ContextCompat.getColor(context, R.color.red));
                b.askPositive.setBackgroundColor(ContextCompat.getColor(context, R.color.red));
                break;
            case 1:
                b.askTitle.setTextColor(ContextCompat.getColor(context, R.color.green));
                b.askPositive.setBackgroundColor(ContextCompat.getColor(context, R.color.green));
                break;
        }
    }
}
