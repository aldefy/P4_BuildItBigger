package techgravy.builditbigger;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.JokeProvider;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by aditlal on 24/03/16.
 */
public class MainFragment extends Fragment {

    @Bind(R.id.instructionsTextView)
    TextView instructionsTextView;
    @Bind(R.id.tellJokeButton)
    Button tellJokeButton;
    JokeProvider jokeProvider;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, rootView);
        jokeProvider = new JokeProvider();
        return rootView;
    }



    @OnClick(R.id.tellJokeButton)
    public void onClick() {
        new EndPointsAsyncTask(getActivity(),true).execute();
    }
}
