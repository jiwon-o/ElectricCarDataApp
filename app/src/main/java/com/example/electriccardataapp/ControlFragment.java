package com.example.electriccardataapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ControlFragment extends Fragment {
    private View view;
    FrameLayout frameLayoutTemperature;
    FrameLayout frameLayoutBattery;
    FrameLayout frameLayoutCamera;
    FrameLayout frameLayoutDoor;
    FrameLayout frameLayoutEnergy;
    FrameLayout frameLayoutMusic;

    Intent intent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_control, container, false);

        frameLayoutTemperature = (FrameLayout) view.findViewById(R.id.frame_layout_temperature);
        frameLayoutTemperature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), ClimateActivity.class);
                startActivity(intent);
            }
        });

        frameLayoutBattery = (FrameLayout) view.findViewById(R.id.frame_layout_battery);
        frameLayoutBattery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), BatteryActivity.class);
                startActivity(intent);
            }
        });

        frameLayoutCamera = (FrameLayout) view.findViewById(R.id.frame_layout_camera);
        frameLayoutCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), CameraActivity.class);
                startActivity(intent);
            }
        });

        frameLayoutEnergy = (FrameLayout) view.findViewById(R.id.frame_layout_energy);
        frameLayoutEnergy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), LightActivity.class);
                startActivity(intent);
            }
        });

        frameLayoutMusic = (FrameLayout) view.findViewById(R.id.frame_layout_music);
        frameLayoutMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), MusicActivity.class);
                startActivity(intent);
            }
        });

        frameLayoutDoor = (FrameLayout) view.findViewById(R.id.frame_layout_door);
        frameLayoutDoor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), DoorActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }


}