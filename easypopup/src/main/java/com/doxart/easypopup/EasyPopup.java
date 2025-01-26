package com.doxart.easypopup;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.doxart.easypopup.databinding.CustomSnackbarBinding;

public class EasyPopup {
    //Progress Start
    public static Dialog progress;

    public static Dialog getProgress() {
        return progress;
    }

    public static void setProgress(Dialog progress) {
        EasyPopup.progress = progress;
    }

    public static void cancelProgress() {
        if (progress != null && progress.isShowing()) {
            progress.cancel();
            progress = null;
        }
    }

    public static Dialog setProgress(Activity context){
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.progress_view);
        if (dialog.getWindow() != null) dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        dialog.setCancelable(false);

        dialog.show();

        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        if (dialog.getWindow() != null) {
            layoutParams.copyFrom(dialog.getWindow().getAttributes());
            layoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
            layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
            dialog.getWindow().setAttributes(layoutParams);

            dialog.getWindow().setBackgroundDrawableResource(R.drawable.alert_dialog_background);
        }

        if (!context.isFinishing() && !context.isDestroyed()) {
            EasyPopup.cancelProgress();
        }

        EasyPopup.setProgress(dialog);

        return dialog;
    }

    public static Dialog setProgress(Activity context, long closeAfterDelay){
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.progress_view);
        if (dialog.getWindow() != null) dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        dialog.setCancelable(false);

        dialog.show();

        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        if (dialog.getWindow() != null) {
            layoutParams.copyFrom(dialog.getWindow().getAttributes());
            layoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
            layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
            dialog.getWindow().setAttributes(layoutParams);

            dialog.getWindow().setBackgroundDrawableResource(R.drawable.alert_dialog_background);
        }

        if (!context.isFinishing() && !context.isDestroyed()) {
            EasyPopup.cancelProgress();
        }

        EasyPopup.setProgress(dialog);

        new Handler().postDelayed(EasyPopup::cancelProgress, closeAfterDelay);

        return dialog;
    }

    //Progress End

    //Snack Start

    public static Dialog showSnack(Activity context, int style, String text, String button, SnackbarButtonClickListener snackbarButtonClickListener) {
        try {
            Dialog dialog = new Dialog(context);

            View view = LayoutInflater.from(context).inflate(R.layout.custom_snackbar, null);
            CustomSnackbarBinding b = CustomSnackbarBinding.bind(view);

            dialog.setContentView(b.getRoot());
            if (dialog.getWindow() != null) dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            dialog.setCancelable(true);

            dialog.show();

            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            if (dialog.getWindow() != null) {
                layoutParams.copyFrom(dialog.getWindow().getAttributes());
                layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
                layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT;
                dialog.getWindow().setAttributes(layoutParams);

                dialog.getWindow().setBackgroundDrawableResource(R.drawable.alert_dialog_transparent_background);
            }

            if (!context.isFinishing() && !context.isDestroyed()) {
                dialog.dismiss();
            }

            SnackStyle.setSnackStyle(context, b, style);

            b.snackText.setSelected(true);
            b.snackText.setText(text);

            if (!button.isEmpty()) b.snackCloseBt.setText(button);

            b.getRoot().setOnClickListener(v -> {
                dialog.cancel();
            });

            b.snackCloseBt.setOnClickListener(v -> {
                if (snackbarButtonClickListener != null) snackbarButtonClickListener.onClick();
                dialog.cancel();
            });

            new Handler().postDelayed(() -> {
                dialog.cancel();
                if (snackbarButtonClickListener != null) snackbarButtonClickListener.onTimesUp();
            }, 10000);

            return dialog;
        } catch (Exception e) {
            Log.d("SnackChallenge", "showSnack: " + e.getMessage());
            return null;
        }
    }

    //Snack End
}
