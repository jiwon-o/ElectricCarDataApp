package com.example.electriccardataapp;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IFillFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.Utils;

import java.util.ArrayList;

public class DataFragment extends Fragment {
    private View view;
    private LineChart lineChart;
    private BarChart barChart;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_data_black, container, false);

        lineChart = view.findViewById(R.id.chart_line);
        barChart = view.findViewById(R.id.chart_bar);
        SetChart();
        SetChart2();

        return view;
    }


    void SetChart() {
        LineChart chart;
        {   // // Chart Style // //
            chart = view.findViewById(R.id.chart_line);

            // background color
            chart.setBackgroundColor(Color.WHITE);

            // disable description text
            chart.getDescription().setEnabled(false);

            // enable touch gestures
            chart.setTouchEnabled(true);

            // set listeners
//            chart.setOnChartValueSelectedListener(this);
            chart.setDrawGridBackground(false);

            // create marker to display box when values are selected
            MyMarkerView mv = new MyMarkerView(getActivity(), R.layout.custom_marker_view);

            // Set the marker to the chart
            mv.setChartView(chart);
            chart.setMarker(mv);

            // enable scaling and dragging
            chart.setDragEnabled(true);
            chart.setScaleEnabled(true);

            // force pinch zoom along both axis
            chart.setPinchZoom(true);
        }

        final ArrayList<String> xLabel = new ArrayList<>();
        xLabel.add("MON");
        xLabel.add("TUE");
        xLabel.add("WED");
        xLabel.add("THR");
        xLabel.add("FRI");
        xLabel.add("SAT");
        xLabel.add("SUN");

        XAxis xAxis;
        {   // // X-Axis Style // //
            xAxis = chart.getXAxis();
            xAxis.setLabelCount(7, true);
            xAxis.setTextColor(Color.GRAY);
            xAxis.setTextSize(11);
            xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
            xAxis.setDrawGridLines(false);
            xAxis.setAxisLineColor(Color.WHITE);
            chart.getAxisRight().setEnabled(false);
            xAxis.setValueFormatter(new IndexAxisValueFormatter() {
                @Override
                public String getFormattedValue(float value) {
                    return xLabel.get((int) value);
                }
            });

        }

        YAxis yAxis;
        {   // // Y-Axis Style // //
            yAxis = chart.getAxisLeft();
            yAxis.setLabelCount(3, true);
            yAxis.setTextColor(Color.GRAY);
            yAxis.setTextSize(12);
            yAxis.setAxisMaximum(80f);
            yAxis.setAxisMinimum(0f);
            yAxis.setGranularity(40f);
            yAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
            yAxis.setDrawGridLines(true);
            yAxis.setAxisLineColor(Color.WHITE);
            chart.getAxisRight().setEnabled(false);
        }

        setData(7, 80);
        chart.getLegend().setEnabled(false);

        chart.animateXY(1000, 1000);

        // don't forget to refresh the drawing
        chart.invalidate();
    }

    void SetChart2() {
        BarChart chart2;

        chart2 = view.findViewById(R.id.chart_bar);

        chart2.setDrawBarShadow(false);
        chart2.setDrawValueAboveBar(true);

        chart2.getDescription().setEnabled(false);

        // if more than 60 entries are displayed in the chart, no values will be
        // drawn
        chart2.setMaxVisibleValueCount(60);

        // scaling can now only be done on x- and y-axis separately
        chart2.setPinchZoom(true);

        chart2.setDrawGridBackground(false);
        // chart.setDrawYLabels(false);

        chart2.animateXY(2000, 2000);


        XAxis xAxis = chart2.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1f); // only intervals of 1 day
        xAxis.setLabelCount(7);
        xAxis.setTextColor(Color.GRAY);
        String[] xAxisLables = new String[]{"", "MON", "TUE", "WED", "THR", "FRI", "SAT", "SUN"};

        chart2.getXAxis().setValueFormatter(new IndexAxisValueFormatter(xAxisLables));


        YAxis yAxis = chart2.getAxisLeft();
        yAxis.setLabelCount(3, true);
        yAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        yAxis.setTextSize(12);
        yAxis.setTextColor(Color.GRAY);
        yAxis.setAxisMaximum(122f);
        yAxis.setAxisMinimum(14f);
        yAxis.setGranularity(65f);
        yAxis.setDrawGridLines(true);
        yAxis.setDrawAxisLine(false);
        yAxis.setDrawLabels(true);

        YAxis rightAxis = chart2.getAxisRight();
        rightAxis.setDrawLabels(false);
        rightAxis.setDrawAxisLine(false);
        rightAxis.setDrawGridLines(false);

        chart2.getLegend().setEnabled(false);


        MyMarkerView mv = new MyMarkerView(getActivity(), R.layout.custom_marker_view);
        mv.setChartView(chart2); // For bounds control
        chart2.setMarker(mv); // Set the marker to the chart

        // setting data
        setData(7, 100);
    }

    private void setData(int count, float range) {

        ArrayList<Entry> values = new ArrayList<>();

        for (int i = 0; i < count; i++) {

            float val = (float) (Math.random() * range);
            values.add(new Entry(i, val, getResources()));
        }

        LineDataSet set1;

        if (lineChart.getData() != null &&
                lineChart.getData().getDataSetCount() > 0) {
            set1 = (LineDataSet) lineChart.getData().getDataSetByIndex(0);
            set1.setValues(values);
            set1.notifyDataSetChanged();
            lineChart.getData().notifyDataChanged();
            lineChart.notifyDataSetChanged();
        } else {

            set1 = new LineDataSet(values, "");

            set1.setMode(LineDataSet.Mode.CUBIC_BEZIER);
            set1.setCubicIntensity(0.2f);
            set1.setDrawFilled(true);
            set1.setDrawCircles(true);
            set1.setDrawValues(!set1.isDrawValuesEnabled());
            set1.setLineWidth(1.8f);
            set1.setCircleRadius(4f);
            set1.setCircleColor(Color.rgb(255, 35, 102));
            set1.setHighLightColor(Color.GRAY);
            set1.setColor(Color.rgb(255, 35, 102));
            set1.setFillColor(Color.WHITE);
            set1.setFillAlpha(100);
            set1.setDrawHorizontalHighlightIndicator(false);

            set1.setFillFormatter(new IFillFormatter() {
                @Override
                public float getFillLinePosition(ILineDataSet dataSet, LineDataProvider dataProvider) {
                    return lineChart.getAxisLeft().getAxisMinimum();
                }

            });

            // set color of filled area
            if (Utils.getSDKInt() >= 18) {
                // drawables only supported on api level 18 and above
                Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.fade_red);
                set1.setFillDrawable(drawable);
            } else {
                set1.setFillColor(Color.BLACK);
            }

            ArrayList<ILineDataSet> dataSets = new ArrayList<>();
            dataSets.add(set1); // add the data sets

            // create a data object with the data sets
            LineData data = new LineData(dataSets);

            // set data
            lineChart.setData(data);


            float start = 1f;

            ArrayList<BarEntry> value = new ArrayList<>();

            for (int i = (int) start; i < start + count; i++) {
                float val = (float) (Math.random() * (range + 1));
                value.add(new BarEntry(i, val, getResources()));
            }

            BarDataSet set2;

            if (barChart.getData() != null &&
                    barChart.getData().getDataSetCount() > 0) {
                set2 = (BarDataSet) barChart.getData().getDataSetByIndex(0);
                set2.setValues(value);
                set2.notifyDataSetChanged();
                barChart.getData().notifyDataChanged();
                barChart.notifyDataSetChanged();

            } else {
                set2 = new BarDataSet(value, "");
//
                ArrayList<IBarDataSet> dataSet = new ArrayList<>();
                dataSet.add(set2);
//
                BarData datas = new BarData(dataSet);
                datas.setValueTextSize(10f);
                datas.setBarWidth(0.5f);
                set2.setDrawValues(!set1.isDrawValuesEnabled()); //Invisible numbers
                barChart.setData(datas);


            }
        }


    }
}
