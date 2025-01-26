package com.doxart.easypops;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.NonNull;

import com.doxart.easypops.databinding.DialogViewBinding;

public class DialogPop extends Dialog {
    public DialogPop(@NonNull Context context) {
        super(context);
    }

    @Override
    public void show() {
        super.show();
        EasyPopup.setCurrentPop(this);
    }

    @Override
    public void cancel() {
        super.cancel();
    }

    public static class Builder {
        private Activity activity;
        private DialogPop dialogPop;
        private DialogViewBinding b;
        private OnDialogAnswerListener onDialogListener;

        protected Builder(@NonNull Activity activity) {
            this.activity = activity;
            b = DialogViewBinding.bind(LayoutInflater.from(activity).inflate(R.layout.dialog_view, null));
        }

        public DialogPop build() {
            dialogPop = new DialogPop(activity);
            dialogPop.setContentView(b.getRoot());
            if (dialogPop.getWindow() != null) dialogPop.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            dialogPop.setCancelable(false);

            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            if (dialogPop.getWindow() != null) {
                layoutParams.copyFrom(dialogPop.getWindow().getAttributes());
                layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
                layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
                dialogPop.getWindow().setAttributes(layoutParams);

                dialogPop.getWindow().setBackgroundDrawableResource(R.drawable.alert_dialog_transparent_background);
            }

            if (!activity.isFinishing() && !activity.isDestroyed()) {
                dialogPop.cancel();
            }

            b.askPositive.setOnClickListener(v -> {
                dialogPop.cancel();
                if (onDialogListener != null) {
                    onDialogListener.onPositive();
                }
            });

            b.askNegative.setOnClickListener(v -> {
                dialogPop.cancel();
                if (onDialogListener != null) {
                    onDialogListener.onNegative();
                }
            });

            b.askOther.setOnClickListener(v -> {
                dialogPop.cancel();
                if (onDialogListener != null) {
                    onDialogListener.onLater();
                }
            });

            return dialogPop;
        }

        public DialogPop buildAndShow() {
            dialogPop = new DialogPop(activity);
            dialogPop.setContentView(b.getRoot());
            if (dialogPop.getWindow() != null) dialogPop.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            dialogPop.setCancelable(false);

            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            if (dialogPop.getWindow() != null) {
                layoutParams.copyFrom(dialogPop.getWindow().getAttributes());
                layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
                layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
                dialogPop.getWindow().setAttributes(layoutParams);

                dialogPop.getWindow().setBackgroundDrawableResource(R.drawable.alert_dialog_transparent_background);
            }

            if (!activity.isFinishing() && !activity.isDestroyed()) {
                dialogPop.cancel();
            }

            b.askPositive.setOnClickListener(v -> {
                dialogPop.cancel();
                if (onDialogListener != null) {
                    onDialogListener.onPositive();
                }
            });

            b.askNegative.setOnClickListener(v -> {
                dialogPop.cancel();
                if (onDialogListener != null) {
                    onDialogListener.onNegative();
                }
            });

            b.askOther.setOnClickListener(v -> {
                dialogPop.cancel();
                if (onDialogListener != null) {
                    onDialogListener.onLater();
                }
            });

            try {
                dialogPop.show();
            } catch (Exception e) {
                Log.e("DialogPop", "buildAndShow: " + e.getMessage());
            }

            return dialogPop;
        }

        public Builder setDialogStyle(DialogStyle dialogStyle) {
            if (dialogStyle.getBackgroundColor() != DialogStyle.NOT_SET) b.askBG.setCardBackgroundColor(dialogStyle.getBackgroundColor());
            if (dialogStyle.getTitleColor() != DialogStyle.NOT_SET) b.askTitle.setTextColor(dialogStyle.getTitleColor());
            if (dialogStyle.getMessageColor() != DialogStyle.NOT_SET) b.askContain.setTextColor(dialogStyle.getMessageColor());
            if (dialogStyle.getPositiveButtonColor() != DialogStyle.NOT_SET) b.askPositive.setBackgroundColor(dialogStyle.getPositiveButtonColor());
            if (dialogStyle.getPositiveButtonTextColor() != DialogStyle.NOT_SET) b.askPositive.setTextColor(dialogStyle.getPositiveButtonTextColor());
            if (dialogStyle.getNegativeButtonColor() != DialogStyle.NOT_SET) b.askNegative.setBackgroundColor(dialogStyle.getNegativeButtonColor());
            if (dialogStyle.getNegativeButtonTextColor() != DialogStyle.NOT_SET) b.askNegative.setTextColor(dialogStyle.getNegativeButtonTextColor());
            return this;
        }

        public Builder setBackgroundColor(int backgroundColor) {
            b.askBG.setCardBackgroundColor(backgroundColor);
            return this;
        }

        public Builder setTitle(String title) {
            b.askTitle.setText(title);
            return this;
        }

        public Builder setTitleColor(int titleColor) {
            b.askTitle.setTextColor(titleColor);
            return this;
        }

        public Builder setMessage(String message) {
            b.askContain.setText(message);
            return this;
        }

        public Builder setMessageColor(int messageColor) {
            b.askContain.setTextColor(messageColor);
            return this;
        }

        public Builder setPositiveButtonText(String positiveButtonText) {
            b.askPositive.setText(positiveButtonText);
            return this;
        }

        public Builder setPositiveButtonColor(int positiveButtonColor) {
            b.askPositive.setBackgroundColor(positiveButtonColor);
            return this;
        }

        public Builder setPositiveButtonTextColor(int positiveButtonTextColor) {
            b.askPositive.setTextColor(positiveButtonTextColor);
            return this;
        }

        public Builder setNegativeButtonText(String negativeButtonText) {
            b.askNegative.setText(negativeButtonText);
            return this;
        }

        public Builder setNegativeButtonColor(int negativeButtonColor) {
            b.askNegative.setBackgroundColor(negativeButtonColor);
            return this;
        }

        public Builder setNegativeButtonTextColor(int negativeButtonTextColor) {
            b.askNegative.setTextColor(negativeButtonTextColor);
            return this;
        }

        public Builder setOnDialogAnswerListener(OnDialogAnswerListener onDialogListener) {
            this.onDialogListener = onDialogListener;
            return this;
        }
    }
}
