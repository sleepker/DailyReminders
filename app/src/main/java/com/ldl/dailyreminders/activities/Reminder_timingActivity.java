package com.ldl.dailyreminders.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.ldl.dailyreminders.databinding.ReminderTimingBinding;
/**
 * @author Sleepker
 * @time 2021/4/27 10:58
 */
public class Reminder_timingActivity extends AppCompatActivity {

    private ReminderTimingBinding reminderTimingBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        reminderTimingBinding = ReminderTimingBinding.inflate(getLayoutInflater());
        setContentView(reminderTimingBinding.getRoot());
    }
}