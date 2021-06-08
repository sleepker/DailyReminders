package com.ldl.dailyreminders.activities;

import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.ldl.dailyreminders.antity.Clock;
import com.ldl.dailyreminders.databinding.ReminderTimingBinding;

import java.util.Calendar;

/**
 * @author Sleepker
 * @time 2021/4/27 10:58
 */
@RequiresApi(api = Build.VERSION_CODES.O)
public class Reminder_timingActivity extends AppCompatActivity {

    private ReminderTimingBinding reminderTimingBinding;
    private Calendar calendar;
    String hourformat;
    String minuteformat;
    Clock clock = new Clock();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        reminderTimingBinding = ReminderTimingBinding.inflate(getLayoutInflater());
        setContentView(reminderTimingBinding.getRoot());

        calendar = Calendar.getInstance();
        initView();
    }

    private void initView() {
        //设置时间
        reminderTimingBinding.rlTimingSelectTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTime();
            }
        });
    }
/**
 * @description 设置时间
 * @author Sleepker
 * @time 2021/6/8 11:07
 */
    private void setTime(){

        int mhour = calendar.get(Calendar.HOUR_OF_DAY);
        int mminute = calendar.get(Calendar.MINUTE);
        new TimePickerDialog(Reminder_timingActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                //calendar.setTimeInMillis(System.currentTimeMillis());
                calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                calendar.set(Calendar.MINUTE, minute);
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);
                hourformat = format(hourOfDay);
                minuteformat = format(minute);
                Toast.makeText(Reminder_timingActivity.this, "" + hourformat + ":" + minuteformat, Toast.LENGTH_SHORT).show();
                reminderTimingBinding.tvTimeHour.setText(hourformat);
                reminderTimingBinding.tvTimingMinute.setText(minuteformat);
            }
        }, mhour, mminute, true).show();

        reminderTimingBinding.rlTime.setVisibility(View.VISIBLE);
    }
/**
 * @description 格式转换
 * @author Sleepker
 * @time 2021/6/8 11:07
 */
    private String format(int x) {
        String s = "" + x;
        if (s.length() == 1) {
            s = "0" + s;
        }
        return s;
    }
}