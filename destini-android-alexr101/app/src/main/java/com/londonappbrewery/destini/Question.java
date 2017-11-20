package com.londonappbrewery.destini;

/**
 * Created by alexpadillajr on 11/19/17.
 */

public class Question {

    public String text;
    public Option optionA;
    public Option optionB;

    public void Question(String text, Option optionA, Option optionB) {
        this.text = text;
        this.optionA = optionA;
        this.optionB = optionB;
    }
}
