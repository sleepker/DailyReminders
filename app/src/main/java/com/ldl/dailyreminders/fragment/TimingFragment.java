package com.ldl.dailyreminders.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ldl.dailyreminders.entity.Clock;
import com.ldl.dailyreminders.databinding.FragmentTimingBinding;
import com.ldl.dailyreminders.util.TimeAdapter;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class TimingFragment extends Fragment {
    //闹钟数组
    public static List<Clock> list = new ArrayList<>();
    //适配器
    public static TimeAdapter timeAdapter;
    //初始化视图
    RecyclerView recyclerView;
    private FragmentTimingBinding fragmentTimingBinding;

    Activity mActivity;



    public TimingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentTimingBinding = FragmentTimingBinding.inflate(inflater);

        LitePal.getDatabase();
        initRecyclerView();
        return fragmentTimingBinding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        initRecyclerView();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = activity;
    }

    private void initRecyclerView() {
        recyclerView = fragmentTimingBinding.rvTimingList;
        LinearLayoutManager layoutManager = new LinearLayoutManager(mActivity);
        recyclerView.setLayoutManager(layoutManager);
        timeAdapter = new TimeAdapter(list, mActivity);
        recyclerView.setAdapter(timeAdapter);
        list.clear();
        List<Clock> list1 = DataSupport.findAll(Clock.class);
        for (Clock clock : list1) {
            list.add(clock);
        }
        timeAdapter.notifyDataSetChanged();
    }
}