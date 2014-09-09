package com.exanple.android.akkaexample;

import android.test.ActivityInstrumentationTestCase2;
import com.example.android.akkaexample.MainActivity;

/**
 * This is a simple framework for a test of an Application.  See
 * {@link android.test.ApplicationTestCase ApplicationTestCase} for more information on
 * how to write and extend Application tests.
 * <p/>
 * To run this test, you can type:
 * adb shell am instrument -w \
 * -e class com.exanple.android.akkaexample.MainActivityTest \
 * com.exanple.android.akkaexample.tests/android.test.InstrumentationTestRunner
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityTest() {
        super("com.exanple.android.akkaexample", MainActivity.class);
    }

}
