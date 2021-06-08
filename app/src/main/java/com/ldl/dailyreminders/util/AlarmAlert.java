package com.ldl.dailyreminders.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import com.ldl.dailyreminders.R;
/**
 * @author: Sleepker
 * @date: 2021/6/8
 */
public class AlarmAlert extends Activity {
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        int position = getIntent().getIntExtra("position",-1);
        mediaPlayer = MediaPlayer.create(this, R.raw.clockmusic);
        mediaPlayer.start();
        new AlertDialog.Builder(AlarmAlert.this)
                .setIcon(R.drawable.clock)
                .setTitle("闹钟响了")
                .setCancelable(false)
                .setMessage("时间到了！")
                .setPositiveButton("关掉"
                        , new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                AlarmAlert.this.finish();
                                mediaPlayer.stop();
                            }
                        }).show();
    }
}
