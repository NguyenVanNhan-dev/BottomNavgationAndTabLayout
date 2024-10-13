package com.example.bt;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SettingFragment extends Fragment {

    private Button btnChangeToVi;
    private Button btnChangeToEn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        btnChangeToVi = view.findViewById(R.id.toVIButton);
        btnChangeToEn = view.findViewById(R.id.toENButton);

        
        btnChangeToVi.setOnClickListener(this::changeLanguage);
        btnChangeToEn.setOnClickListener(this::changeLanguage);

        return view;
    }

    private void changeLanguage(View view) {
        if (view == btnChangeToEn) {
            ContextUltis.language = "en"; 
        } else if (view == btnChangeToVi) {
            ContextUltis.language = "vi"; 
        }
        
        ((MainActivity) getActivity()).restartActivity();
    }
}
