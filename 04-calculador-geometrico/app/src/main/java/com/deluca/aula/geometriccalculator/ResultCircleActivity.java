package com.deluca.aula.geometriccalculator;

import android.content.Intent;
import android.support.v4.content.IntentCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ResultCircleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_circle);
        double radius = this.getIntent().getDoubleExtra("radius", -1);
        double result = (radius*radius) * Math.PI;
        TextView tvResult = findViewById(R.id.tvResult);
        NumberFormat nf = DecimalFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        tvResult.setText("Área: "  +nf.format(result));

    }
    public void onClickMenu(View button){
        Intent openMenu = new Intent(this.getApplicationContext(), MainActivity.class);
        openMenu.addFlags(openMenu.FLAG_ACTIVITY_CLEAR_TOP);
        this.startActivity(openMenu);
    }
}
