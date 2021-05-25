package com.ldl.dailyreminders.activities;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Fragment;
import com.ldl.dailyreminders.R;
import com.ldl.dailyreminders.databinding.MainBinding;
import com.ldl.dailyreminders.fragment.AddreminderFragment;
import com.ldl.dailyreminders.fragment.ReminderFragment;
import com.ldl.dailyreminders.fragment.UserFragment;

/**
 * @author Sleepker
 * @time 2021/4/27 10:39
 */
public class MainActivity extends AppCompatActivity {

    //Binding
    private MainBinding mainBinding;
    //Fragment
    private ReminderFragment reminderFragment = new ReminderFragment();
    private AddreminderFragment addreminderFragment = new AddreminderFragment();
    private UserFragment userFragment = new UserFragment();
    //FragmentManager
    FragmentManager fragmentManager = getFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = MainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        //initFragment
        initFragment(fragmentManager);
        //setOnClick
        setOnClick();
        //performClick imgBtn BottomReminder
        mainBinding.includeBottom.imgBtnBottomReminder.performClick();

    }
    /**
     * @description initView
     * @author Sleepker
     * @time 2021/4/27 10:39
     */
    private void setOnClick() {

        //bottom_init
        mainBinding.includeBottom.imgBtnBottomReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideAllFragment(fragmentManager);
                showFragment(fragmentManager,reminderFragment);
            }
        });
        mainBinding.includeBottom.imgBtnBottomAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideAllFragment(fragmentManager);
                showFragment(fragmentManager,addreminderFragment);
            }
        });
        mainBinding.includeBottom.imgBtnBottomUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideAllFragment(fragmentManager);
                showFragment(fragmentManager,userFragment);
            }
        });

    }
    /**
     * @description initFragment
     * @author Sleepker
     * @time 2021/5/11 13:50
     */
    private void initFragment(FragmentManager fragmentManager){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (!reminderFragment.isAdded()){
            fragmentTransaction.add(R.id.fl_main_content,reminderFragment);
        }
        if (!addreminderFragment.isAdded()){
            fragmentTransaction.add(R.id.fl_main_content,addreminderFragment);
        }
        if (!userFragment.isAdded()){
            fragmentTransaction.add(R.id.fl_main_content,userFragment);
        }
        fragmentTransaction.commit();
    }
    /**
     * @description hideAllFragment
     * @author Sleepker
     * @time 2021/5/11 13:51
     */
    private void hideAllFragment(FragmentManager fragmentManager){
        @SuppressLint("CommitTransaction") FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (!reminderFragment.isHidden()){
            fragmentTransaction.hide(reminderFragment);
        }
        if (!addreminderFragment.isHidden()){
            fragmentTransaction.hide(addreminderFragment);
        }
        if (!userFragment.isHidden()){
            fragmentTransaction.hide(userFragment);
        }
        fragmentTransaction.commit();
    }
    /**
     * @description showFragment
     * @author Sleepker
     * @time 2021/5/11 11:06
     */
    private void showFragment(FragmentManager fragmentManager, Fragment fragment){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.show(fragment);
        fragmentTransaction.commit();
    }

}