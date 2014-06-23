package be.acuzio.mrta;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import be.acuzio.mrta.util.Logger;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

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
    public void showAlertCrouton() {
        Crouton.showText(MainActivity.this, "You just clicked on the ALERT crouton button!", Style.ALERT);

        etStatusMessage.setText("Did you see the ALERT crouton?");

        Log.d(TAG, "showAlertCrouton was clicked");
    }

    @OnClick(R.id.btn_show_info)
    public void showInfoCrouton() {
        Crouton.showText(MainActivity.this, "You invoked the INFO crouton!", Style.INFO);

        etStatusMessage.setText("And thus appeared the info crouton!");

        Log.d(TAG, "showInfoCrouton was clicked");
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy invoked");
        
        Crouton.cancelAllCroutons();
    }
}
