package com.deluca.aula.controledeabastecimento;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class NovoCadastroActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    private String postos[] = new String[]{"Ipiranga", "Petrobras", "Shell", "Taxaco"};
    private Spinner selectedSpinner;
    private EditText etKmAtual;
    private EditText etLitrosAbastecidos;
    private EditText etData;
    private double kmAntigo;
    public Posto postoApresentadoNoFormulario;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_cadastro);

        selectedSpinner = (Spinner) findViewById(R.id.spGasStation);



        ArrayAdapter<String> adapter = new ArrayAdapter<String> (this.getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, postos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        this.kmAntigo = this.getIntent().getDoubleExtra("kmAndigo", -1);

        selectedSpinner.setAdapter(adapter);

        etKmAtual = findViewById(R.id.etKMAtual);
        etLitrosAbastecidos = findViewById(R.id.etLitros);
        etData = findViewById(R.id.etDay);




    }

    public void salvarPosto(View view){
        Posto posto = new Posto();

        if(etKmAtual.getText().toString().equals("")){
            this.etKmAtual.setError(getString(R.string.campo_preenchido));
            return;
        }if(etLitrosAbastecidos.getText().equals("")){
            this.etLitrosAbastecidos.setError(getString(R.string.campo_preenchido));
            return;
        }
        if(etData.getText().equals("")){
            this.etData.setError(getString(R.string.campo_preenchido));
            return;
        }if (Double.parseDouble(etKmAtual.getText().toString()) <= this.kmAntigo){
            this.etKmAtual.setError(getString(R.string.km_maior));
            return;
        }

        posto.setData(etData.getText().toString());
        posto.setKm(Double.parseDouble(etKmAtual.getText().toString()));
        posto.setLitros(Double.parseDouble(etLitrosAbastecidos.getText().toString()));
        posto.setPosto(selectedSpinner.getSelectedItem().toString());

        boolean salvo = PostoDao.salvar(this.getApplicationContext(), posto);

        if(salvo){
            setResult(1);
            finish();
        }else{
            Toast.makeText(this.getApplicationContext(), "Erro ao salvar", Toast.LENGTH_SHORT).show();
        }


    }

    public void onClick(View button){
        Spinner selectedSpinner = (Spinner) findViewById(R.id.spGasStation);
        selectedSpinner.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        parent.getItemAtPosition(position);
    }
}

