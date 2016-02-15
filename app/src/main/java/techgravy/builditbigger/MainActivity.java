package techgravy.builditbigger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.JokeProvider;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
        Toast.makeText(this, jokeProvider.getRandomJoke(), Toast.LENGTH_SHORT).show();
    }
}
