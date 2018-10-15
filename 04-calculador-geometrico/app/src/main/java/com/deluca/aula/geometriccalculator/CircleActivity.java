package com.deluca.aula.geometriccalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CircleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cicle);
    }

    public void calculateCircle(View button){
        EditText typedRadius = findViewById(R.id.etRadius);
        double radius = Double.parseDouble(typedRadius.getText().toString());
        Intent resultCircle = new Intent(this.getApplicationContext(), ResultCircleActivity.class);
        resultCircle.putExtra("radius", radius);
        this.startActivity(resultCircle);
    }
}
