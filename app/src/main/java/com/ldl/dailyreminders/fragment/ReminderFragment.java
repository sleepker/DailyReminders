package com.ldl.dailyreminders.fragment;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.FragmentTransaction;
import androidx.annotation.RequiresApi;
import com.ldl.dailyreminders.R;
import com.ldl.dailyreminders.databinding.FragmentReminderBinding;

public class ReminderFragment extends Fragment {

    //DataBinding
    private FragmentReminderBinding fragmentReminderBinding;
    //Fragment
    private TimingFragment timingFragment = new TimingFragment();
    private LocationFragment locationFragment = new LocationFragment();
    private CountdownFragment countdownFragment = new CountdownFragment();
    private ClockinFragment clockinFragment = new ClockinFragment();
    private CourseFragment courseFragment = new CourseFragment();
    private WeatherFragment weatherFragment = new WeatherFragment();

    public ReminderFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentReminderBinding = FragmentReminderBinding.inflate(inflater);
        // Inflate the layout for this fragment
        return fragmentReminderBinding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        FragmentManager FragmentManager = getFragmentManager();
        initFragment(FragmentManager);
        hideAllFragment(FragmentManager);
        initOnClick(FragmentManager);
        fragmentReminderBinding.btnFlReminderTiming.performClick();
    }

    private void initOnClick(final FragmentManager fragmentManager) {

        fragmentReminderBinding.btnFlReminderTiming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideAllFragment(fragmentManager);
                showFragment(fragmentManager,timingFragment);
            }
        });
        fragmentReminderBinding.btnFlReminderLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideAllFragment(fragmentManager);
                showFragment(fragmentManager,locationFragment);
            }
        });
        fragmentReminderBinding.btnFlReminderCountdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideAllFragment(fragmentManager);
                showFragment(fragmentManager,countdownFragment);
            }
        });
        fragmentReminderBinding.btnFlReminderClockIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideAllFragment(fragmentManager);
                showFragment(fragmentManager,clockinFragment);
            }
        });
        fragmentReminderBinding.btnFlReminderCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideAllFragment(fragmentManager);
                showFragment(fragmentManager,courseFragment);
            }
        });
        fragmentReminderBinding.btnFlReminderWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideAllFragment(fragmentManager);
                showFragment(fragmentManager,weatherFragment);
            }
        });

    }

    private void initFragment(FragmentManager fragmentManager){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (!timingFragment.isAdded()){
            fragmentTransaction.add(R.id.fl_fl_reminder_content,timingFragment);
        }
        if (!locationFragment.isAdded()){
            fragmentTransaction.add(R.id.fl_fl_reminder_content,locationFragment);
        }
        if (!countdownFragment.isAdded()){
            fragmentTransaction.add(R.id.fl_fl_reminder_content,countdownFragment);
        }
        if (!clockinFragment.isAdded()){
            fragmentTransaction.add(R.id.fl_fl_reminder_content,clockinFragment);
        }
        if (!courseFragment.isAdded()){
            fragmentTransaction.add(R.id.fl_fl_reminder_content,courseFragment);
        }
        if (!weatherFragment.isAdded()){
            fragmentTransaction.add(R.id.fl_fl_reminder_content,weatherFragment);
        }
        fragmentTransaction.commit();
    }
    private void hideAllFragment(FragmentManager fragmentManager){
        @SuppressLint("CommitTransaction") FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (!timingFragment.isHidden()){
            fragmentTransaction.hide(timingFragment);
        }
        if (!locationFragment.isHidden()){
            fragmentTransaction.hide(locationFragment);
        }
        if (!countdownFragment.isHidden()){
            fragmentTransaction.hide(countdownFragment);
        }
        if (!clockinFragment.isHidden()){
            fragmentTransaction.hide(clockinFragment);
        }
        if (!courseFragment.isHidden()){
            fragmentTransaction.hide(courseFragment);
        }
        if (!weatherFragment.isHidden()){
            fragmentTransaction.hide(weatherFragment);
        }
        fragmentTransaction.commit();
    }
    private void showFragment(FragmentManager fragmentManager, Fragment fragment){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.show(fragment);
        fragmentTransaction.commit();
    }

}