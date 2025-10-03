package com.doxart.easypops;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.NonNull;

import com.doxart.easypops.databinding.DateSelectorLayoutBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatePickerPop extends Dialog {
    public DatePickerPop(@NonNull Context context) {
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
        private Context context;
        private DatePickerPop datePickerPop;
        private DateSelectorLayoutBinding b;
        private OnDateSelectListener onDateSelectListener;

        protected Builder(@NonNull Context context) {
            this.context = context;
            b = DateSelectorLayoutBinding.bind(LayoutInflater.from(context).inflate(R.layout.date_selector_layout, null));
        }

        public DatePickerPop build() {
            datePickerPop = new DatePickerPop(context);
            datePickerPop.setContentView(b.getRoot());
            if (datePickerPop.getWindow() != null) datePickerPop.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            datePickerPop.setCancelable(false);

            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            if (datePickerPop.getWindow() != null) {
                layoutParams.copyFrom(datePickerPop.getWindow().getAttributes());
                layoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
                layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
                datePickerPop.getWindow().setAttributes(layoutParams);

                datePickerPop.getWindow().setBackgroundDrawableResource(R.drawable.alert_dialog_transparent_background);
            }

            b.applyBt.setOnClickListener(view -> {
                if (onDateSelectListener != null) {
                    try {
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(Calendar.YEAR, b.datePicker.getYear());
                        calendar.set(Calendar.MONTH, b.datePicker.getMonth());
                        calendar.set(Calendar.DAY_OF_MONTH, b.datePicker.getDayOfMonth());
                        Date date = calendar.getTime();

                        DateResult result = new DateResult(b.datePicker.getDayOfMonth(), b.datePicker.getMonth()+1, b.datePicker.getYear(), new SimpleDateFormat("dd/MM/yyyy").format(date), date);

                        onDateSelectListener.onDateSelected(result);
                    } catch (Exception e) {
                        Log.e("DatePickerPop", "build: " + e.getMessage());
                        onDateSelectListener.onError(e);
                    }
                }
                if (datePickerPop != null) datePickerPop.cancel();
            });

            b.laterBt.setOnClickListener(v -> {
                if (onDateSelectListener != null) onDateSelectListener.onDismiss();
                if (datePickerPop != null) datePickerPop.cancel();
            });

            return datePickerPop;
        }

        public DatePickerPop buildAndShow() {
            datePickerPop = new DatePickerPop(context);
            datePickerPop.setContentView(b.getRoot());
            if (datePickerPop.getWindow() != null) datePickerPop.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            datePickerPop.setCancelable(false);

            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            if (datePickerPop.getWindow() != null) {
                layoutParams.copyFrom(datePickerPop.getWindow().getAttributes());
                layoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
                layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
                datePickerPop.getWindow().setAttributes(layoutParams);

                datePickerPop.getWindow().setBackgroundDrawableResource(R.drawable.alert_dialog_transparent_background);
            }

            b.applyBt.setOnClickListener(view -> {
                if (onDateSelectListener != null) {
                    try {
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(Calendar.YEAR, b.datePicker.getYear());
                        calendar.set(Calendar.MONTH, b.datePicker.getMonth());
                        calendar.set(Calendar.DAY_OF_MONTH, b.datePicker.getDayOfMonth());
                        Date date = calendar.getTime();

                        DateResult result = new DateResult(b.datePicker.getDayOfMonth(), b.datePicker.getMonth()+1, b.datePicker.getYear(), new SimpleDateFormat("dd/MM/yyyy").format(date), date);

                        onDateSelectListener.onDateSelected(result);
                    } catch (Exception e) {
                        Log.e("DatePickerPop", "build: " + e.getMessage());
                        onDateSelectListener.onError(e);
                    }
                }
                if (datePickerPop != null) datePickerPop.cancel();
            });

            b.laterBt.setOnClickListener(v -> {
                if (onDateSelectListener != null) onDateSelectListener.onDismiss();
                if (datePickerPop != null) datePickerPop.cancel();
            });

            try {
                datePickerPop.show();
            } catch (Exception e) {
                Log.e("DatePickerPop", "buildAndShow: " + e.getMessage());
            }

            return datePickerPop;
        }

        public Builder setDatePickerStyle(DatePickerStyle datePickerStyle) {
            if (datePickerStyle.getBackgroundColor() != DatePickerStyle.NOT_SET) b.card.setCardBackgroundColor(datePickerStyle.getBackgroundColor());
            if (datePickerStyle.getTitleColor() != DatePickerStyle.NOT_SET) b.title.setTextColor(datePickerStyle.getTitleColor());
            if (datePickerStyle.getMessageColor() != DatePickerStyle.NOT_SET) b.message.setTextColor(datePickerStyle.getMessageColor());
            if (datePickerStyle.getPositiveButtonColor() != DatePickerStyle.NOT_SET) b.applyBt.setBackgroundColor(datePickerStyle.getPositiveButtonColor());
            if (datePickerStyle.getPositiveButtonTextColor() != DatePickerStyle.NOT_SET) b.applyBt.setTextColor(datePickerStyle.getPositiveButtonTextColor());
            if (datePickerStyle.getNegativeButtonColor() != DatePickerStyle.NOT_SET) b.laterBt.setBackgroundColor(datePickerStyle.getNegativeButtonColor());
            if (datePickerStyle.getNegativeButtonTextColor() != DatePickerStyle.NOT_SET) b.laterBt.setTextColor(datePickerStyle.getNegativeButtonTextColor());
            return this;
        }

        public Builder setBackgroundColor(int backgroundColor) {
            b.card.setCardBackgroundColor(backgroundColor);
            return this;
        }

        public Builder setTitle(String title) {
            b.title.setText(title);
            return this;
        }

        public Builder setTitleColor(int titleColor) {
            b.title.setTextColor(titleColor);
            return this;
        }

        public Builder setMessage(String message) {
            b.message.setText(message);
            return this;
        }

        public Builder setMessageColor(int messageColor) {
            b.message.setTextColor(messageColor);
            return this;
        }

        public Builder setPositiveButtonText(String positiveButtonText) {
            b.applyBt.setText(positiveButtonText);
            return this;
        }

        public Builder setPositiveButtonColor(int positiveButtonColor) {
            b.applyBt.setBackgroundColor(positiveButtonColor);
            return this;
        }

        public Builder setPositiveButtonTextColor(int positiveButtonTextColor) {
            b.applyBt.setTextColor(positiveButtonTextColor);
            return this;
        }

        public Builder setNegativeButtonText(String negativeButtonText) {
            b.laterBt.setText(negativeButtonText);
            return this;
        }

        public Builder setNegativeButtonColor(int negativeButtonColor) {
            b.laterBt.setBackgroundColor(negativeButtonColor);
            return this;
        }

        public Builder setNegativeButtonTextColor(int negativeButtonTextColor) {
            b.laterBt.setTextColor(negativeButtonTextColor);
            return this;
        }

        public Builder setIncludeDays(boolean includeDays) {
            if (!includeDays) b.datePicker.findViewById(context.getResources().getIdentifier("day","id","android")).setVisibility(View.GONE);
            return this;
        }

        public Builder setOnDateSelectListener(OnDateSelectListener onDateSelectListener) {
            this.onDateSelectListener = onDateSelectListener;
            return this;
        }
    }
}
