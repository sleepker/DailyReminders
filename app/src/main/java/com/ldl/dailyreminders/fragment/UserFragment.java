package com.ldl.dailyreminders.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatDelegate;

import com.ldl.dailyreminders.activities.AboutActivity;
import com.ldl.dailyreminders.activities.LoginActivity;
import com.ldl.dailyreminders.databinding.FragmentUserBinding;

import java.util.List;

import static androidx.core.content.ContextCompat.getSystemService;

public class UserFragment extends Fragment {

    //Binding
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
                Intent intent = new Intent();
                intent.setAction(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                intent.setData(Uri.parse("package:" + getActivity().getPackageName()));
                startActivity(intent);
            }
        });
        //反馈与建议点击事件
        fragmentUserBinding.rlUserAdvice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAdviceDialog();
            }
        });
        //帮助与介绍点击事件
        fragmentUserBinding.rlUserHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"待开发",Toast.LENGTH_SHORT).show();
            }
        });
        //关于点击事件
        fragmentUserBinding.rlUserAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AboutActivity.class));
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
        singleChoiceDialog.show();
    }
/**
 * @description showAdviceDialog
 * @author Sleepker
 * @time 2021/5/26 11:13
 */
    private void showAdviceDialog(){
        AlertDialog.Builder adviceDialog = new AlertDialog.Builder(getActivity());
        adviceDialog.setTitle("反馈与建议");
        adviceDialog.setMessage("添加微信，交流反馈");
        adviceDialog.setNegativeButton("复制微信号并打开微信", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ClipboardManager cm = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData mClipData = ClipData.newPlainText("Label", "Q_Q0x6C13FE4A");
                cm.setPrimaryClip(mClipData);
                Toast.makeText(getActivity(),"复制成功并打开微信",Toast.LENGTH_SHORT).show();
                try {
                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    ComponentName cmp = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.LauncherUI");
                    intent.addCategory(Intent.CATEGORY_LAUNCHER);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setComponent(cmp);
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getActivity(), "检查到您手机没有安装微信，请安装后使用该功能", Toast.LENGTH_SHORT).show();
                }
                dialog.dismiss();
            }
        });
        adviceDialog.show();
    }

}