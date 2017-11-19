package com.londonappbrewery.quizzler;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends Activity {

    // TODO: Declare constants here
    private final int PROGRESS_BAR_INCREMENT = 8;

    // TODO: Declare member variables here:


    // TODO: Uncomment to create question bank
    private Button mTrueBtn;
    private Button mFalseBtn;
    private TextView mQuestionTextView;
    private int mIndex;
    private int mQuestion;
    private ProgressBar mProgressBar;
    private TextView mScoreTextView;

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
                boolean userAnswer = Boolean.valueOf( v.getTag().toString() );

                checkAnswer(userAnswer);
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
        mProgressBar.incrementProgressBy(PROGRESS_BAR_INCREMENT);
    }

    private void checkAnswer(boolean userAnswer) {
        boolean answer = mQuestionBank[mIndex].getAnswer();

        if(userAnswer == answer) {
            Toast.makeText(getApplicationContext(), R.string.correct_toast, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
        }
    }

}
