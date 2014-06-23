package be.acuzio.mrta;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class WidgetActivity extends Activity {

    @InjectView(R.id.editText)
    EditText etHelloWorld;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget);

        ButterKnife.inject(this);
    }

    @OnClick(R.id.button)
    public void reverse() {
        String currentText = this.etHelloWorld.getText() == null ? "" : this.etHelloWorld.getText().toString();

        if (currentText.isEmpty()) {
            this.etHelloWorld.setText(R.string.hello_world);
        } else {
            String inReverse = new StringBuilder(currentText).reverse().toString();

            this.etHelloWorld.setText(inReverse);
        }
    }
}
