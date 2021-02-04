package com.example.electriccardataapp;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TemperatureActivity extends AppCompatActivity {

    ImageView redButtonImage;
    ImageView backImage;
    TextView redButtonText1;
    TextView redButtonText2;
    TextView temperatureNum;
    ImageView upButtonImage;
    ImageView downButtonImage;

    int btnClick;
    int count=70;
    boolean i = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        backImage = findViewById(R.id.image_back);
        redButtonImage = findViewById(R.id.temperature_red_btn);
        redButtonText1 = findViewById(R.id.red_btn_text1);
        redButtonText2 = findViewById(R.id.red_btn_text2);
        temperatureNum = findViewById(R.id.temperature_Number);
        upButtonImage = findViewById(R.id.temperature_up_btn);
        downButtonImage = findViewById(R.id.temperature_down_btn);

        backButton(backImage);

        temperatureButton(redButtonImage);

        upDownButton upDownButton = new upDownButton();
        temperatureNum.setText(count+"");
        upButtonImage.setOnClickListener(upDownButton);
        downButtonImage.setOnClickListener(upDownButton);

    }


    private void backButton(ImageView backImage){
        btnClick=0;
        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void temperatureButton(ImageView redButtonImage){
        redButtonImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if(btnClick%2==0) {
                    redButtonImage.setImageResource(R.drawable.btn_circle_green);
                    redButtonText1.setText("A/C is ON");
                    redButtonText2.setText("Tap the button to off");
                    btnClick++;
                }else if(btnClick%2==1){
                    redButtonImage.setImageResource(R.drawable.btn_circle_red);
                    redButtonText1.setText("A/C is OFF");
                    redButtonText2.setText("Tap the button to on");
                    btnClick++;
                }

            }

        });
    }

    public static void setCustomToast(Context context){

        TextView view = new TextView(context);
        view.setBackgroundResource(R.color.background_black);

        final Toast toast =  Toast.makeText(context,"Please, turn on the A/C first.",Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,Gravity.CENTER_HORIZONTAL,Gravity.CENTER_VERTICAL);
        toast.show();
    }

    class upDownButton implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            if(btnClick%2==1) {
                switch (v.getId()) {
                    case R.id.temperature_up_btn: {
                        count = count + 1;
                        temperatureNum.setText(count + "");
                        break;
                    }
                    case R.id.temperature_down_btn: {
                        count = count - 1;
                        temperatureNum.setText(count + "");
                        break;
                    }
                }
            }else if(btnClick%2==0){
                switch (v.getId()) {
                    case R.id.temperature_up_btn: {
                        setCustomToast(getApplicationContext());
                        break;
                    }
                    case R.id.temperature_down_btn: {
                        setCustomToast(getApplicationContext());
                        break;
                    }
                }
            }
        }
    }

  





}
