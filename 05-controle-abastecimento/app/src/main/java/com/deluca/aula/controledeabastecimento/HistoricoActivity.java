package com.deluca.aula.controledeabastecimento;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class HistoricoActivity extends AppCompatActivity {

    private PostoAdapter adaptador;

    public static final int RC_ADICIONAR_ABASTECIMENTO = 1312;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);

        RecyclerView rvListaPosto = findViewById(R.id.rvLista);
        this.adaptador = new PostoAdapter();
        this.adaptador.listaPostos = PostoDAO.getLista(this.getApplicationContext());

        rvListaPosto.setAdapter(this.adaptador);
        rvListaPosto.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
    }

    public void onClickFAB(View v){
        Intent intencao = new Intent(this.getApplicationContext(), NovoAbastecimentoActivity.class);


        startActivityForResult(intencao, RC_ADICIONAR_ABASTECIMENTO);

    }
    public void atualizaDatasetLista(){
        this.adaptador.listaPostos = PostoDAO.getLista(this.getApplicationContext());
        this.adaptador.notifyDataSetChanged();
    }

    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(resultCode== 1){
            this.adaptador.notifyDataSetChanged();
        }else if(requestCode == 2){
            this.adaptador.notifyDataSetChanged();
        }
    }

}
