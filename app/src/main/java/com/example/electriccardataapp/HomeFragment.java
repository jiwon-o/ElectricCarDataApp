package com.example.electriccardataapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {
    Animation animation_btn;
    private View view;
    ImageView changeImage;
    boolean start;

    // Animation animation_battery = AnimationUtils.loadAnimation(getContext(),R.anim.fade);


  //  private int someStateValue;
//    private final String SOME_VALUE_KEY = "someValueToSave";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.fragment_home_black, container, false);

//        if (savedInstanceState != null) {
//            someStateValue = savedInstanceState.getInt(SOME_VALUE_KEY);
//            // Do something with value if needed
//        }

        changeImage = (ImageView) view.findViewById(R.id.btn_red);
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

                            //자동차 로그인 성공시 , 받아오는 데이터랑 일치한다면,
                   /*
                    if(== ???){
                        changeImage.setImageResource(R.drawable.btn_circle_green);//초록색 버튼으로 바꾼다.
                    }
                   */
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

        return view;
    }

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        if (savedInstanceState != null) {
//            //Restore the fragment's state here
//        }
//
//    }
//
//    @Override
//    public void onSaveInstanceState(@NonNull Bundle outState) {
//
//
//        //Save the fragment's state here
//    //    outState.putInt(SOME_VALUE_KEY, someStateValue);
//        super.onSaveInstanceState(outState);
//    }
//


}
