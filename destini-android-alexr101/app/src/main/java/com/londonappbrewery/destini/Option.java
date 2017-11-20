package com.londonappbrewery.destini;

/**
 * Created by alexpadillajr on 11/19/17.
 */

public class Option {
    public String text;
    public Story nextQuestion;

    public Option(String text) {
        this.text = text;
    }

    public void setNextStory(Story nextStory) {
        this.nextQuestion = nextStory;
    }
}
