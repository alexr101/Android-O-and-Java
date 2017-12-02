package com.alexpadilla.intentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button intentBtn = (Button) findViewById(R.id.intentBtn);

        intentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // noise
                Intent i = new Intent(MainActivity.this, SecondViewActivity.class);
                i.putExtra("value1","my extra param");
                startActivity(i);
            }
        });
    }
}
