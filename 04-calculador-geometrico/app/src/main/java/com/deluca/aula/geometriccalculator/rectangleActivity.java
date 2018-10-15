package com.deluca.aula.geometriccalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class rectangleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle);
    }

    public void calculateRectangle(View button){
        EditText heightRectangle = findViewById(R.id.etRectangleHeight);
        EditText widthRectangle = findViewById(R.id.etRectangleWidth);

        String typedWidthRectangle = widthRectangle.getText().toString();
        String typedHeightRectangle = heightRectangle.getText().toString();

        if(typedHeightRectangle.equals("") && typedWidthRectangle.equals("")){
            heightRectangle.setError("Digite um valor");
            widthRectangle.setError("Digite um valor");
            return;
        }
        else {
            if (typedHeightRectangle.equals("")) {
                heightRectangle.setError("Digite um valor");
                return;
            } else if (typedWidthRectangle.equals("")) {
                widthRectangle.setError("Digite um valor");
                return;
            }
        }
        double heightRectangleInDouble = Double.parseDouble(heightRectangle.getText().toString());
        double widthRectangleInDouble = Double.parseDouble(widthRectangle.getText().toString());


        Intent openResultRectangle = new Intent(this.getApplicationContext(), rectangleResultActivity.class);
        openResultRectangle.putExtra("widthRectangleInDouble", widthRectangleInDouble);
        openResultRectangle.putExtra("heightRectangleInDouble", heightRectangleInDouble);
        this.startActivity(openResultRectangle);

    }
}
