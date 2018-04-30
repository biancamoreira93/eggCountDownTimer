package com.example.bmoreira.timerapplication;

import android.os.CountDownTimer;

public abstract class CountDownEggTimer extends CountDownTimer {
    public CountDownEggTimer(long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
    }

    @Override
    public abstract void onTick(long millisUntilFinished);

    @Override
    public void onFinish() {}
}
