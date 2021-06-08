package com.ldl.dailyreminders.activities;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.ldl.dailyreminders.entity.Clock;
import com.ldl.dailyreminders.broadcast.CallAlarm;
import com.ldl.dailyreminders.databinding.ReminderTimingBinding;
import com.ldl.dailyreminders.fragment.TimingFragment;
import com.ldl.dailyreminders.util.TimeAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author Sleepker
 * @time 2021/4/27 10:58
 */
@RequiresApi(api = Build.VERSION_CODES.O)
public class Reminder_timingActivity extends AppCompatActivity {

    public static List<Clock> list = TimingFragment.list;
    public static TimeAdapter timeAdapter = TimingFragment.timeAdapter;

    private Calendar calendar;

    private ReminderTimingBinding reminderTimingBinding;

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
/**
 * @description 初始化
 * @author Sleepker
 * @time 2021/6/8 11:20
 */
    private void initView() {
        //设置时间
        reminderTimingBinding.rlTimingSelectTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTime();
            }
        });
        //保存
        reminderTimingBinding.btnTimingSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveTimingReminder();
            }
        });
        //返回
        reminderTimingBinding.btnTimingShutdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
/**
 * @description 保存时间提醒
 * @author Sleepker
 * @time 2021/6/8 11:19
 */
    private void saveTimingReminder() {
        //发广播
        Intent intent = new Intent(Reminder_timingActivity.this, CallAlarm.class);
        PendingIntent sender = PendingIntent.getBroadcast(
                Reminder_timingActivity.this, 0, intent, 0);
        AlarmManager am;
        am = (AlarmManager) getSystemService(ALARM_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (System.currentTimeMillis()>calendar.getTimeInMillis()+40000){
                //加24小时
                am.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis()+86400000, sender);
            }else {
                am.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);
            }
        }
        //初始化clock
        clock.setHour(hourformat);
        clock.setMinute(minuteformat);
        clock.setContent("" + reminderTimingBinding.etTimingNote.getText().toString());
        clock.setClockType(Clock.clock_open);

        if (clock.getHour()!=null&&clock.getMinute()!=null) {
            clock.save();
            list.add(clock);
            timeAdapter.notifyDataSetChanged();
            Log.e("Listnumber======",list.size()+"");
            finish();
        }else {
            Toast.makeText(this, "请选择闹钟时间", Toast.LENGTH_SHORT).show();
        }

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