package com.ldl.dailyreminders.fragment;

import android.app.AlertDialog;
import android.app.VoiceInteractor;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatDelegate;

import com.ldl.dailyreminders.R;
import com.ldl.dailyreminders.activities.LoginActivity;
import com.ldl.dailyreminders.activities.MainActivity;
import com.ldl.dailyreminders.databinding.FragmentUserBinding;

public class UserFragment extends Fragment {

    private FragmentUserBinding fragmentUserBinding;
    public UserFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentUserBinding = FragmentUserBinding.inflate(inflater);
        // Inflate the layout for this fragment
        return fragmentUserBinding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        initOnclick();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    private void initOnclick(){
        //用户头像点击事件
        fragmentUserBinding.imgBtnUserUserAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),LoginActivity.class);
                startActivity(intent);
            }
        });
        //账户与安全点击事件
        fragmentUserBinding.rlUserClickLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),LoginActivity.class);
                startActivity(intent);
            }
        });
        //夜间模式点击事件
        fragmentUserBinding.rlUserNight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSingleChoiceDialog();
            }
        });
        //设置点击事件
        fragmentUserBinding.rlUserSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //反馈与建议点击事件
        fragmentUserBinding.rlUserAdvice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //帮助与介绍点击事件
        fragmentUserBinding.rlUserHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //关于点击事件
        fragmentUserBinding.rlUserAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
/**
 * @description showSingleChoiceDialog
 * @author Sleepker
 * @time 2021/5/25 15:46
 */
    int defaultItem;
    private void showSingleChoiceDialog(){
        AlertDialog.Builder singleChoiceDialog = new AlertDialog.Builder(getActivity());
        final String[] items = { "系统默认","浅色","深色" };
        singleChoiceDialog.setTitle("主题背景");
        //获取当前主题状态
        int currentNightMode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        if (currentNightMode == Configuration.UI_MODE_NIGHT_YES) {
            defaultItem = 2;
        }
        singleChoiceDialog.setSingleChoiceItems(items, defaultItem,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case 0:
                                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                                break;
                            case 1:
                                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                                break;
                            case 2:
                                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                                break;
                            default:
                        }
                        defaultItem = which;
                        dialog.dismiss();
                    }
                });
        singleChoiceDialog.setNegativeButton("取消",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        //获取当前主题模式
//        int currentNightMode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
//        if (currentNightMode == Configuration.UI_MODE_NIGHT_YES){
//            defaultItem = 2;
//        switch (currentNightMode) {
//            case Configuration.UI_MODE_NIGHT_NO:
//                defaultItem = 1;//当前为浅色
//                break;
//            case Configuration.UI_MODE_NIGHT_YES:
//                defaultItem = 2;//当前为深色
//                break;
//            default:
//                defaultItem = 0;
//        }
        singleChoiceDialog.show();
    }
}