package techgravy.androidlibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by aditlal on 15/02/16.
 */
public class JokeDisplayActivity extends AppCompatActivity {
    public final static String INTENT_TAG ="jokeIntent";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        // Processing the joke intent
        String joke = getIntent().getStringExtra(INTENT_TAG);
        TextView textViewJoke = (TextView) findViewById(R.id.textview_joke);
        textViewJoke.setText(joke);
    }


}
