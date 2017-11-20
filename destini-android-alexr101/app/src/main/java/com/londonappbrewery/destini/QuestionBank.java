package com.londonappbrewery.destini;

import android.content.Context;

/**
 * Created by alexpadillajr on 11/19/17.
 */

public class QuestionBank {
    private Context context;

    public Story story1 = new Story(context.getResources().getString(R.string.story1));
    public Option option1a = new Option(context.getResources().getString(R.string.option1_a));
    public Option option1b = new Option(context.getResources().getString(R.string.option1_b));

    public Story story2 = new Story(context.getResources().getString(R.string.story2));
    public Option option2a = new Option(context.getResources().getString(R.string.option2_a));
    public Option option2b = new Option(context.getResources().getString(R.string.option2_b));

    public Story story3 = new Story(context.getResources().getString(R.string.story3));
    public Option option3a = new Option(context.getResources().getString(R.string.option3_a));
    public Option option3b = new Option(context.getResources().getString(R.string.option3_b));

    public Story story4 = new Story(context.getResources().getString(R.string.story4));
    public Story story5 = new Story(context.getResources().getString(R.string.story5));
    public Story story6 = new Story(context.getResources().getString(R.string.story6));


    public QuestionBank(Context context) {
        this.context = context;
    }

    public void init(){
        story1.setOptions(option1a, option1b);
        story2.setOptions(option2a, option2b);
        story3.setOptions(option3a, option3b);

        option1a.setNextStory(story2);
        option1b.setNextStory(story3);

        option2a.setNextStory(story3);
        option2b.setNextStory(story4);
        
        option3a.setNextStory(story5);
        option3b.setNextStory(story6);

    }
}
