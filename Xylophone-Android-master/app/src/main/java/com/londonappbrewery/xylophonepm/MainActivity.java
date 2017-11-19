package com.londonappbrewery.xylophonepm;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Helpful Constants
    private final int NR_OF_SIMULTANEOUS_SOUNDS = 7;
    private final float LEFT_VOLUME = 1.0f;
    private final float RIGHT_VOLUME = 1.0f;
    private final int NO_LOOP = 0;
    private final int PRIORITY = 0;
    private final float NORMAL_PLAY_RATE = 1.0f;

    // TODO: Add member variables here
    SoundPool sp;
    private List<Integer> soundIdArr = new ArrayList<Integer>();

    private int[] notesArr = {
            R.raw.note1_c,
            R.raw.note2_d,
            R.raw.note3_e,
            R.raw.note4_f,
            R.raw.note5_g,
            R.raw.note6_a,
            R.raw.note7_b,
    };


    /** soundId for Later handling of sound pool **/


//    MediaPlayer mPlayer = MediaPlayer.create(context, R.raw.windows_8_notify); // in 2nd param u have to pass your desire ringtone
//    //mPlayer.prepare();
// mPlayer.start();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = new SoundPool(NR_OF_SIMULTANEOUS_SOUNDS, AudioManager.STREAM_MUSIC, 0);


        for(int i = 0; i< notesArr.length; i++){
            int note = notesArr[i];
            int soundId = sp.load(getApplicationContext(), notesArr[i], 1);

            soundIdArr.add(soundId);
        }


        // TODO: Load and get the IDs to identify the sounds


    }

    // TODO: Add the play methods triggered by the buttons

    public void playNote(View v) {
        int noteNum = Integer.valueOf(v.getTag().toString());
        int soundId = soundIdArr.get(noteNum);

        sp.play(soundId, 1, 1, 0, 0, 1);

    }



}
