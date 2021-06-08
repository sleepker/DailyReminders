package com.ldl.dailyreminders.util;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.ldl.dailyreminders.R;
import com.ldl.dailyreminders.broadcast.CallAlarm;
import com.ldl.dailyreminders.databinding.ReminderTimingDetailBinding;
import com.ldl.dailyreminders.entity.Clock;
import com.ldl.dailyreminders.fragment.TimingFragment;

import java.util.Calendar;
import java.util.List;


public class ClockDetail extends AppCompatActivity {

    private ReminderTimingDetailBinding reminderTimingDetailBinding;
    public static List<Clock> list = TimingFragment.list;
    public static TimeAdapter timeAdapter = TimingFragment.timeAdapter;
    private Calendar calendar;
    Clock clock;
    int position;
    String hourformat;
    String minuteformat;
    Context context = ClockDetail.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        reminderTimingDetailBinding = ReminderTimingDetailBinding.inflate(getLayoutInflater());
        setContentView(reminderTimingDetailBinding.getRoot());

        calendar = Calendar.getInstance();
        initView();
        setOnClick();
    }

    private void setOnClick() {

        reminderTimingDetailBinding.btnTimingDetailShutdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        reminderTimingDetailBinding.btnTimingDetailSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clock.setHour(hourformat);
                clock.setMinute(minuteformat);
                clock.setContent("" + reminderTimingDetailBinding.etTimingDetailNote.getText().toString());
                clock.setClockType(Clock.clock_open);
                clock.save();
                Intent intent = new Intent(ClockDetail.this, CallAlarm.class);
                // intent.putExtra("content",clock.getContent());
                //sendBroadcast(intent);
                PendingIntent sender = PendingIntent.getBroadcast(
                        ClockDetail.this, 0, intent, 0);
                AlarmManager am;
                am = (AlarmManager) getSystemService(ALARM_SERVICE);
                Log.e("gethour",clock.getHour());
                Log.e("gethour",clock.getMinute());
                calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(clock.getHour()));
                calendar.set(Calendar.MINUTE, Integer.parseInt(clock.getMinute()));
                Log.e("TAG",calendar.getTimeInMillis()+"");
                Log.e("TAG",System.currentTimeMillis()+"");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    if (System.currentTimeMillis()>calendar.getTimeInMillis()+60000){
                        //加24小时
                        am.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis()+86400000, sender);
                    }else {
                        am.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);
                    }
                }

                timeAdapter.notifyDataSetChanged();
                finish();
            }
        });
        reminderTimingDetailBinding.btnTimingDetailDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clock.delete();
                timeAdapter.notifyDataSetChanged();
                Intent intent1 = new Intent(context, CallAlarm.class);
                PendingIntent sender1=PendingIntent.getBroadcast(
                        context,0, intent1, 0);
                AlarmManager am;
                am = (AlarmManager) getSystemService(ALARM_SERVICE);
                am =(AlarmManager)context.getSystemService(ALARM_SERVICE);
                am.cancel(sender1);
                finish();
            }
        });
        reminderTimingDetailBinding.rlTimingDetailSelectTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar.setTimeInMillis(System.currentTimeMillis());
                int mhour = calendar.get(Calendar.HOUR_OF_DAY);
                int mminute = calendar.get(Calendar.MINUTE);
                new TimePickerDialog(ClockDetail.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        //calendar.setTimeInMillis(System.currentTimeMillis());
                        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        calendar.set(Calendar.MINUTE, minute);
                        calendar.set(Calendar.SECOND, 0);
                        calendar.set(Calendar.MILLISECOND, 0);
                        hourformat = format(hourOfDay);
                        minuteformat = format(minute);
                        Toast.makeText(ClockDetail.this, "" + hourformat + ":" + minuteformat, Toast.LENGTH_SHORT).show();
                        reminderTimingDetailBinding.tvTimeDetailHour.setText(hourformat);
                        reminderTimingDetailBinding.tvTimingDetailMinute.setText(minuteformat);
                    }
                }, mhour, mminute, true).show();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void initView() {
        position = getIntent().getIntExtra("position", -1);
        clock = list.get(position);
        Log.e("position", position + "");
        if (clock.getHour() != null && clock.getMinute() != null) {
            hourformat = formatString(clock.getHour());
            minuteformat = formatString(clock.getMinute());
        }
        reminderTimingDetailBinding.etTimingDetailNote.setText(clock.getContent());
        reminderTimingDetailBinding.tvTimeDetailHour.setText(clock.getHour() + "");
        reminderTimingDetailBinding.tvTimingDetailMinute.setText(clock.getMinute() + "");
    }

    private String format(int x) {
        String s = "" + x;
        if (s.length() == 1) {
            s = "0" + s;
        }
        return s;
    }

    private String formatString(String x) {
        String s = x;
        if (s.length() == 1) {
            s = "0" + s;
        }
        return s;
    }
}
