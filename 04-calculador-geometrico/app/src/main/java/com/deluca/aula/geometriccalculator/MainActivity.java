package com.deluca.aula.geometriccalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickCircle(View button){
        Intent openCircleActivity = new Intent (this.getApplicationContext(), CircleActivity.class);
        this.startActivity(openCircleActivity);
    }

    public void onClickTriangle(View button){
        Intent openTriangleActivity = new Intent (this.getApplicationContext(), TriangleActivity.class);
        this.startActivity(openTriangleActivity);
    }


    public void onClickRectangle(View button){
        Intent openRectangleActivity = new Intent(this.getApplicationContext(), rectangleActivity.class);
        this.startActivity(openRectangleActivity);
    }
}
