package com.example.electriccardataapp;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {
    Animation animation_btn;
    private View view;
    ImageView changeImage;
    boolean start;
    TextView textBattery;
    int i=0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home_black, container, false);

        changeImage = (ImageView) view.findViewById(R.id.btn_red);
        buttonAnimation(changeImage);
        textBattery = (TextView)view.findViewById(R.id.textView_Battery);

        return view;
    }

    private void buttonAnimation(ImageView changeImage){
        changeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeImage.setImageResource(R.drawable.btn_circle_blue);

                if (!start) {
                    start = true;

                    animation_btn.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) { }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            changeImage.setImageResource(R.drawable.btn_circle_green);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) { }
                    });

                    changeImage.startAnimation(animation_btn);

                } else {
                    start = false;
                    changeImage.setImageResource(R.drawable.btn_circle_red);
                }


            }


        });

        animation_btn = new AlphaAnimation(0.0f,1.0f);
        animation_btn.setDuration(50);
        animation_btn.setRepeatMode(Animation.REVERSE);
        animation_btn.setRepeatCount(14);//Animation.INFINTE
    }

    Handler handler = new Handler(){
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
                while(true){
                    try{
                        handler.sendMessage(handler.obtainMessage());
                        Thread.sleep(10);
                    }catch (Throwable throwable){

                    }
                }
            }
        });
        myThread.start();
    }

    private void updateThread(){
        i++;
        if(i<=98){
            textBattery.setText(String.valueOf(i));
        }
    }

}
