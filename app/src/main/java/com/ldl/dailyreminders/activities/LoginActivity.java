package com.ldl.dailyreminders.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ldl.dailyreminders.databinding.LoginBinding;
/**
 * @author Sleepker
 * @time 2021/4/27 15:17
 */
public class LoginActivity extends AppCompatActivity {

    LoginBinding loginBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginBinding = LoginBinding.inflate(getLayoutInflater());
        setContentView(loginBinding.getRoot());

        setOnClick();
    }
/**
 * @description setOnClick
 * @author Sleepker
 * @time 2021/5/5 20:33
 */
    private void setOnClick() {
        //Login shutdown
        loginBinding.btnLoginShutdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //Login skip
        loginBinding.tvLoginSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
            }
        });
        //login by phone
        loginBinding.tvLoginLoginPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,SignInActivity.class));
            }
        });
    }
}