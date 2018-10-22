package com.deluca.aula.geometriccalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class rectangleResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle_result);
        double widthRectangleInDouble = this.getIntent().getDoubleExtra("widthRectangleInDouble", -1);
        double heightRectangleInDouble = this.getIntent().getDoubleExtra("heightRectangleInDouble", -1);
        double resultRectangle = (widthRectangleInDouble * heightRectangleInDouble);
        TextView tvResult = findViewById(R.id.tvResultRectangle);
        NumberFormat nf = DecimalFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        tvResult.setText("Área: "  + nf.format(resultRectangle));
    }

    public void onClickMenu(View button){
        Intent openMenu = new Intent(getApplicationContext(), MainActivity.class);
        openMenu.addFlags(openMenu.FLAG_ACTIVITY_CLEAR_TOP);
        this.startActivity(openMenu);
    }
}
