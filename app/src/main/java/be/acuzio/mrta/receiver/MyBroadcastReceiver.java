package be.acuzio.mrta.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import be.acuzio.mrta.service.MyBroadcastIntentService;

/**
 * Created by vandekr on 12/02/14.
 */
public class MyBroadcastReceiver extends BroadcastReceiver {
    private final static String TAG = MyBroadcastReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive was triggered");

        Intent service = new Intent(context, MyBroadcastIntentService.class);
        service.putExtra("ACTION", intent.getStringExtra("PERFORM"));

        context.startService(service);


    }
}
