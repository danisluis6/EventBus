package googleio2013.evenbus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.electronicarmory.eventbus.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * @link(https://viblo.asia/p/eventbus-trong-android-1l0rvmVkRyqA)
 *
 * @link(https://www.youtube.com/watch?v=WnzSkRinnuc)
 *
 * @link(http://greenrobot.org/eventbus/)
 *
 */

public class MainActivity extends AppCompatActivity {

    private EditText resultsEditText;
    private Button launchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultsEditText = (EditText) findViewById(R.id.resultsEditText);
        launchButton = (Button) findViewById(R.id.launchButton);

        launchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChildActivity.class);
                startActivity(intent);
            }
        });

        EventBus.getDefault().register(this);
    }

    /**
     * Firstly: Register EvenBus.getDefault().register(this).
     * this can be object, string(TAG), whether you want
     *
     * @Subscribe() This annotation will be called to update information or whatever you want. Even caculating
     * @param event
     */

    @Subscribe
    public void onEvent(CustomMessageEvent event) {
        resultsEditText.setText(event.getCustomMessage());
    }
}
