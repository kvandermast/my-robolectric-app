package be.acuzio.mrta;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import be.acuzio.mrta.util.Logger;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends Activity {
    private final static String TAG = MainActivity.class.getSimpleName();

    @InjectView(R.id.et_message)
    EditText etStatusMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);

        //you can start working with the annotated widgets after you injected them

        Log.d(TAG, "Log1 - onCreate completed");
        Logger.d(TAG, "Log2 - onCreate completed");

        Log.d(TAG, "Log3 - onCreate was called from class " + TAG);
        Logger.d(TAG, "Log4 - onCreate was called from class %s", TAG);
    }


    @OnClick(R.id.btn_show_alert)
    public void showAlertToast() {
        Toast.makeText(MainActivity.this, "You just clicked on the ALERT toast button!", Toast.LENGTH_LONG).show();

        etStatusMessage.setText("Did you see the ALERT crouton?");

        Log.d(TAG, "showAlertCrouton was clicked");
    }

    @OnClick(R.id.btn_show_info)
    public void showInfoCrouton() {
        Toast.makeText(MainActivity.this, "You just clicked on the INFO toast button!", Toast.LENGTH_LONG).show();

        etStatusMessage.setText("And thus appeared the info crouton!");

        Log.d(TAG, "showInfoCrouton was clicked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "onDestroy invoked");
    }
}
