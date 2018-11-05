package com.deluca.aula.controledeabastecimento;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class HistoricoActivity extends AppCompatActivity {

    private  PostoAdapter adaptador;
    public static final int RC_ADICIONAR_POSTO = 1312;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);

        RecyclerView rvListaPostos = findViewById(R.id.rvListaPostos);

        this.adaptador = new PostoAdapter();
        this.adaptador.listaPosto = PostoDao.getLista(this.getApplicationContext());

        rvListaPostos.setAdapter(this.adaptador);

        rvListaPostos.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
    }

    public void onClickFAB(View v){
        Intent intention = new Intent(this.getApplicationContext(), NovoCadastroActivity.class);
        startActivityForResult(intention, RC_ADICIONAR_POSTO);
    }

    public void atualizaDatasetLista(){
        this.adaptador.listaPosto = PostoDao.getLista(this.getApplicationContext());
        this.adaptador.notifyDataSetChanged();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == 1){
            this.adaptador.notifyDataSetChanged();
        }
        else if(resultCode == 2 ){
            this.adaptador.notifyDataSetChanged();
        }
        else if(resultCode == 0){

        }
        else {


        }
    }

}
