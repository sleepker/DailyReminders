package com.ldl.dailyreminders.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ldl.dailyreminders.R;
import com.ldl.dailyreminders.activities.Reminder_timingActivity;
import com.ldl.dailyreminders.databinding.FragmentAddreminderBinding;


public class AddreminderFragment extends Fragment {

    private FragmentAddreminderBinding fragmentAddreminderBinding;

    public AddreminderFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentAddreminderBinding = FragmentAddreminderBinding.inflate(inflater);
        return fragmentAddreminderBinding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        initView();
    }

    private void initView() {
        fragmentAddreminderBinding.btnAddReminderTiming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Reminder_timingActivity.class));
            }
        });
    }
}