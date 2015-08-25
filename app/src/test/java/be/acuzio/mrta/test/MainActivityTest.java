package be.acuzio.mrta.test;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowToast;

import be.acuzio.mrta.MainActivity;
import be.acuzio.mrta.R;

/**
 * Created by vandekr on 11/02/14.
 */
@Config(sdk = 21, constants = be.acuzio.mrta.BuildConfig.class)
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

    @Test
    public void testButtonClicks() {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);

        Assert.assertNotNull(activity);

        EditText editText = (EditText) activity.findViewById(R.id.et_message);

        Button button = (Button) activity.findViewById(R.id.btn_show_alert);
        button.performClick();

        Assert.assertEquals("You just clicked on the ALERT toast button!", ShadowToast.getTextOfLatestToast());
        Assert.assertEquals("Did you see the ALERT crouton?", editText.getText().toString());

        button = (Button) activity.findViewById(R.id.btn_show_info);
        button.performClick();

        Assert.assertEquals("You just clicked on the INFO toast button!", ShadowToast.getTextOfLatestToast());
        Assert.assertEquals("And thus appeared the info crouton!", editText.getText().toString());
    }
}
