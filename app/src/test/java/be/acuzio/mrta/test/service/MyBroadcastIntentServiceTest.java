package be.acuzio.mrta.test.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;
import org.robolectric.shadows.ShadowLog;
import org.robolectric.shadows.ShadowNotification;
import org.robolectric.shadows.ShadowNotificationManager;

import be.acuzio.mrta.service.MyBroadcastIntentService;
import be.acuzio.mrta.test.RobolectricGradleTestRunner;

/**
 * Created by vandekr on 12/02/14.
 */
@Config(emulateSdk = 21, constants = be.acuzio.mrta.BuildConfig.class)
@RunWith(RobolectricGradleTestRunner.class)
public class MyBroadcastIntentServiceTest {
    static {
        ShadowLog.stream = System.out;
    }

    private ShadowApplication application;
    private Context context;

    @Before
    public void setup() {
        this.application = ShadowApplication.getInstance();
        this.context = this.application.getApplicationContext();
    }

    @Test
    public void testNoBundleExtrasFound() {
        Intent serviceIntent = new Intent(this.context, MyBroadcastIntentServiceMock.class);
        NotificationManager notificationManager = (NotificationManager) this.context.getSystemService(Context.NOTIFICATION_SERVICE);

        //Robolectric.getShadowApplication().startService(serviceIntent);
        MyBroadcastIntentServiceMock service = new MyBroadcastIntentServiceMock();
        service.onCreate();
        service.onHandleIntent(serviceIntent);

        Assert.assertEquals("Expected no notifications", 0, Shadows.shadowOf(notificationManager).size());
    }

   // @Test
    public void testWithBundleExtrasFound() {
        Intent serviceIntent = new Intent(this.context, MyBroadcastIntentServiceMock.class);
        Bundle bundle = new Bundle();
        bundle.putString("ACTION", "eat an apple");
        serviceIntent.putExtras(bundle);

        NotificationManager notificationManager = (NotificationManager) this.context.getSystemService(Context.NOTIFICATION_SERVICE);

        //Robolectric.getShadowApplication().startService(serviceIntent);
        MyBroadcastIntentServiceMock service = new MyBroadcastIntentServiceMock();
        service.onCreate();
        service.onHandleIntent(serviceIntent);


        ShadowNotificationManager manager = Shadows.shadowOf(notificationManager);
        Assert.assertEquals("Expected one notification", 1, manager.size());

        Notification notification = manager.getNotification(MyBroadcastIntentService.NOTIFICATION_TAG, MyBroadcastIntentService.NOTIFICATION_ID);
        Assert.assertNotNull("Expected notification object", notification);

        ShadowNotification shadowNotification = Shadows.shadowOf(notification);
        Assert.assertNotNull("Expected shadow notification object", shadowNotification);
        Assert.assertNotNull("Expected to have event information", shadowNotification.getLatestEventInfo());

        Assert.assertEquals("You are going to eat an apple", shadowNotification.getLatestEventInfo().getContentText());
    }

    class MyBroadcastIntentServiceMock extends MyBroadcastIntentService {
        @Override
        public void onHandleIntent(Intent intent) {
            super.onHandleIntent(intent);
        }
    }
}
