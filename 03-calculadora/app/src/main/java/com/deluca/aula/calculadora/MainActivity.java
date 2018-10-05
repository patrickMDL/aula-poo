package com.deluca.aula.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calcular(View calculadora){
        EditText price = findViewById(R.id.etPrice);
        EditText discount = findViewById(R.id.etDiscount);
        TextView result = findViewById(R.id.tvResult1);

        String typedPrice = price.getText().toString();
        String typedDiscount = discount.getText().toString();

        if(typedPrice.equals("") || typedDiscount.equals("")){
            price.setError("Digite um valor.");
            discount.setError("Digite um valor.");
            return;
        }
        try{
            double priceInDouble = Double.parseDouble(typedPrice);
            double discountInDouble = Double.parseDouble(typedDiscount);

            double aux = 1-(discountInDouble/100);
            double resultInDouble = priceInDouble*aux;

            result.setText("Resultado: R$" + resultInDouble);
            result.setVisibility(View.VISIBLE);

        }catch (Exception e){
            Toast mensagemErro = Toast.makeText(this, "Algo está errado.", Toast.LENGTH_LONG);
            mensagemErro.show();
        }
    }
}
