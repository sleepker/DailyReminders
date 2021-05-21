package com.ldl.dailyreminders.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ldl.dailyreminders.databinding.ReminderClockinBinding;
import com.ldl.dailyreminders.databinding.ReminderCourseBinding;
/**
 * @author Sleepker
 * @time 2021/4/27 11:17
 */
public class Reminder_courseActivity extends AppCompatActivity {

    private ReminderCourseBinding reminderCourseBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        reminderCourseBinding = ReminderCourseBinding.inflate(getLayoutInflater());
        setContentView(reminderCourseBinding.getRoot());
    }
}