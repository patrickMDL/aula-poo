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
        EditText typedHeight = findViewById(R.id.etHeight);
        EditText typedWidth = findViewById(R.id.etWidth);

        double Height = Double.parseDouble(typedHeight.getText().toString());
        double Width = Double.parseDouble(typedWidth.getText().toString());



        Intent openResultTriangle = new Intent(this.getApplicationContext(), ResultTriangleActivity.class);
        openResultTriangle.putExtra("width", Width);
        openResultTriangle.putExtra("Height", Height);
        this.startActivity(openResultTriangle);
    }
}
