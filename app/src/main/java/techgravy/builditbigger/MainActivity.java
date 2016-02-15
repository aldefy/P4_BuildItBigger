package techgravy.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.example.JokeProvider;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import techgravy.androidlibrary.JokeDisplayActivity;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.adView)
    AdView adView;
    @Bind(R.id.instructionsTextView)
    TextView instructionsTextView;
    @Bind(R.id.tellJokeButton)
    Button tellJokeButton;
    JokeProvider jokeProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        jokeProvider = new JokeProvider();
        setupAd();
    }

    private void setupAd() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        adView.loadAd(adRequest);

    }

    @OnClick(R.id.tellJokeButton)
    public void onClick() {
        // Getting a random joke from jokelib
        String joke = jokeProvider.getRandomJoke();
        // Starting JokeDisplayActivity passing the random joke as intent
        Intent intent = new Intent(this, JokeDisplayActivity.class);
        intent.putExtra(JokeDisplayActivity.INTENTTAG, joke);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
