package com.alexpadilla.dicee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.rollBtn);
        ImageView dice1 = (ImageView) findViewById(R.id.dice_left);
        ImageView dice2 = (ImageView) findViewById(R.id.dice_right);

    }
}
