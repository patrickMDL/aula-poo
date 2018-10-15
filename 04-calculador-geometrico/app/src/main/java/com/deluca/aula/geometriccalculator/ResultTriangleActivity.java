package com.deluca.aula.geometriccalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ResultTriangleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_triangle);
        double typedWidth = this.getIntent().getDoubleExtra("width", -1);
        double typedHight = this.getIntent().getDoubleExtra("Hight", -1);
        double result = (typedHight*typedWidth)/2;
        TextView tvResult = findViewById(R.id.tvResultTriangle);
        NumberFormat nf = DecimalFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        tvResult.setText(nf.format(result));
    }

    public void onClickMenu(View button){
        Intent openMenu = new Intent(this.getApplicationContext(), MainActivity.class);
        this.startActivity(openMenu);
    }

}
