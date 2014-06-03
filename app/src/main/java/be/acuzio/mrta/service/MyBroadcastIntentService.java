package be.acuzio.mrta.service;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import be.acuzio.mrta.MainActivity;
import be.acuzio.mrta.R;

/**
 * Created by vandekr on 12/02/14.
 */
public class MyBroadcastIntentService extends IntentService {
    private final static String TAG = MyBroadcastIntentService.class.getSimpleName();
    public final static int NOTIFICATION_ID = 335446435;
    public final static String NOTIFICATION_TAG = "BNTAG_ACTION";

    public MyBroadcastIntentService() {
        super(MyBroadcastIntentService.class.getSimpleName());
        Log.d(TAG, "Creating new instance of MyBroadcastIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        System.out.println("doing this");
        Log.d(TAG, "onHandleIntent was called");

        Bundle extras = intent.getExtras();

        if (extras != null && !extras.isEmpty()) {  // has effect of unparcelling Bundle
            Log.d(TAG, "Extras were found");

            String action = intent.getStringExtra("ACTION");

            this.sendNotification(action);
        }
    }

    // Put the message into a notification and post it.
    // This is just one simple example of what you might choose to do with
    // a GCM message.
    private void sendNotification(String action) {
        Log.d(TAG, "Sending notification");

        NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

        //set-up the action for authorizing the action
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);


        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setContentTitle(this.getString(R.string.app_name))
                        .setAutoCancel(Boolean.TRUE)
                        .setContentText("You are going to " + action);


        builder.setContentIntent(pendingIntent);

        notificationManager.notify(NOTIFICATION_TAG, NOTIFICATION_ID, builder.build());
    }
}

