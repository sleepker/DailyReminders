package com.ldl.dailyreminders.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.ldl.dailyreminders.util.AlarmAlert;

/**
 * @author: Sleepker
 * @date: 2021/6/8
 */
public class CallAlarm extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intent1 = new Intent(context, AlarmAlert.class);
        Bundle bundle = new Bundle();
        //String content = intent.getStringExtra("content");
        //Log.e("content===sadsad",content);
        bundle.putString("STR_CALLER","");
        intent1.putExtras(bundle);
        intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent1);
    }
}
