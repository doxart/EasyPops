package com.doxart.modulecustompopup;

import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.doxart.easypops.DatePickerStyle;
import com.doxart.easypops.DialogStyle;
import com.doxart.easypops.EasyPopup;
import com.doxart.easypops.OnDateSelectListener;
import com.doxart.easypops.SnackStyle;
import com.doxart.modulecustompopup.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        inflate();
    }

    private void inflate() {
        b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();
    }

    private void init() {
        b.datePickerBt.setOnClickListener(v -> getDatePicker());
        b.showProgressBt.setOnClickListener(v -> getProgress());
        b.showSnackBt.setOnClickListener(v -> getSnack());
        b.showDialogBt.setOnClickListener(v -> getDialog());
    }

    private void getDatePicker() {
        DatePickerStyle datePickerStyle = new DatePickerStyle();
        datePickerStyle.setBackgroundColor(ContextCompat.getColor(this, R.color.black));
        datePickerStyle.setTitleColor(ContextCompat.getColor(this, R.color.white));
        datePickerStyle.setMessageColor(ContextCompat.getColor(this, R.color.white));
        datePickerStyle.setPositiveButtonColor(ContextCompat.getColor(this, R.color.primary));
        datePickerStyle.setPositiveButtonTextColor(ContextCompat.getColor(this, R.color.white));

        EasyPopup.createDatePicker(this).setBackgroundColor(ContextCompat.getColor(this, R.color.white)).buildAndShow();

        EasyPopup.createDatePicker(this).setTitle("Date picker").setMessage("Select your date").setDatePickerStyle(datePickerStyle).setOnDateSelectListener(new OnDateSelectListener() {
            @Override
            public void onDateSelected(int day, int month, int year) {
                b.datePickerBt.setText(day + "/" + month + "/" + year);
            }

            @Override
            public void onDismiss() {

            }
        }).buildAndShow();
    }

    private void getProgress() {
        EasyPopup.createProgress(this).setProgressColor(ContextCompat.getColor(this, R.color.primary)).setAutoCancel(10000).buildAndShow();

        EasyPopup.createProgress(this).buildAndShow();
    }

    private void getSnack() {
        SnackStyle snackStyle = new SnackStyle();
        snackStyle.setBackgroundColor(ContextCompat.getColor(this, R.color.black));
        snackStyle.setMessageColor(ContextCompat.getColor(this, R.color.white));
        snackStyle.setButtonColor(ContextCompat.getColor(this, R.color.primary));
        snackStyle.setPosition(SnackStyle.Position.BOTTOM);

        EasyPopup.createSnack(this).setBackgroundColor(ContextCompat.getColor(this, R.color.primary)).buildAndShow();

        EasyPopup.createSnack(this).setSnackStyle(SnackStyle.SNACK_ERROR(this)).setMessage("This is error snack.").buildAndShow();
    }

    private void getDialog() {
        DialogStyle dialogStyle = new DialogStyle();
        dialogStyle.setBackgroundColor(ContextCompat.getColor(this, R.color.black));
        dialogStyle.setTitleColor(ContextCompat.getColor(this, R.color.white));
        dialogStyle.setMessageColor(ContextCompat.getColor(this, R.color.white));
        dialogStyle.setPositiveButtonColor(ContextCompat.getColor(this, R.color.primary));
        dialogStyle.setPositiveButtonTextColor(ContextCompat.getColor(this, R.color.white));
        dialogStyle.setNegativeButtonColor(ContextCompat.getColor(this, R.color.primary));
        dialogStyle.setNegativeButtonTextColor(ContextCompat.getColor(this, R.color.white));

        EasyPopup.createDialog(this).setTitleColor(ContextCompat.getColor(this, R.color.primary)).buildAndShow();

        EasyPopup.createDialog(this).setTitle("Title").setMessage("This is message").setDialogStyle(DialogStyle.DIALOG_NORMAL()).buildAndShow();
    }
}