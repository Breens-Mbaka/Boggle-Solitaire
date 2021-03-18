package com.moringaschool.bogglesolitaire;

import android.content.Intent;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowActivity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)// run code natively on JVM and not a device
public class MainActivityTest {
    //tell out test which Activity will be testing with
    private MainActivity activity;
    @Before
    public void setUp() throws Exception {
        activity = Robolectric.buildActivity(MainActivity.class)
                .create()
                .resume()
                .get();
    }
    @Test
    public void secondActivityStarted() {
        activity.findViewById(R.id.button2).performClick();
        Intent expectedIntent = new Intent(activity, MainActivity2.class);
        ShadowActivity shadowActivity = org.robolectric.Shadows.shadowOf(activity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertTrue(actualIntent.filterEquals(expectedIntent));
    }
    @Test
    public void validateWordIsEight() {
        activity.findViewById(R.id.button).performClick();
        TextView text2 = activity.findViewById(R.id.textView3);
        int len = text2.length();
        assertEquals(len , 8);
    }
}
