package com.deluca.aula.geometriccalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {



    private RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void onClickNext(View Button) {
        this.radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        if (radioGroup.equals("Quadrado")) {
            Intent openRectangleActivity = new Intent(this.getApplicationContext(), rectangleActivity.class);
            this.startActivity(openRectangleActivity);
        } else if (radioGroup.equals("Triângulo")) {
            Intent openTriangleActivity = new Intent(this.getApplicationContext(), TriangleActivity.class);
            this.startActivity(openTriangleActivity);

        } else if (radioGroup.equals("Círculo")) {
            Intent openCircleActivity = new Intent(this.getApplicationContext(), CircleActivity.class);
            this.startActivity(openCircleActivity);
        }
    }

}
