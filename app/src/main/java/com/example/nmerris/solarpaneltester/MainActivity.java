package com.example.nmerris.solarpaneltester;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.androidplot.util.PixelUtils;
import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYGraphWidget;
import com.androidplot.xy.XYPlot;
import com.androidplot.xy.XYSeries;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private XYPlot mPlot;
    private SolarPanelDataDaily mSpdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize XYPlot reference:
        mPlot = (XYPlot) findViewById(R.id.plot);

        // initialize a SolarPanelDataDaily object, which will contain pseudo random test data
        // pass in the number of data points you want it to generate
        mSpdd = JsonDummyDataLoader.generateDaily(16);



        XYSeries seriesKwhGenerated = new SimpleXYSeries(
                Arrays.asList(mSpdd.getKwhGenerated()),
                SimpleXYSeries.ArrayFormat.Y_VALS_ONLY,
                "Generated");

        XYSeries seriesKwhUsed = new SimpleXYSeries(
                Arrays.asList(mSpdd.getKwhUsed()),
                SimpleXYSeries.ArrayFormat.Y_VALS_ONLY,
                "Consumed");


        // create formatters to use for drawing a series using LineAndPointRenderer
        // and configure them from xml:
        LineAndPointFormatter seriesGeneratedFormat =
//                new LineAndPointFormatter(this, R.xml.line_point_formatter_with_labels);
                new LineAndPointFormatter(Color.GREEN, Color.BLUE, Color.TRANSPARENT, null);

        LineAndPointFormatter seriesUsedFormat =
//                new LineAndPointFormatter(this, R.xml.line_point_formatter_with_labels_2);
                new LineAndPointFormatter(Color.RED, Color.BLUE, Color.TRANSPARENT, null);


        // add data series to XY plot
        mPlot.addSeries(seriesKwhGenerated, seriesGeneratedFormat);
        mPlot.addSeries(seriesKwhUsed, seriesUsedFormat);

        mPlot.getGraph().getLineLabelStyle(XYGraphWidget.Edge.BOTTOM).setFormat(new Format() {
            @Override
            public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
                int i = Math.round(((Number) obj).floatValue());
                return toAppendTo.append(mSpdd.getDates()[i]); // need to make this output something nicer (and shorter in length)
            }
            @Override
            public Object parseObject(String source, ParsePosition pos) {
                return null;
            }
        });



    }
}
