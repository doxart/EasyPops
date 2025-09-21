package com.doxart.easypops;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.util.Log;

public class EasyPopup {
    private static final String TAG = "EasyPopup";
    private static final String ACTION_CANCEL_PROGRESS_RESULT_NULL_POP = "Current popup is not found!";
    private static final String ACTION_CANCEL_PROGRESS_RESULT_NOT_SHOWING = "Current popup is not showing!";
    private static final String ACTION_CANCEL_PROGRESS_RESULT_SUCCESS = "Success!";

    private static Dialog currentPop;

    protected static void setCurrentPop(Dialog currentPop) {
        if (getCurrentPop() != null && getCurrentPop().isShowing()) getCurrentPop().cancel();
        show(currentPop);
    }

    protected static void show(Dialog currentPop) {
        EasyPopup.currentPop = currentPop;
    }

    protected static void clearCurrentPop() {
        currentPop = null;
    }

    public static Dialog getCurrentPop() {
        if (currentPop == null) Log.e(TAG, "getCurrentPop: ", new Exception(ACTION_CANCEL_PROGRESS_RESULT_NULL_POP));
        return currentPop;
    }
    public static String cancelCurrentPop() {
        if (currentPop == null) {
            Log.e(TAG, "cancelCurrentPop: ", new Exception(ACTION_CANCEL_PROGRESS_RESULT_NULL_POP));
            return ACTION_CANCEL_PROGRESS_RESULT_NULL_POP;
        }
        if (!currentPop.isShowing()) {
            Log.e(TAG, "cancelCurrentPop: ", new Exception(ACTION_CANCEL_PROGRESS_RESULT_NOT_SHOWING));
            return ACTION_CANCEL_PROGRESS_RESULT_NOT_SHOWING;
        }
        currentPop.cancel();
        clearCurrentPop();
        return ACTION_CANCEL_PROGRESS_RESULT_SUCCESS;
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

    //Dialog End
}
