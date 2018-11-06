package com.deluca.aula.controledeabastecimento;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class NovoAbastecimentoActivity extends AppCompatActivity {

    private String postos[] = new String[]{"Ipiranga", "Petrobras", "Shell", "Texaco"};
    private Spinner sPosto;
    private EditText etData;
    private EditText etLitrosAbastecidos;
    private EditText etKmAtual;
    private double kmAntigo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_abastecimento);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, postos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        this.kmAntigo = this.getIntent().getDoubleExtra("kmAntigo", -1);

        sPosto = (Spinner) findViewById(R.id.spPostos);
        sPosto.setAdapter(adapter);

        etKmAtual = findViewById(R.id.etKmAtual);
        etLitrosAbastecidos = findViewById(R.id.etLitrosAbastecidos);
        etData = findViewById(R.id.etDataAtual);

    }

    public void salvarContato (View view){
        Posto abastecimento = new Posto();

        if (etKmAtual.getText().toString().equals("")){
            this.etKmAtual.setError(getString(R.string.campo_vazio));
            return;
        }
        if (etLitrosAbastecidos.getText().toString().equals("")){
            this.etLitrosAbastecidos.setError(getString(R.string.campo_vazio));
            return;
        }
        if(etData.getText().toString().equals("")){
            this.etData.setError(getString(R.string.campo_vazio));
            return;
        }
        if(Double.parseDouble(etKmAtual.getText().toString()) <= this.kmAntigo){
            this.etKmAtual.setError(getString(R.string.km_menor));
            return;
        }
        abastecimento.setKilometros(Double.parseDouble(etKmAtual.getText().toString()));
        abastecimento.setLitros(Double.parseDouble(etLitrosAbastecidos.getText().toString()));
        abastecimento.setData(etData.getText().toString());
        abastecimento.setPosto(sPosto.getSelectedItem().toString());
        boolean salvo = PostoDAO.salvar(this.getApplicationContext(), abastecimento);

        if(salvo){
            setResult(1);
            finish();
        }else{
            Toast.makeText(this.getApplicationContext(), "Erro ao salvar", Toast.LENGTH_SHORT).show();
        }
    }
}
