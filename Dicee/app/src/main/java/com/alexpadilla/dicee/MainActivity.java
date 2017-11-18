package com.alexpadilla.dicee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button rollBtn = (Button) findViewById(R.id.rollBtn);
        ImageView dice1 = (ImageView) findViewById(R.id.dice_left);
        ImageView dice2 = (ImageView) findViewById(R.id.dice_right);

        int[] diceArr = {
                R.drawable.dice1,
                R.drawable.dice2,
                R.drawable.dice3,
                R.drawable.dice4,
                R.drawable.dice5,
                R.drawable.dice6,
        };

        rollBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Dicee", "The button was pressed");

                Random randomNumberGenerator = new Random();

                int number = randomNumberGenerator.nextInt(6);


            }
        });

    }
}
