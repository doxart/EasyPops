package com.doxart.easypopup;

import android.content.Context;

import androidx.core.content.ContextCompat;

import com.doxart.easywallet.R;
import com.doxart.easywallet.databinding.DialogViewBinding;

public class DialogStyle {
    public static int DIALOG_NORMAL = 0;
    public static int DIALOG_ERROR = -1;
    public static int DIALOG_SUCCESS = 1;

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
