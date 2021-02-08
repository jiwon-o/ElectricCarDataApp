package com.example.electriccardataapp;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LightActivity extends AppCompatActivity {

    ImageView backImage;
    RadioButton headOffButton;
    RadioButton domeOffButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);
        backImage = findViewById(R.id.image_back);
        headOffButton = findViewById(R.id.headOffButton);
        domeOffButton = findViewById(R.id.domeOffButton);

        // Back button
        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

}
