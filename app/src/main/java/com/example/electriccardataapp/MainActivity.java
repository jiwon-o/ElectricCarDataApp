package com.example.electriccardataapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView bottomNavigationView;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private Fragment HomeFragment;
    private Fragment DataFragment;
    private Fragment ControlFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);


        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {


            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.action_home:
                        setFrag(0);
                        break;
                    case R.id.action_control:
                        setFrag(1);
                        break;
                    case R.id.action_data:
                        setFrag(2);
                        break;
                }
                return true;
            }
        });
        HomeFragment = new HomeFragment();
        DataFragment = new DataFragment();
        ControlFragment = new ControlFragment();

        setFrag(0);//첫 프래그머트 화면 지정

    }

//    @Override
//    protected void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//
//        getSupportFragmentManager().putFragment(outState,"mHomeFragment",mHomeFragment);
//    }



    private void setFrag(int n ){
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction =fragmentManager.beginTransaction();

        switch (n){
            case 0:
                fragmentTransaction.replace(R.id.frame_layout, HomeFragment);
                fragmentTransaction.commit();
                break;
            case 1:
                fragmentTransaction.replace(R.id.frame_layout,ControlFragment);
                fragmentTransaction.commit();
                break;
            case 2:
                fragmentTransaction.replace(R.id.frame_layout,DataFragment);
                fragmentTransaction.commit();
                break;

        }

    }
}