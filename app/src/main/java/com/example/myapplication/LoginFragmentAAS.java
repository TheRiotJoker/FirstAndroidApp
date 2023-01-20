package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication.databinding.FragmentFirstBinding;

public class LoginFragmentAAS extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                //NavHostFragment.findNavController(FirstFragment.this)
                        //.navigate(R.id.action_FirstFragment_to_SecondFragment);
                EditText passwordField = view.findViewById(R.id.passwordField);
                EditText usernameField = view.findViewById(R.id.userNameField);
                Switch adminSwitch = view.findViewById(R.id.admin);
                TextView errorView = view.findViewById(R.id.errorView);
                LoginK loginK = new LoginK();
                boolean success = loginK.pruefeLogin(usernameField.getText().toString(), passwordField.getText().toString(),adminSwitch.isChecked());
                if(success) {
                    if(adminSwitch.isChecked()) {
                        passwordField.setText("");
                        usernameField.setText("");
                        adminSwitch.setChecked(false);
                        NavHostFragment.findNavController(LoginFragmentAAS.this).navigate(R.id.action_FirstFragment_to_adminFragmentAS);
                    }
                } else {
                    errorView.setTextColor(Color.rgb(255,0,0));
                    errorView.setText(R.string.WrongInputText);

                }
                /*
                TextView tv = view.findViewById(R.id.textview_first);
                if(et.getText().toString().equalsIgnoreCase("pwd")) {
                    NavHostFragment.findNavController(LoginFragmentAAS.this).navigate(R.id.action_FirstFragment_to_SecondFragment);
                } else {
                    tv.setText(R.string.WrongInputText);
                }
                */
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}