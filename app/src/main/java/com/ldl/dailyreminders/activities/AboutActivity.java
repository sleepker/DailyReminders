package com.ldl.dailyreminders.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.ldl.dailyreminders.databinding.AboutBinding;

public class AboutActivity extends AppCompatActivity {

    //Binding
    private AboutBinding aboutBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        aboutBinding = AboutBinding.inflate(getLayoutInflater());
        setContentView(aboutBinding.getRoot());

        initView();
    }

    private void initView(){
        //关闭按钮
        aboutBinding.btnAboutShutdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}