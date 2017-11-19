package com.londonappbrewery.quizzler;

/**
 * Created by alexpadillajr on 11/19/17.
 */

public class Question {

    private int id;
    private Boolean answer;

    public Question(int id, Boolean answer) {
        this.id = id;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getAnswer() {
        return answer;
    }

    public void setAnswer(Boolean answer) {
        this.answer = answer;
    }
}
