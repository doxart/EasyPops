package com.doxart.easypops;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;

import com.doxart.easypops.databinding.CustomSnackbarBinding;

public class SnackPop extends Dialog {
    public SnackPop(@NonNull Context context) {
        super(context);
    }

    @Override
    public void show() {
        super.show();
        EasyPopup.setCurrentPop(this);
    }

    @Override
    public void cancel() {
        EasyPopup.cancelCurrentPop();
    }

    public static class Builder {
        private Activity activity;
        private SnackPop snackPop;
        private CustomSnackbarBinding b;
        private SnackbarButtonClickListener snackbarButtonClickListener;

        private long autoCancelMillis = 0;

        protected Builder(@NonNull Activity activity) {
            this.activity = activity;
            b = CustomSnackbarBinding.bind(LayoutInflater.from(activity).inflate(R.layout.custom_snackbar, null));
        }

        public SnackPop build() {
            snackPop = new SnackPop(activity);

            snackPop.setContentView(b.getRoot());
            if (snackPop.getWindow() != null) snackPop.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            snackPop.setCancelable(true);

            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            if (snackPop.getWindow() != null) {
                layoutParams.copyFrom(snackPop.getWindow().getAttributes());
                layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
                layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT;
                snackPop.getWindow().setAttributes(layoutParams);

                snackPop.getWindow().setBackgroundDrawableResource(R.drawable.alert_dialog_transparent_background);
            }

            b.getRoot().setOnClickListener(v -> {
                snackPop.cancel();
            });

            b.snackCloseBt.setOnClickListener(v -> {
                if (snackbarButtonClickListener != null) snackbarButtonClickListener.onClick();
                snackPop.cancel();
            });

            snackPop.setOnShowListener(dialog -> {
                if (autoCancelMillis > 0) {
                    new Handler().postDelayed(() -> {
                        snackPop.cancel();
                        if (snackbarButtonClickListener != null) snackbarButtonClickListener.onTimesUp();
                    }, autoCancelMillis);
                }
            });

            return snackPop;
        }

        public SnackPop buildAndShow() {
            snackPop = new SnackPop(activity);

            snackPop.setContentView(b.getRoot());
            if (snackPop.getWindow() != null) snackPop.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            snackPop.setCancelable(true);

            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            if (snackPop.getWindow() != null) {
                layoutParams.copyFrom(snackPop.getWindow().getAttributes());
                layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
                layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT;
                snackPop.getWindow().setAttributes(layoutParams);

                snackPop.getWindow().setBackgroundDrawableResource(R.drawable.alert_dialog_transparent_background);
            }

            b.getRoot().setOnClickListener(v -> {
                snackPop.cancel();
            });

            b.snackCloseBt.setOnClickListener(v -> {
                if (snackbarButtonClickListener != null) snackbarButtonClickListener.onClick();
                snackPop.cancel();
            });

            snackPop.setOnShowListener(dialog -> {
                if (autoCancelMillis > 0) {
                    new Handler().postDelayed(() -> {
                        snackPop.cancel();
                        if (snackbarButtonClickListener != null) snackbarButtonClickListener.onTimesUp();
                    }, autoCancelMillis);
                }
            });

            try {
                if (!activity.isFinishing() && !activity.isDestroyed()) {
                    snackPop.show();
                }
            } catch (Exception e) {
                Log.e("SnackPop", "buildAndShow: " + e.getMessage());
            }

            return snackPop;
        }

        public Builder setSnackStyle(SnackStyle snackStyle) {
            if (snackStyle.getBackgroundColor() != SnackStyle.NOT_SET) b.snackBg.setCardBackgroundColor(snackStyle.getBackgroundColor());
            if (snackStyle.getMessageColor() != SnackStyle.NOT_SET) b.snackText.setTextColor(snackStyle.getMessageColor());
            if (snackStyle.getButtonColor() != SnackStyle.NOT_SET) b.snackCloseBt.setTextColor(snackStyle.getButtonColor());
            if (snackStyle.getPosition() != SnackStyle.NOT_SET) setSnackPosition(snackStyle.getPosition());
            return this;
        }

        public Builder setBackgroundColor(int backgroundColor) {
            b.snackBg.setCardBackgroundColor(backgroundColor);
            return this;
        }

        public Builder setMessage(String message) {
            b.snackText.setText(message);
            return this;
        }

        public Builder setMessageColor(int messageColor) {
            b.snackText.setTextColor(messageColor);
            return this;
        }

        public Builder setButtonText(String buttonText) {
            b.snackCloseBt.setText(buttonText);
            return this;
        }

        public Builder setButtonColor(int buttonColor) {
            b.snackCloseBt.setTextColor(buttonColor);
            return this;
        }

        public Builder setPosition(int position) {
            setSnackPosition(position);
            return this;
        }

        private void setSnackPosition(int position) {
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) b.snackBg.getLayoutParams();
            if (params != null) {
                if (position == SnackStyle.Position.TOP) params.removeRule(SnackStyle.Position.BOTTOM);
                else return;

                params.addRule(position);

                b.snackBg.setLayoutParams(params);
            }
        }

        public Builder setAutoCancel(long autoCancelMillis) {
            this.autoCancelMillis = autoCancelMillis;
            return this;
        }

        public Builder setButtonClickListener(SnackbarButtonClickListener snackbarButtonClickListener) {
            this.snackbarButtonClickListener = snackbarButtonClickListener;
            return this;
        }
    }
}
