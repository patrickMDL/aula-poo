package com.deluca.aula.geometriccalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ResultCircleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_circle);
        double radius = this.getIntent().getDoubleExtra("radius", -1);
        double result = (radius*radius) * 3.14;
        TextView tvResult = findViewById(R.id.tvResult);
        NumberFormat nf = DecimalFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        tvResult.setText(nf.format(result));
    }
}
