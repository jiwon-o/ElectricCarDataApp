package com.example.electriccardataapp;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DoorActivity extends AppCompatActivity {

    private ToggleButton doorLockBtn;
    private ToggleButton frontLeftLockBtn;
    private ToggleButton frontRightLockBtn;
    private ToggleButton backLeftLockBtn;
    private ToggleButton backRightLockBtn;

    private ImageView backImage;
    private FrameLayout openWarningImage;
    private TextView doorLockText;
    private TextView btnToUnlockText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_door);

        backImage = findViewById(R.id.image_back);
        openWarningImage = findViewById(R.id.img_openWarning);

        buttonAnimation(openWarningImage);

        doorLockBtn = (ToggleButton) findViewById(R.id.door_black_btn);
        frontLeftLockBtn = (ToggleButton) findViewById(R.id.btn_door_fl);
        frontRightLockBtn = (ToggleButton) findViewById(R.id.btn_door_fr);
        backLeftLockBtn = (ToggleButton) findViewById(R.id.btn_door_bl);
        backRightLockBtn = (ToggleButton) findViewById(R.id.btn_door_br);
        doorLockText = (TextView) findViewById(R.id.tv_doorLock);
        btnToUnlockText = (TextView) findViewById(R.id.tv_btnToUnlock);


        // Back button
        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        // Click listener for each door button
        frontLeftLockBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (frontLeftLockBtn.isChecked()) {
                    frontLeftLockBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_door_front_left_unlock));
                } else {
                    frontLeftLockBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_door_front_left_lock));
                }
            }
        });

        frontRightLockBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (frontRightLockBtn.isChecked()) {
                    frontRightLockBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_door_front_right_unlock));
                } else {
                    frontRightLockBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_door_front_right_lock));
                }
            }
        });

        backLeftLockBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (backLeftLockBtn.isChecked()) {
                    backLeftLockBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_door_back_left_unlock));
                } else {
                    backLeftLockBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_door_back_left_lock));
                }
            }
        });

        backRightLockBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (backRightLockBtn.isChecked()) {
                    backRightLockBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_door_back_right_unlock));
                } else {
                    backRightLockBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_door_back_right_lock));
                }
            }
        });

        // Door lock button
        doorLockBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (doorLockBtn.isChecked()) {
                    doorLockBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_circle_unlock));
                    doorLockText.setText("Doors Unlock");
                    btnToUnlockText.setText("Tap the button to lock");

                    frontLeftLockBtn.setChecked(true);
                    frontRightLockBtn.setChecked(true);
                    backLeftLockBtn.setChecked(true);
                    backRightLockBtn.setChecked(true);

                    if (frontLeftLockBtn.isChecked()) {
                        frontLeftLockBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_door_front_left_unlock));
                    } else {
                        frontLeftLockBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_door_front_left_lock));
                    }

                    if (frontRightLockBtn.isChecked()) {
                        frontRightLockBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_door_front_right_unlock));
                    } else {
                        frontRightLockBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_door_front_right_lock));
                    }

                    if (backLeftLockBtn.isChecked()) {
                        backLeftLockBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_door_back_left_unlock));
                    } else {
                        backLeftLockBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_door_back_left_lock));
                    }

                    if (backRightLockBtn.isChecked()) {
                        backRightLockBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_door_back_right_unlock));
                    } else {
                        backRightLockBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_door_back_right_lock));
                    }

                } else {
                    doorLockBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_circle_lock));
                    doorLockText.setText("Doors Lock");
                    btnToUnlockText.setText("Tap the button to unlock");

                    frontLeftLockBtn.setChecked(false);
                    frontRightLockBtn.setChecked(false);
                    backLeftLockBtn.setChecked(false);
                    backRightLockBtn.setChecked(false);

                    if (frontLeftLockBtn.isChecked()) {
                        frontLeftLockBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_door_front_left_unlock));
                    } else {
                        frontLeftLockBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_door_front_left_lock));
                    }

                    if (frontRightLockBtn.isChecked()) {
                        frontRightLockBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_door_front_right_unlock));
                    } else {
                        frontRightLockBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_door_front_right_lock));
                    }

                    if (backLeftLockBtn.isChecked()) {
                        backLeftLockBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_door_back_left_unlock));
                    } else {
                        backLeftLockBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_door_back_left_lock));
                    }

                    if (backRightLockBtn.isChecked()) {
                        backRightLockBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_door_back_right_unlock));
                    } else {
                        backRightLockBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_door_back_right_lock));
                    }
                }
            }
        });
    }

    //Animation function
    private void buttonAnimation(FrameLayout openButtonImage) {
        //You can check the animation you received in the anim folder.
        Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.flash_animation);
        openButtonImage.startAnimation(startAnimation);
    }
}