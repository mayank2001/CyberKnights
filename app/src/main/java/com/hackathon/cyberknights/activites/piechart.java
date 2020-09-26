package com.hackathon.cyberknights.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;
import com.hackathon.cyberknights.R;

import java.util.ArrayList;
import java.util.List;

public class piechart extends AppCompatActivity {



    AnyChartView anyChartView;

    String[] transactions = {"Shopping", "Food", "Miscellaneous", "Others"};
    int [] money = {5000, 1500, 2000, 500};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.piechart);

        anyChartView = findViewById(R.id.any_char_view);

        setupPieChart();

    }

    public void setupPieChart()  {

        Pie pie = AnyChart.pie();
        List<DataEntry> dataEntries = new ArrayList<>();
        for (int i = 0; i < transactions.length; i++){
            dataEntries.add(new ValueDataEntry(transactions[i], money[i]));
            
        }

        pie.data(dataEntries);
        anyChartView.setChart(pie);


    }
}