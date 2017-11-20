package com.londonappbrewery.destini;

/**
 * Created by alexpadillajr on 11/19/17.
 */

public class Story {

    public String text;
    public Option optionA;
    public Option optionB;

    public Story(String text) {
        this.text = text;
    }

    public void setOptions(Option optionA, Option optionB) {
        this.optionA = optionA;
        this.optionB = optionB;
    }
}
