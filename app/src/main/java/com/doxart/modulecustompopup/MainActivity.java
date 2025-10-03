package com.doxart.modulecustompopup;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.doxart.easypops.DatePickerStyle;
import com.doxart.easypops.DateResult;
import com.doxart.easypops.DialogPop;
import com.doxart.easypops.DialogStyle;
import com.doxart.easypops.EasyPopup;
import com.doxart.easypops.OnDateSelectListener;
import com.doxart.easypops.OnDialogAnswerListener;
import com.doxart.easypops.SnackStyle;
import com.doxart.easypops.SnackbarButtonClickListener;
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

        DialogPop d = EasyPopup.createDialog(this)
                .setProgressBackgroundColor(ContextCompat.getColor(this, com.doxart.easypops.R.color.plat2))
                .setProgressColor(ContextCompat.getColor(this, com.doxart.easypops.R.color.secondary))
                .setProgressTarget("250 mb")
                .setProgressText("0 mb")
                .setProgressActive(true).buildAndShow();

        new CountDownTimer(100000, 1000) {
            @Override
            public void onFinish() {

            }

            @Override
            public void onTick(long l) {
                d.setProgress(100 - ((int) l / 1000));
            }
        }.start();
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
            public void onDateSelected(DateResult result) {
                b.datePickerBt.setText(result.getDay() + "/" + result.getMonth() + "/" + result.getYear());
            }
        }).buildAndShow();
    }

    private void getProgress() {
        EasyPopup.createProgress(this).setProgressColor(ContextCompat.getColor(this, R.color.primary)).setText("Please wait").setAutoCancel(10000).buildAndShow();
    }

    int snackTap = 0;

    private void getSnack() {
        SnackStyle snackStyle = new SnackStyle();
        snackStyle.setBackgroundColor(ContextCompat.getColor(this, R.color.black));
        snackStyle.setMessageColor(ContextCompat.getColor(this, R.color.white));
        snackStyle.setButtonColor(ContextCompat.getColor(this, R.color.primary));
        snackStyle.setPosition(SnackStyle.Position.BOTTOM);

        EasyPopup.createSnack(this).setBackgroundColor(ContextCompat.getColor(this, R.color.primary)).buildAndShow();

        if (snackTap == 0) {
            EasyPopup.createSnack(this).setSnackStyle(SnackStyle.SNACK_ERROR(this)).setMessage("This is ERROR snack.").setButtonClickListener(new SnackbarButtonClickListener() {
                @Override
                public void onClick() {
                    b.showSnackBt.setText("Show Success Snack");
                    snackTap = 1;
                }

                @Override
                public void onTimesUp() {

                }
            }).buildAndShow();
        } else if (snackTap == 1) {
            EasyPopup.createSnack(this).setSnackStyle(SnackStyle.SNACK_SUCCESS(this)).setMessage("This is SUCCESS snack.").setButtonClickListener(new SnackbarButtonClickListener() {
                @Override
                public void onClick() {
                    b.showSnackBt.setText("Show Normal Snack");
                    snackTap = 2;
                }

                @Override
                public void onTimesUp() {

                }
            }).buildAndShow();
        } else if (snackTap == 2) {
            EasyPopup.createSnack(this).setSnackStyle(SnackStyle.SNACK_NORMAL(this)).setMessage("This is NORMAL snack.").setButtonClickListener(new SnackbarButtonClickListener() {
                @Override
                public void onClick() {
                    b.showSnackBt.setText("Show Error Snack");
                    snackTap = 0;
                }

                @Override
                public void onTimesUp() {

                }
            }).buildAndShow();
        }
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

        EasyPopup.createDialog(this).setTitle("Title").setMessage("This is message").setDialogStyle(DialogStyle.Default_Dialog()).setOnDialogAnswerListener(new OnDialogAnswerListener() {
            @Override
            public void onPositive() {
                Toast.makeText(MainActivity.this, "You select yes.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNegative() {
                Toast.makeText(MainActivity.this, "You select no.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLater() {
                Toast.makeText(MainActivity.this, "You select later.", Toast.LENGTH_SHORT).show();
            }
        }).buildAndShow();
    }
}