package com.ldl.dailyreminders.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ldl.dailyreminders.databinding.ReminderCourseBinding;
import com.ldl.dailyreminders.databinding.ReminderWeatherBinding;
/**
 * @author Sleepker
 * @time 2021/4/27 11:17
 */
public class Reminder_weatherActivity extends AppCompatActivity {

    private ReminderWeatherBinding reminderWeatherBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        reminderWeatherBinding = ReminderWeatherBinding.inflate(getLayoutInflater());
        setContentView(reminderWeatherBinding.getRoot());
    }
}