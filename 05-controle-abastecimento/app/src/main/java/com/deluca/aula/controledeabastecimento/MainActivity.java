package com.deluca.aula.controledeabastecimento;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager fm = MainActivity.this.getSupportFragmentManager();
        for(int i=0; i<fm.getBackStackEntryCount(); ++i){
            fm.popBackStack();
        }
        setContentView(R.layout.activity_main);

        ArrayList<Posto> abastecimentos = new ArrayList<Posto>();

        abastecimentos = PostoDao.getLista(this.getApplicationContext());
        if (abastecimentos.size()>1){
            double autonomia;
            double kmPercorridos;
            double litros =0;

            kmPercorridos = abastecimentos.get(abastecimentos.size()-1).getKm() - abastecimentos.get(0).getKm();
            for (int i=0; i< abastecimentos.size()-1; i++)
                litros += abastecimentos.get(i).getLitros();

            autonomia = kmPercorridos/litros;
            TextView tvResult = findViewById(R.id.tvAutonomiaAtual);
            tvResult.setText(String.valueOf(autonomia));
        }


    }

    public void onClickHistorico(View button){
        Intent abrirNovoCadastro = new Intent( getApplicationContext(),  HistoricoActivity.class);
        this.startActivity(abrirNovoCadastro);

    }
}
