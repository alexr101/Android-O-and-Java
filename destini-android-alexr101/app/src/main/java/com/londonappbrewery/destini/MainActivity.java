package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView question;
    private Button buttonTop;
    private Button buttonBottom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        question = (TextView) findViewById( R.id.storyTextView );
        buttonTop = (Button) findViewById( R.id.buttonTop);
        buttonBottom = (Button) findViewById( R.id.buttonBottom);

        View.OnClickListener btnListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String btnType = v.getTag().toString();

                Log.d("button pressed:", btnType);

            };
        };

        buttonTop.setOnClickListener(btnListener);
        buttonBottom.setOnClickListener(btnListener);


    }
}
