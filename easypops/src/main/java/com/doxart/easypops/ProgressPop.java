package com.doxart.easypops;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.NonNull;

import com.doxart.easypops.databinding.ProgressViewBinding;

public class ProgressPop extends Dialog {
    public ProgressPop(@NonNull Context context) {
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
        private ProgressPop progressPop;
        private ProgressViewBinding b;

        long autoCancelMillis = 0;

        protected Builder(@NonNull Activity activity) {
            this.activity = activity;
            b = ProgressViewBinding.bind(LayoutInflater.from(activity).inflate(R.layout.progress_view, null));
        }

        public ProgressPop build() {
            progressPop = new ProgressPop(activity);
            progressPop.setContentView(R.layout.progress_view);
            if (progressPop.getWindow() != null) progressPop.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            progressPop.setCancelable(false);

            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            if (progressPop.getWindow() != null) {
                layoutParams.copyFrom(progressPop.getWindow().getAttributes());
                layoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
                layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
                progressPop.getWindow().setAttributes(layoutParams);

                progressPop.getWindow().setBackgroundDrawableResource(R.drawable.alert_dialog_background);
            }

            if (!activity.isFinishing() && !activity.isDestroyed()) {
                progressPop.cancel();
            }

            progressPop.setOnShowListener(dialog -> {
                if (autoCancelMillis > 0) new Handler().postDelayed(() -> progressPop.cancel(), autoCancelMillis);
            });

            return progressPop;
        }

        public ProgressPop buildAndShow() {
            progressPop = new ProgressPop(activity);
            progressPop.setContentView(R.layout.progress_view);
            if (progressPop.getWindow() != null) progressPop.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            progressPop.setCancelable(false);

            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            if (progressPop.getWindow() != null) {
                layoutParams.copyFrom(progressPop.getWindow().getAttributes());
                layoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
                layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
                progressPop.getWindow().setAttributes(layoutParams);

                progressPop.getWindow().setBackgroundDrawableResource(R.drawable.alert_dialog_background);
            }

            if (!activity.isFinishing() && !activity.isDestroyed()) {
                progressPop.cancel();
            }

            progressPop.setOnShowListener(dialog -> {
                if (autoCancelMillis > 0) new Handler().postDelayed(() -> progressPop.cancel(), autoCancelMillis);
            });

            try {
                progressPop.show();
            } catch (Exception e) {
                Log.e("ProgressPop", "buildAndShow: " + e.getMessage());
            }

            return progressPop;
        }

        public Builder setAutoCancel(long autoCancelMillis) {
            this.autoCancelMillis = autoCancelMillis;
            return this;
        }

        public Builder setBackgroundColor(int backgroundColor) {
            b.progressBG.setCardBackgroundColor(backgroundColor);
            return this;
        }

        public Builder setProgressColor(int progressColor) {
            b.progress.setIndeterminateTintList(ColorStateList.valueOf(progressColor));
            return this;
        }
    }
}
