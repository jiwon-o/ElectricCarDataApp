package com.example.electriccardataapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;

import java.util.ArrayList;

public class BatteryActivity extends AppCompatActivity {

    private ImageView backImage;
    private PieChart chart_pie;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery);

        // Back button
        backImage = findViewById(R.id.image_back);

        //Backward Button Operation function
        backButton(backImage);

        // You can customize the pie chart of battery graph here.
        chart_pie = findViewById(R.id.chart_pie);
        chart_pie.setUsePercentValues(true);
        chart_pie.getDescription().setEnabled(false);
        chart_pie.setExtraOffsets(5, 10, 5, 5);

        chart_pie.setDragDecelerationFrictionCoef(0.95f);

        chart_pie.setDrawHoleEnabled(true);
        chart_pie.setHoleColor(Color.BLACK);

        chart_pie.setTransparentCircleColor(Color.WHITE);
        chart_pie.setTransparentCircleAlpha(0);

        chart_pie.setHoleRadius(58f);
        chart_pie.setTransparentCircleRadius(65f);

        chart_pie.setRotationAngle(0);
        // enable rotation of the chart by touch
        chart_pie.setRotationEnabled(true);
        chart_pie.setHighlightPerTapEnabled(true);

        chart_pie.animateY(1400, Easing.EaseInOutQuad);
        // chart_pie.spin(2000, 0, 360);

        chart_pie.getLegend().setEnabled(false);

        // entry label styling
        chart_pie.setEntryLabelColor(Color.WHITE);
        chart_pie.setEntryLabelTextSize(11f);

        setData(4, 25);
    }

    //backbutton function
    private void backButton(ImageView backImage){
        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    // get data here
    private void setData(int count, float range) {
        ArrayList<PieEntry> entries = new ArrayList<>();

        // NOTE: The order of the entries when being added to the entries array determines their position around the center of
        // the chart.
        entries.add(new PieEntry((float) ((Math.random() * range) + range / 5), "Driving Meter"));
        entries.add(new PieEntry((float) ((Math.random() * range) + range / 5), "Air Condition"));
        entries.add(new PieEntry((float) ((Math.random() * range) + range / 5), "Battery Field"));
        entries.add(new PieEntry((float) ((Math.random() * range) + range / 5), "Battery Care"));

        PieDataSet dataSet = new PieDataSet(entries, "");

        dataSet.setDrawIcons(false);
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);

        // add a lot of colors
        dataSet.setColors(Color.rgb(140, 26, 28),
                Color.rgb(143, 50, 51),
                Color.rgb(143, 77, 77),
                Color.rgb(140, 101, 102));


        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(16f);
        data.setValueTextColor(Color.WHITE);
        chart_pie.setData(data);

        // undo all highlights
        chart_pie.highlightValues(null);

        chart_pie.invalidate();
    }
}
