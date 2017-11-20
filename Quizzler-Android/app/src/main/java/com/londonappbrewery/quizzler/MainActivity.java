package com.londonappbrewery.quizzler;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends Activity {

    private Button mTrueBtn;
    private Button mFalseBtn;
    private TextView mQuestionTextView;
    private ProgressBar mProgressBar;
    private TextView mScoreTextView;
    private int mIndex;
    private int mQuestion;
    private int mScore = 0;

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

    private final int PROGRESS_BAR_INCREMENT = (int) Math.ceil(100.0 / mQuestionBank.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null) {
            mScore = savedInstanceState.getInt("score");
            mIndex = savedInstanceState.getInt("questionIndex");
        } else {
            mScore = 0;
            mIndex = 0;
        }

        mTrueBtn = (Button) findViewById(R.id.true_button);
        mFalseBtn = (Button) findViewById(R.id.false_button);
        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
        mScoreTextView = (TextView) findViewById(R.id.score);
        mQuestion = mQuestionBank[mIndex].getId();
        mQuestionTextView.setText(mQuestion);

        updateScore();

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

    private void updateScore() {
        mScoreTextView.setText("Score " + mScore + "/" + mQuestionBank.length);
    }

    private void updateQuestion() {
        mIndex = (mIndex+1) % mQuestionBank.length;

        if(mIndex == 0) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Game Over");
            alert.setCancelable(false);
            alert.setMessage("You finished the game with " + mScore + " points");
            alert.setPositiveButton("Close Application", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            alert.show();
        }

        mQuestion = mQuestionBank[mIndex].getId();
        mQuestionTextView.setText(mQuestion);
        mProgressBar.incrementProgressBy(PROGRESS_BAR_INCREMENT);
        updateScore();
    }

    private void checkAnswer(boolean userAnswer) {
        boolean answer = mQuestionBank[mIndex].getAnswer();

        if(userAnswer == answer) {
            Toast.makeText(getApplicationContext(), R.string.correct_toast, Toast.LENGTH_SHORT).show();
            mScore++;
        } else {
            Toast.makeText(getApplicationContext(), R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("score", mScore);
        outState.putInt("questionIndex", mIndex);
    }
}
