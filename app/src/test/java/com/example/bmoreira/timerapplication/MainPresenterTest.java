package com.example.bmoreira.timerapplication;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class MainPresenterTest {

    private MainPresenter mainPresenter;

    @Before
    public void setUp() throws Exception {
        mainPresenter = new MainPresenter();
    }

    @Test
    public void transformsMillisecondsInHoursAndMinutes() {
        long millisInFuture = 120000;
        String expectedFormattedMinuteAndSecond = "02:00";
        String realFormattedMinuteAndSecond = mainPresenter.getFormattedMinuteAndSecondFromMillis(millisInFuture);

        assertEquals(expectedFormattedMinuteAndSecond, realFormattedMinuteAndSecond);
    }
}
