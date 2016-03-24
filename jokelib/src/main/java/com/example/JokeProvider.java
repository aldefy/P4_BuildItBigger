package com.example;

import java.util.Random;

public class JokeProvider {

    private String[] jokes;
    private Random random;


    public JokeProvider() {
        jokes = new String[10];
        jokes[0] = "A SQL query goes into a bar, walks up to two tables and asks, \"Can I join you?\"";
        jokes[1] = "Q: How many prolog programmers does it take to change a lightbulb? A: Yes.";
        jokes[2] = "Why do Java developers wear glasses? Because they can't C#";
        jokes[3] = "Client to designer: “It doesn’t really look purple. It looks more like a mixture of red and blue.";
        jokes[4] = "The closest I’ve been to a diet this year is erasing food searches from my browser history.";
        jokes[5] = "Hate to break it to you,Facebook, but the entire Internet is already a Dislike button.";
        jokes[6] = "I put so much more effort into naming my first Wi-Fi than my first child.";
        jokes[7] = "I can still remember a time when I knew more than my phone.";
        jokes[8] = "The cool part about naming your kid is you don’t have to add six numbers to make sure the name is available.";
        jokes[9] = "Can a 3-D printer make ink cartridges for a 2-D printer?";

        random = new Random();
    }


    public String[] getJokes() {
        return jokes;
    }


    public String getRandomJoke() {
        return jokes[random.nextInt(jokes.length)];
    }


}
