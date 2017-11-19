package com.londonappbrewery.quizzler;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    // TODO: Declare constants here


    // TODO: Declare member variables here:


    // TODO: Uncomment to create question bank
    private Button mTrueBtn;
    private Button mFalseBtn;
    private TextView mQuestionTextView;
    private int mIndex;
    private int mQuestion;

    private Question[] mQuestionBank = new Question[] {
            new Question(R.string.question_1, true),
            new Question(R.string.question_2, true),
            new Question(R.string.question_3, true),
            new Question(R.string.question_4, true),
            new Question(R.string.question_5, true),
            new Question(R.string.question_6, false),
            new Question(R.string.question_7, true),
            new Question(R.string.question_8, false),
            new Question(R.string.question_9, true),
            new Question(R.string.question_10, true),
            new Question(R.string.question_11, false),
            new Question(R.string.question_12, false),
            new Question(R.string.question_13,true)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueBtn = (Button) findViewById(R.id.true_button);
        mFalseBtn = (Button) findViewById(R.id.false_button);
        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);

        mQuestion = mQuestionBank[mIndex].getId();
        mQuestionTextView.setText(mQuestion);

        View.OnClickListener btnListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateQuestion();
            }
        };

        mTrueBtn.setOnClickListener(btnListener);
        mFalseBtn.setOnClickListener(btnListener);


    }

    private void updateQuestion() {
        mIndex = (mIndex+1) % mQuestionBank.length;
        mQuestion = mQuestionBank[mIndex].getId();
        mQuestionTextView.setText(mQuestion);
    }

    private void checkAnswer(Boolean userAnswer) {
        Boolean answer = mQuestionBank[mIndex].getAnswer();

        if(userAnswer == answer) {
            Toast.makeText(getApplicationContext(), R.string.correct_toast, Toast.LENGTH_SHORT);
        } else {
            Toast.makeText(getApplicationContext(), R.string.incorrect_toast, Toast.LENGTH_SHORT);
        }
    }

}
