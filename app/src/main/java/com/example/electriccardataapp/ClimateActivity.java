package com.example.electriccardataapp;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ClimateActivity extends AppCompatActivity {

    ImageView blackButtonImage;
    ImageView backImage;
    TextView blackButtonText1;
    TextView blackButtonText2;
    TextView temperatureNum;
    ImageView upButtonImage;
    ImageView downButtonImage;
    ImageView autoButtonImage;
    ImageView coolButtonImage;
    ImageView dryButtonImage;
    ImageView autoImage;
    ImageView coolImage;
    ImageView dryImage;
    TextView autoText;
    TextView coolText;
    TextView dryText;

    int btnClick = 0;
    int count = 70;
    boolean i = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_climate);

        backImage = findViewById(R.id.image_back);
        blackButtonImage = findViewById(R.id.temperature_black_btn);
        blackButtonText1 = findViewById(R.id.black_btn_text1);
        blackButtonText2 = findViewById(R.id.black_btn_text2);
        temperatureNum = findViewById(R.id.temperature_Number);
        upButtonImage = findViewById(R.id.temperature_up_btn);
        downButtonImage = findViewById(R.id.temperature_down_btn);
        autoButtonImage = findViewById(R.id.temperature_auto_btn);
        coolButtonImage = findViewById(R.id.temperature_cool_btn);
        dryButtonImage = findViewById(R.id.temperature_dry_btn);
        autoImage = findViewById(R.id.img_auto);
        coolImage = findViewById(R.id.img_cool);
        dryImage = findViewById(R.id.img_dry);
        autoText = findViewById(R.id.tv_auto);
        coolText = findViewById(R.id.tv_cool);
        dryText = findViewById(R.id.tv_dry);

        backButton(backImage);

        temperatureButton(blackButtonImage);

        autoButton(autoButtonImage);
        coolButton(coolButtonImage);
        dryButton(dryButtonImage);

        upDownButton upDownButton = new upDownButton();
        temperatureNum.setText(count + "");
        upButtonImage.setOnClickListener(upDownButton);
        downButtonImage.setOnClickListener(upDownButton);

    }

    // Back button function
    private void backButton(ImageView backImage) {
        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    //Climate On/Off button
    private void temperatureButton(ImageView blackButtonImage) {
        blackButtonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnClick % 2 == 0) {
                    blackButtonImage.setImageResource(R.drawable.btn_circle_red);
                    blackButtonText1.setText("A/C is ON");
                    blackButtonText2.setText("Tap the button to off");
                    btnClick++;
                } else if (btnClick % 2 == 1) {
                    blackButtonImage.setImageResource(R.drawable.btn_circle_black);
                    blackButtonText1.setText("A/C is OFF");
                    blackButtonText2.setText("Tap the button to on");
                    btnClick++;
                }

            }
        });
    }

    //Toast when pressing the temperature button without turning on the power
    public static void setCustomToast(Context context) {
        TextView view = new TextView(context);
        view.setBackgroundResource(R.color.background_black);

        final Toast toast = Toast.makeText(context, "Please, turn on the A/C first.", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, Gravity.CENTER_HORIZONTAL, Gravity.CENTER_VERTICAL);
        toast.show();
    }

    class upDownButton implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (btnClick % 2 == 1) {
                switch (v.getId()) {
                    case R.id.temperature_up_btn: {
                        if (count < 85) {
                            count = count + 1;
                        }
                        temperatureNum.setText(count + "");
                        break;
                    }
                    case R.id.temperature_down_btn: {
                        if (count > 65) {
                            count = count - 1;
                        }
                        temperatureNum.setText(count + "");
                        break;
                    }
                }
            } else if (btnClick % 2 == 0) {
                switch (v.getId()) {
                    case R.id.temperature_up_btn:
                    case R.id.temperature_down_btn: {
                        setCustomToast(getApplicationContext());
                        break;
                    }
                }
            }
        }
    }


    private void autoButton(ImageView autoButtonImage) {
        autoButtonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == true) {
                    autoImage.setImageResource(R.drawable.ic_mode_auto_red);
                    autoText.setTextColor(Color.RED);
                    i = false;
                } else {
                    autoImage.setImageResource(R.drawable.ic_mode_auto);
                    autoText.setTextColor(Color.WHITE);
                    i = true;
                }
            }
        });
    }

    private void coolButton(ImageView coolButtonImage) {
        coolButtonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == true) {
                    coolImage.setImageResource(R.drawable.ic_mode_cool_red);
                    coolText.setTextColor(Color.RED);
                    i = false;
                } else {
                    coolImage.setImageResource(R.drawable.ic_mode_cool);
                    coolText.setTextColor(Color.WHITE);
                    i = true;
                }
            }
        });
    }

    private void dryButton(ImageView dryButtonImage) {
        dryButtonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == true) {
                    dryImage.setImageResource(R.drawable.ic_mode_dry_red);
                    dryText.setTextColor(Color.RED);
                    i = false;
                } else {
                    dryImage.setImageResource(R.drawable.ic_mode_dry);
                    dryText.setTextColor(Color.WHITE);
                    i = true;
                }
            }
        });
    }



}
