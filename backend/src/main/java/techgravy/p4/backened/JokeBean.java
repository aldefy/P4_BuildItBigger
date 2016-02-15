package techgravy.p4.backened;

import com.example.JokeProvider;

/** The object model for the data we are sending through endpoints */
public class JokeBean {

    private JokeProvider jokeTelling;


    public JokeBean() {
        jokeTelling = new JokeProvider();
    }


    public String getJoke() {
        return jokeTelling.getRandomJoke();
    }
}