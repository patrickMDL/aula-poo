package com.deluca.aula.controledeabastecimento;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager fm = MainActivity.this.getSupportFragmentManager();
        for(int i = 0; i < fm.getBackStackEntryCount(); ++i) {
            fm.popBackStack();
        }
        setContentView(R.layout.activity_main);

        ArrayList<Posto> abastecimento = new ArrayList<Posto>();

        abastecimento = PostoDAO.getLista(this.getApplicationContext());
        if ( abastecimento.size()>1){
            double autonomia;
            double kmPercorridos;
            double litros=0;

            kmPercorridos = abastecimento.get(abastecimento.size()-1).getKilometros() - abastecimento.get(0).getKilometros();
            for(int i=0; i<abastecimento.size()-1; ++i){
                litros += abastecimento.get(i).getLitros();
            }

            NumberFormat nf = DecimalFormat.getInstance();
            nf.setMaximumFractionDigits(2);

            autonomia = kmPercorridos/litros;
            TextView tvResult = findViewById(R.id.tvAutonomia);
            tvResult.setText(String.valueOf(nf.format(autonomia)));

        }
    }

    public void Historico(View view){
        Intent intent = new Intent(this.getApplicationContext(), HistoricoActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();


        ArrayList<Posto> abastecimento = new ArrayList<Posto>();

        abastecimento = PostoDAO.getLista(this.getApplicationContext());
        if ( abastecimento.size()>1){
            double autonomia;
            double kmPercorridos;
            double litros=0;

            kmPercorridos = abastecimento.get(abastecimento.size()-1).getKilometros() - abastecimento.get(0).getKilometros();
            for(int i=0; i<abastecimento.size()-1; ++i){
                litros += abastecimento.get(i).getLitros();
            }

            NumberFormat nf = DecimalFormat.getInstance();
            nf.setMaximumFractionDigits(2);

            autonomia = kmPercorridos/litros;
            TextView tvResult = findViewById(R.id.tvAutonomia);
            tvResult.setText(String.valueOf(nf.format(autonomia)));

        }else {
            TextView tvResult = findViewById(R.id.tvAutonomia);
            tvResult.setText("--");
        }
        
    }
}
