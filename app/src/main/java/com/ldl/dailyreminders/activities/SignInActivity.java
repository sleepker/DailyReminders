package com.ldl.dailyreminders.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ldl.dailyreminders.databinding.SigninBinding;

public class SignInActivity extends AppCompatActivity {

    private SigninBinding signinBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        signinBinding = SigninBinding.inflate(getLayoutInflater());
        setContentView(signinBinding.getRoot());

        setOnClick();
    }

    private void setOnClick() {
        //shutdown
        signinBinding.btnSignInShutdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}