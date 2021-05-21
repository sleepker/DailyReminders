package com.ldl.dailyreminders.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ldl.dailyreminders.R;
import com.ldl.dailyreminders.activities.LoginActivity;
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

    private void initOnclick(){
        fragmentUserBinding.imgBtnUserUserAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}