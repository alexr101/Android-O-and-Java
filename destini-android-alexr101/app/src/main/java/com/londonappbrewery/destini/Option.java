package com.londonappbrewery.destini;

/**
 * Created by alexpadillajr on 11/19/17.
 */

public class Option {
    public String text;
    public Question nextQuestion;

    public void Option(String text, Question nextQuestion) {
        this.text = text;
        this.nextQuestion = nextQuestion;
    }
}
