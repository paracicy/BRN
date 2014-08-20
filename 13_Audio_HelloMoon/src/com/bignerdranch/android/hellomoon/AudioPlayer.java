package com.bignerdranch.android.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;

public class AudioPlayer {

    private MediaPlayer mPlayer;
    public boolean isPausing = false;
    
    public void stop() {
        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
    }
    
    public void pause() {
        if (mPlayer != null) {
            mPlayer.pause();
            isPausing = true;
        }
    }

    public void play(Context c) {
        
    	if(isPausing && mPlayer != null) {
    		mPlayer.start();
    		isPausing = false;
    		return;
    	}
    	
        stop();

        mPlayer = MediaPlayer.create(c, R.raw.one_small_step);
        
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                stop();
            }
        });

        mPlayer.start();
    }
    
    public boolean isPlaying() {
        return mPlayer != null;
    }
    
}
