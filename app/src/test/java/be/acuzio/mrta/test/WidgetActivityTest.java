package be.acuzio.mrta.test;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import be.acuzio.mrta.R;
import be.acuzio.mrta.WidgetActivity;

@Config(emulateSdk = 18)
@RunWith(RobolectricTestRunner.class)
public class WidgetActivityTest {
    @Before
    public void setup() {
        //do whatever is necessary before every test
    }

    @Test
    public void testReverse() {
        //get the ShadowActivity
        Activity activity = Robolectric.buildActivity(WidgetActivity.class).create().get();

        Assert.assertNotNull(activity);

        Assert.assertNotNull(activity.findViewById(R.id.editText));
        EditText editText = (EditText) activity.findViewById(R.id.editText);

        //check if the textfield contains the expected value
        Assert.assertNotNull(editText.getText());
        Assert.assertEquals(editText.getText().toString(), "Hello world!");

        //trigger the onclick
        Button button = (Button) activity.findViewById(R.id.button);
        Assert.assertNotNull(button);
        button.performClick();

        //check if the result is what we expect it to be
        Assert.assertEquals(editText.getText().toString(), "!dlrow olleH");

    }


}
