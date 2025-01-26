package com.doxart.easypops;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;

public class EasyPopup {
    private static Dialog currentPop;

    protected static void setCurrentPop(Dialog currentPop) {
        if (getCurrentPop() != null && getCurrentPop().isShowing()) getCurrentPop().cancel();
        show(currentPop);
    }

    protected static void show(Dialog currentPop) {
        EasyPopup.currentPop = currentPop;
    }

    protected static void clearCurrentPop() {
        if (currentPop != null && currentPop.isShowing()) currentPop.cancel();
        currentPop = null;
    }

    public static Dialog getCurrentPop() {
        return currentPop;
    }

    //Progress Start

    public static ProgressPop.Builder createProgress(Activity activity) {
        return new ProgressPop.Builder(activity);
    }

    //Progress End

    //Snack Start

    public static SnackPop.Builder createSnack(Activity activity) {
        return new SnackPop.Builder(activity);
    }

    //Snack End

    //DatePicker Start

    public static DatePickerPop.Builder createDatePicker(Context context) {
        return new DatePickerPop.Builder(context);
    }

    //DatePicker End

    //Dialog Start

    public static DialogPop.Builder createDialog(Activity activity) {
        return new DialogPop.Builder(activity);
    }
}
