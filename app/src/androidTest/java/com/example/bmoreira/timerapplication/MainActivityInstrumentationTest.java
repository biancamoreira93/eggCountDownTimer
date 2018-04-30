package com.example.bmoreira.timerapplication;

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.espresso.util.TreeIterables;
import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.getIdlingResources;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;

public class MainActivityInstrumentationTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void startsTimerAfterClickingOnButton() throws InterruptedException {
        onView(withId(R.id.textView)).check(matches(isDisplayed()));
        onView(withId(R.id.button)).check(matches(isDisplayed()));

        onView(withId(R.id.button)).perform(click());

        synchronized (getInstrumentation()) {
            getInstrumentation().wait(100);
        }

        onView(allOf(withId(R.id.textView), withText("00:59"))).check(matches(isDisplayed()));
    }
}
