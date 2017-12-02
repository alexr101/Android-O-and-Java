package com.alexpadilla.retrofittutorial.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.alexpadilla.retrofittutorial.R;

public class MainActivity extends AppCompatActivity {

    private final static String API_KEY = "193d573c5e8bd0513c33d0ef959d57fa";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (API_KEY.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please obtain your API KEY first from themoviedb.org", Toast.LENGTH_LONG).show();
            return;
        }
    }
}
