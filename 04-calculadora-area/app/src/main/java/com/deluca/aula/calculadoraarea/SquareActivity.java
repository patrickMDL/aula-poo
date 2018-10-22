package com.deluca.aula.calculadoraarea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SquareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square);
    }
    public void calculateRectangle(View button){
        EditText heightSquare = findViewById(R.id.etSquareHeight);
        EditText widthSquare = findViewById(R.id.etSquareWidth);

        String typedWidthSquare = widthSquare.getText().toString();
        String typedHeightSquare = heightSquare.getText().toString();

        if(typedHeightSquare.equals("") && typedWidthSquare.equals("")){
            heightSquare.setError("Digite um valor");
            widthSquare.setError("Digite um valor");
            return;
        }
        else {
            if (typedHeightSquare.equals("")) {
                heightSquare.setError("Digite um valor");
                return;
            } else if (typedWidthSquare.equals("")) {
                widthSquare.setError("Digite um valor");
                return;
            }
        }
        double heightSquareInDouble = Double.parseDouble(heightSquare.getText().toString());
        double widthSquareInDouble = Double.parseDouble(widthSquare.getText().toString());


        Intent openResultSquare = new Intent(this.getApplicationContext(), SquareResultActivity.class);
        openResultSquare.putExtra("widthSquareInDouble", widthSquareInDouble);
        openResultSquare.putExtra("heightSquareInDouble", heightSquareInDouble);
        this.startActivity(openResultSquare);
}
