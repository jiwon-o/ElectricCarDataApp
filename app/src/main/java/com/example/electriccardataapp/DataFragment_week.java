package com.example.electriccardataapp;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DataFragment_week#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DataFragment_week extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DataFragment_week() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DataFragment_week.
     */
    // TODO: Rename and change types and number of parameters
    public static DataFragment_week newInstance(String param1, String param2) {
        DataFragment_week fragment = new DataFragment_week();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private View view;
    private LineChart lineChart;
    private BarChart barChart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_data_week, container, false);

        lineChart = view.findViewById(R.id.chart_line);
        barChart = view.findViewById(R.id.chart_bar);
        setChart_line();
        setChart_bar();

        return view;
    }

    private void setChart_bar() {

        BarChart chart_bar;

        chart_bar = view.findViewById(R.id.chart_bar);

        chart_bar.setDrawBarShadow(false);
        chart_bar.setDrawValueAboveBar(true);

        chart_bar.getDescription().setEnabled(false);

        // if more than 60 entries are displayed in the chart, no values will be
        // drawn
        chart_bar.setMaxVisibleValueCount(60);

        // scaling can now only be done on x- and y-axis separately
        chart_bar.setPinchZoom(true);

        chart_bar.setDrawGridBackground(false);
        chart_bar.setBackgroundColor(Color.rgb(29, 33, 35));
        // chart.setDrawYLabels(false);

        chart_bar.animateXY(2000, 2000);


        XAxis xAxis_bar = chart_bar.getXAxis();
        xAxis_bar.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis_bar.setDrawGridLines(false);
        xAxis_bar.setGranularity(1f); // only intervals of 1 day
        xAxis_bar.setLabelCount(7);
        xAxis_bar.setTextColor(Color.GRAY);
        xAxis_bar.setTextSize(8);
        String[] xLables_bar = new String[]{"", "MON", "TUE", "WED", "THR", "FRI", "SAT", "SUN"};

        chart_bar.getXAxis().setValueFormatter(new IndexAxisValueFormatter(xLables_bar));


        YAxis yAxis_bar = chart_bar.getAxisLeft();
        yAxis_bar.setLabelCount(3, true);
        yAxis_bar.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        yAxis_bar.setTextSize(10);
        yAxis_bar.setTextColor(Color.GRAY);
        yAxis_bar.setAxisMaximum(122f);
        yAxis_bar.setAxisMinimum(14f);
        yAxis_bar.setGranularity(65f);
        yAxis_bar.setDrawGridLines(true);
        yAxis_bar.setDrawAxisLine(true);
        yAxis_bar.setDrawLabels(true);

        YAxis rightAxis = chart_bar.getAxisRight();
        rightAxis.setDrawLabels(false);
        rightAxis.setDrawAxisLine(false);
        rightAxis.setDrawGridLines(false);

        chart_bar.getLegend().setEnabled(false);


        TemperatureMarkerView mv = new TemperatureMarkerView(getActivity(), R.layout.custom_marker_view);
        mv.setChartView(chart_bar); // For bounds control
        chart_bar.setMarker(mv); // Set the marker to the chart

        // setting data
        setData_bar(7, 100);
    }

    private void setData_bar(int count, int range) {

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
            set2.setColor(Color.rgb(76, 132, 255));
            set2.setDrawValues(!set2.isDrawValuesEnabled()); //Invisible numbers
            barChart.setData(datas);


        }
    }



    private void setChart_line() {

        LineChart chart_line;
        {   // // Chart Style // //
            chart_line = view.findViewById(R.id.chart_line);

            // background color
            chart_line.setBackgroundColor(Color.rgb(29, 33, 35));

            // disable description text
            chart_line.getDescription().setEnabled(false);

            // enable touch gestures
            chart_line.setTouchEnabled(true);

            // set listeners
//            chart.setOnChartValueSelectedListener(this);
            chart_line.setDrawGridBackground(false);

            // create marker to display box when values are selected
            RangeMarkerView mv = new RangeMarkerView(getActivity(), R.layout.custom_marker_view);

            // Set the marker to the chart
            mv.setChartView(chart_line);
            chart_line.setMarker(mv);

            // enable scaling and dragging
            chart_line.setDragEnabled(true);
            chart_line.setScaleEnabled(true);

            // force pinch zoom along both axis
            chart_line.setPinchZoom(true);
        }

        final ArrayList<String> xLabel_line = new ArrayList<>();
        xLabel_line.add("MON");
        xLabel_line.add("TUE");
        xLabel_line.add("WED");
        xLabel_line.add("THR");
        xLabel_line.add("FRI");
        xLabel_line.add("SAT");
        xLabel_line.add("SUN");

        XAxis xAxis_line;
        {   // // X-Axis Style // //
            xAxis_line = chart_line.getXAxis();
            xAxis_line.setLabelCount(7, true);
            xAxis_line.setTextColor(Color.GRAY);
            xAxis_line.setTextSize(8);
            xAxis_line.setPosition(XAxis.XAxisPosition.BOTTOM);
            xAxis_line.setDrawGridLines(false);
            xAxis_line.setAxisLineColor(Color.WHITE);
            chart_line.getAxisRight().setEnabled(false);
            xAxis_line.setValueFormatter(new IndexAxisValueFormatter() {
                @Override
                public String getFormattedValue(float value) {
                    return xLabel_line.get((int) value);
                }
            });

        }

        YAxis yAxis_line;
        {   // // Y-Axis Style // //
            yAxis_line = chart_line.getAxisLeft();
            yAxis_line.setLabelCount(3, true);
            yAxis_line.setTextColor(Color.GRAY);
            yAxis_line.setTextSize(10);
            yAxis_line.setAxisMaximum(80f);
            yAxis_line.setAxisMinimum(0f);
            yAxis_line.setGranularity(40f);
            yAxis_line.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
            yAxis_line.setDrawGridLines(true);
            yAxis_line.setAxisLineColor(Color.WHITE);
            chart_line.getAxisRight().setEnabled(false);
        }

        setData_line(7, 80);
        chart_line.getLegend().setEnabled(false);

        chart_line.animateXY(1000, 1000);

        // don't forget to refresh the drawing
        chart_line.invalidate();
    }

    private void setData_line(int count, int range) {

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
            set1.setLineWidth(1.4f);

            set1.setCircleRadius(3f);
            set1.setCircleHoleColor(Color.rgb(29, 33, 35));
            set1.setCircleColor(Color.rgb(234, 35, 38));
            set1.setHighLightColor(Color.WHITE);
            set1.setColor(Color.rgb(234, 35, 38));
            set1.setFillColor(Color.GRAY);
            set1.setFillAlpha(80);
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
        }
    }
}