package com.example.bmoreira.timerapplication;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final long millisUntilFinished = 60000;
    private TextView textView;
    private MainPresenter mainPresenter;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        mainPresenter = new MainPresenter();

        setCountDownTextView(millisUntilFinished);
        createCountDownTimer();
    }

    private void setCountDownTextView(long millisUntilFinished) {
        String formattedMinuteAndSecondFromMillis = mainPresenter.getFormattedMinuteAndSecondFromMillis(millisUntilFinished);
        textView.setText(formattedMinuteAndSecondFromMillis);
    }

    private void createCountDownTimer() {
        countDownTimer = new CountDownEggTimer(millisUntilFinished, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                setCountDownTextView(millisUntilFinished);
            }
        };
    }

    public void startCountDownTimer(View view) {
        countDownTimer.start();
    }
}
