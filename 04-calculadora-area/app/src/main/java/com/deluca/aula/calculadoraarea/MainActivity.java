package com.deluca.aula.calculadoraarea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnClick(View button){
        RadioGroup radioGroup =findViewById(R.id.rdChoice);
        String radioValue =((RadioButton)findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();
        if (radioValue.equals("Círculo")){
            Intent openCircleActivity = new Intent (this.getApplicationContext(), CircleActivity.class);
            this.startActivity(openCircleActivity);
        }
        else if (radioValue.equals("Triângulo")){
            Intent openTriangleActivity = new Intent(this.getApplicationContext(), TriangleActivity.class);
            this.startActivity(openTriangleActivity);
        }
        else if (radioValue.equals("Quadrado")){
            Intent openSquareActivity = new Intent (this.getApplicationContext(), SquareActivity.class);
            this.startActivity(openSquareActivity);
        }
    }
}
