package com.ldl.dailyreminders.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ldl.dailyreminders.databinding.ReminderClockinBinding;

/**
 * @author Sleepker
 * @time 2021/4/27 11:17
 */
public class Reminder_clockinActivity extends AppCompatActivity {

    private ReminderClockinBinding reminderClockinBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        reminderClockinBinding = ReminderClockinBinding.inflate(getLayoutInflater());
        setContentView(reminderClockinBinding.getRoot());
    }
}