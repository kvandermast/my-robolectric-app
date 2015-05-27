package be.acuzio.mrta.test;

import android.app.Activity;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.annotation.Config;

import be.acuzio.mrta.MainActivity;

/**
 * Created by vandekr on 11/02/14.
 */
@Config(emulateSdk = 21, constants = be.acuzio.mrta.BuildConfig.class)
@RunWith(RobolectricGradleTestRunner.class)
public class MainActivityTest {
    @Before
    public void setup() {
        //do whatever is necessary before every test
    }

    @Test
    public void testActivityFound() {
        Activity activity = Robolectric.setupActivity(MainActivity.class);

        Assert.assertNotNull(activity);
    }
}
