package be.acuzio.mrta.test;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowToast;

import be.acuzio.mrta.LocalBroadcastActivity;

/**
 * Created by vandekr on 11/02/14.
 */
@Config(emulateSdk = 18)
@RunWith(RobolectricTestRunner.class)
public class LocalBroadcastActivityTest {
    @Before
    public void setup() {
        //do whatever is necessary before every test
    }

    @Test
    public void testActivityFound() {
        Activity activity = Robolectric.buildActivity(LocalBroadcastActivity.class).create().get();

        Assert.assertNotNull(activity);
    }

    @Test
    public void testBroadcastReceiverRegistered() {
        Activity activity = Robolectric.buildActivity(LocalBroadcastActivity.class).create().resume().get();

        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(activity);

        localBroadcastManager.sendBroadcast(new Intent("be.acuzio.mrta.LOCAL_BROADCAST"));

        Assert.assertEquals("onReceive Toast Called", ShadowToast.getTextOfLatestToast());

    }

    @Test
    public void testLocalReceiver() {
        LocalBroadcastManager instance = LocalBroadcastManager.getInstance(Robolectric.application);
        final boolean[] called = new boolean[1];
        final BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                called[0] = true;
            }
        };
        instance.registerReceiver(receiver, new IntentFilter("com.foo"));

        instance.sendBroadcast(new Intent("com.bar"));
        Assert.assertFalse(called[0]);
        instance.sendBroadcast(new Intent("com.foo"));
        Assert.assertTrue(called[0]);
    }
}
