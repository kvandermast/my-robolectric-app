package be.acuzio.mrta.test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;

/**
 * Created by vandekr on 11/02/14.
 */
@Config(emulateSdk = 21, constants = be.acuzio.mrta.BuildConfig.class)
@RunWith(RobolectricGradleTestRunner.class)
public class DummyTest {
    @Before
    public void setup() {
        //do whatever is necessary before every test
    }

    @Test
    public void testShouldFail() {
        Assert.assertTrue(Boolean.TRUE);
    }
}


