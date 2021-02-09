package com.example.electriccardataapp;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    private View view;

    private Animation animation_btn;
    private ImageView changeImage;
    private TextView textBattery;
    private TextView textRange;
    private TextView textTemp;

    private boolean start;
    private int i = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);

        //get id
        changeImage = (ImageView) view.findViewById(R.id.btn_red);

        textBattery = (TextView) view.findViewById(R.id.textView_Battery);
        textRange = (TextView) view.findViewById(R.id.textView_Range);
        textTemp = (TextView) view.findViewById(R.id.textView_Temp);

        //start buttonAnimation
        buttonAnimation(changeImage);
        //start flash_animation
        flashAnimation(textRange);
        flashAnimation(textTemp);

        return view;
    }

    //You can customize the animation that comes out when you press the button.
    private void buttonAnimation(ImageView changeImage) {
        changeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeImage.setImageResource(R.drawable.btn_circle_blue);

                if (!start) {
                    start = true;
                    animation_btn.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            changeImage.setImageResource(R.drawable.btn_circle_green);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {
                        }
                    });

                    changeImage.startAnimation(animation_btn);

                } else {
                    start = false;
                    changeImage.setImageResource(R.drawable.btn_circle_red);
                }
            }
        });

        //set transparency (cf) Acceptaable Range : 0.0f ~ 1.0f)
        animation_btn = new AlphaAnimation(0.0f, 1.0f);
        //set motion cycle (cf) 1second = 1000)
        animation_btn.setDuration(50);
        //set how to repeat
        animation_btn.setRepeatMode(Animation.REVERSE);
        //set number of iterations
        animation_btn.setRepeatCount(14);
    }

    //Animation function
    private void flashAnimation(TextView recTextView) {
        //You can check the animation you received in the anim folder.
        Animation startAnimation = AnimationUtils.loadAnimation(this.getContext(), R.anim.flash_one_animation);
        recTextView.startAnimation(startAnimation);
    }

    //Battery numeric increment Motion related code.
    Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            updateThread();
        }
    };

    @Override
    public void onStart() {
        super.onStart();
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        handler.sendMessage(handler.obtainMessage());
                        Thread.sleep(10);//set update time
                    } catch (Throwable throwable) {

                    }
                }
            }
        });
        myThread.start();
    }

    private void updateThread() {
        i++;
        if (i <= 98) {//up to 98
            textBattery.setText(String.valueOf(i));
        }
    }


}
