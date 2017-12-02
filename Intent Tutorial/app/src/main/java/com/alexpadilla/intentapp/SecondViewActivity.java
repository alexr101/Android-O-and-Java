package com.alexpadilla.intentapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_view);

        FloatingActionButton getBackBtn = (FloatingActionButton) findViewById(R.id.getBackBtn);

        String value1;

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                value1 = null;
            } else {
                value1 = extras.getString("value1");
            }
        } else {
            value1 = (String) savedInstanceState.getSerializable("value1");
        }

        Log.d("View 1 Intent Value", value1);

        getBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondViewActivity.this, MainActivity.class);
                startActivity(i); // noise...:D

            }
        });
    }

}
