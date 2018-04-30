package com.example.bmoreira.timerapplication;

import android.annotation.SuppressLint;

import java.util.concurrent.TimeUnit;

import static java.lang.String.format;

public class MainPresenter {
    public String getFormattedMinuteAndSecondFromMillis(long millisInFuture) {
        long toMinutes = TimeUnit.MILLISECONDS.toMinutes(millisInFuture);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millisInFuture) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisInFuture));

        String formattedMinuteAndSecond = format("%02d:%02d", toMinutes, seconds);
        return formattedMinuteAndSecond;
    }
}
