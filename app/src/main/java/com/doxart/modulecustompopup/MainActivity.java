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
        datePickerStyle.setBackgroundColor(ContextCompat.getColor(this, com.doxart.easypops.R.color.blat));

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
        EasyPopup.createProgress(this).buildAndShow();
    }

    private void getSnack() {
        EasyPopup.createSnack(this).setSnackStyle(SnackStyle.SNACK_ERROR(this)).setMessage("This is error snack.").buildAndShow();
    }

    private void getDialog() {
        EasyPopup.createDialog(this).setTitle("Title").setMessage("This is message").setDialogStyle(DialogStyle.DIALOG_NORMAL()).buildAndShow();
    }
}