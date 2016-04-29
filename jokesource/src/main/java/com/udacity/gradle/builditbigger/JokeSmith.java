package com.udacity.gradle.builditbigger;

import java.util.Random;

public class JokeSmith {

    String[] funnyJokes = {"What is a Jedi''s favorite Italian dessert? Obi Wan CANNOLI! FUNNY...JOKE!",
                            "What is a Jedi's favorite candy? A LIFESaber! FUNNY...JOKE!",
                            "Where does Vader get all his designer shoes? At a Darth MAUL! FUNNY...JOKE!"};

    String trademark = "These jokes were taken from Youtube channel: The Game Grumps, Yoda Jokes.";

    public String getJoke() {
        Random generator = new Random();
        int jokeIndex = generator.nextInt(funnyJokes.length);
        String retrievedJoke = funnyJokes[jokeIndex];
        return retrievedJoke;
    }
}
