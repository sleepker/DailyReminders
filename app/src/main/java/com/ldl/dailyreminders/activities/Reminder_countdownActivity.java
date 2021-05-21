package com.ldl.dailyreminders.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ldl.dailyreminders.R;
import com.ldl.dailyreminders.databinding.ReminderCountdownBinding;
import com.ldl.dailyreminders.databinding.ReminderLocationBinding;
/**
 * @author Sleepker
 * @time 2021/4/27 11:17
 */
public class Reminder_countdownActivity extends AppCompatActivity {

    private ReminderCountdownBinding reminderCountdownBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        reminderCountdownBinding = ReminderCountdownBinding.inflate(getLayoutInflater());
        setContentView(reminderCountdownBinding.getRoot());
    }
}