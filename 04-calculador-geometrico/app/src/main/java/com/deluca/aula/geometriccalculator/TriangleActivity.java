package com.deluca.aula.geometriccalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class TriangleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle);
    }
    public void calculateTriangle (View button){
        EditText height = findViewById(R.id.etHeight);
        EditText width = findViewById(R.id.etWidth);

        String typedHeight = height.getText().toString();
        String typedWidth = width.getText().toString();

        if (typedHeight.equals("") || typedWidth.equals("")) {
            if (typedHeight.equals("")) {
                height.setError("Digite um valor.");
                return;
            }
            if (typedWidth.equals("")) {
                width.setError("Digite um valor.");
                return;
            }
        }else {

            double heightInDouble = Double.parseDouble(height.getText().toString());
            double widthInDouble = Double.parseDouble(width.getText().toString());


            Intent openResultTriangle = new Intent(this.getApplicationContext(), ResultTriangleActivity.class);
            openResultTriangle.putExtra("widthInDouble", widthInDouble);
            openResultTriangle.putExtra("heightInDouble", heightInDouble);
            this.startActivity(openResultTriangle);
        }
    }
}
