package com.ldl.dailyreminders.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ldl.dailyreminders.databinding.ReminderLocationBinding;
/**
 * @author Sleepker
 * @time 2021/4/27 11:17
 */
public class Reminder_locationActivity extends AppCompatActivity {

    private ReminderLocationBinding reminderLocationBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        reminderLocationBinding = ReminderLocationBinding.inflate(getLayoutInflater());
        setContentView(reminderLocationBinding.getRoot());
    }
}