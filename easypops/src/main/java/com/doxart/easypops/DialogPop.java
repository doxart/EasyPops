package com.doxart.easypops;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.doxart.easypops.databinding.DialogViewBinding;
import com.google.android.material.progressindicator.LinearProgressIndicator;

public class DialogPop extends Dialog {
    private Dialog dialog;
    public DialogPop(@NonNull Context context) {
        super(context);
    }

    @Override
    public void show() {
        super.show();
        dialog = this;
        EasyPopup.setCurrentPop(this);
    }

    @Override
    public void cancel() {
        super.cancel();
    }

    public void setProgress(int progress) {
        LinearProgressIndicator linearProgressIndicator = dialog.findViewById(R.id.askProgress);
        TextView textView = dialog.findViewById(R.id.progressTxt);
        linearProgressIndicator.setProgress(progress);
        textView.setText(String.valueOf(progress));
    }

    public void setProgress(int progress, String value) {
        LinearProgressIndicator linearProgressIndicator = dialog.findViewById(R.id.askProgress);
        TextView textView = dialog.findViewById(R.id.progressTxt);
        linearProgressIndicator.setProgress(progress);
        textView.setText(value);
    }

    public static class Builder {
        private final Activity activity;
        private DialogPop dialogPop;
        private final DialogViewBinding b;
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
                if (!activity.isFinishing() && !activity.isDestroyed()) {
                    dialogPop.show();
                }
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
            if (dialogStyle.isDownloadProgressVisible()) {
                b.askPositive.setVisibility(ViewGroup.GONE);
                b.askProgress.setVisibility(ViewGroup.VISIBLE);
                if (dialogStyle.getProgressColor() != DialogStyle.NOT_SET) b.askProgress.setIndicatorColor(dialogStyle.getProgressColor());
                if (dialogStyle.getProgressTextColor() != DialogStyle.NOT_SET) b.askProgress.setIndicatorColor(dialogStyle.getProgressTextColor());
                if (dialogStyle.getProgressBackgroundColor() != DialogStyle.NOT_SET) b.askProgress.setIndicatorColor(dialogStyle.getProgressBackgroundColor());
            }
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

        public Builder setPositiveButtonClickListener(View.OnClickListener clickListener) {
            b.askPositive.setOnClickListener(clickListener);
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

        public Builder setNegativeButtonClickListener(View.OnClickListener clickListener) {
            b.askNegative.setOnClickListener(clickListener);
            return this;
        }

        public Builder setOtherButtonText(String otherButtonText) {
            b.askOther.setText(otherButtonText);
            return this;
        }

        public Builder setOtherButtonColor(int otherButtonColor) {
            b.askOther.setBackgroundColor(otherButtonColor);
            return this;
        }

        public Builder setOtherButtonTextColor(int otherButtonTextColor) {
            b.askOther.setTextColor(otherButtonTextColor);
            return this;
        }

        public Builder setOtherButtonClickListener(View.OnClickListener clickListener) {
            b.askOther.setOnClickListener(clickListener);
            return this;
        }

        public Builder setProgressColor(int progressColor) {
            b.askProgress.setIndicatorColor(progressColor);
            return this;
        }

        public Builder setProgressBackgroundColor(int progressBackgroundColor) {
            b.askProgress.setTrackColor(progressBackgroundColor);
            return this;
        }

        public Builder setProgressActive(boolean active) {
            if (active) {
                b.askPositive.setVisibility(ViewGroup.GONE);
                b.progressView.setVisibility(ViewGroup.VISIBLE);
                b.askOther.setVisibility(ViewGroup.GONE);
            } else {
                b.askPositive.setVisibility(ViewGroup.VISIBLE);
                b.progressView.setVisibility(ViewGroup.GONE);
            }
            return this;
        }

        public Builder setProgress(int progress) {
            b.askProgress.setProgress(progress);
            return this;
        }

        public Builder setProgressMax(int max) {
            b.askProgress.setMax(max);
            return this;
        }

        public Builder setProgressTargetTextColor(int color) {
            b.progressMaxTxt.setTextColor(color);
            return this;
        }

        public Builder setProgressTarget(String target) {
            b.progressMaxTxt.setText(target);
            return this;
        }

        public Builder setProgressTextColor(int color) {
            b.progressTxt.setTextColor(color);
            return this;
        }

        public Builder setProgressText(String txt) {
            b.progressTxt.setText(txt);
            return this;
        }

        public Builder setOnDialogAnswerListener(OnDialogAnswerListener onDialogListener) {
            this.onDialogListener = onDialogListener;
            return this;
        }
    }
}
