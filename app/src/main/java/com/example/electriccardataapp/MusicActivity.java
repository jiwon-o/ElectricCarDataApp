package com.example.electriccardataapp;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MusicActivity extends AppCompatActivity {

    private ImageView backImage;
    private ImageView playImage;

    private boolean i = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        backImage = findViewById(R.id.image_back);

        // Back button
        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        ListView listview;
        ListViewAdapter adapter;

        adapter = new ListViewAdapter();

        listview = (ListView) findViewById(R.id.lv_music);
        listview.setAdapter(adapter);

        //add list of Music player here.
        adapter.addItem("Schubert : impromptu 90-2", "28:07");
        adapter.addItem("Piano Sonata no.8 - II", "03:04");
        adapter.addItem("Moonlight Sonata", "05:25");
        adapter.addItem("Violin Concerto No. 1 in G Minor", "06:36");
        adapter.addItem("Swan Lake, Ballet Suite, Op. 20", "07:49");
        adapter.addItem("Violin Romance No.2 In F Major OP 50", "08:64");
        adapter.addItem("Serenade Op.15 - N.7", "03:00");
        adapter.addItem("Symphony No. 101 in D Major", "05:25");
        adapter.addItem("Chopin: Nocturne Opus 9 No. 2", "03:21");
        adapter.addItem("Andrew Lloyd Webber: Memory", "28:07");
        adapter.addItem("Variations On The Cannon", "03:02");


        // Define click event handler in the listview created above
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                // get item
                ListViewItem item = (ListViewItem) parent.getItemAtPosition(position);

                String titleStr = item.getTitle();
                String descStr = item.getDesc();

                // TODO : use item data.
            }
        });

        playImage = findViewById(R.id.img_play);

        playButton(playImage);
    }

    private void playButton(ImageView playImage) {
        playImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == true) {
                    playImage.setImageResource(R.drawable.ic_play_pause);
                    i = false;
                } else {
                    playImage.setImageResource(R.drawable.ic_play_red);
                    i = true;
                }
            }
        });
    }

}
