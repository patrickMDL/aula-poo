package com.deluca.aula.controledeabastecimento;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PostoViewHolder  extends RecyclerView.ViewHolder{
    private TextView tvData;
    private TextView tvLitros;
    private TextView tvKm;
    private TextView tvKmLitros;
    private ImageView ivPosto;

    private Posto objetoSendoExibido;

        public PostoViewHolder(@NonNull View itemView) {
        super(itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view){
                Intent abrirAtividade = new Intent(view.getContext(), NovoCadastroActivity.class);
                abrirAtividade.putExtra("posto", PostoViewHolder.this.objetoSendoExibido);
                ((MainActivity) view.getContext()).startActivityForResult(abrirAtividade, HistoricoActivity.RC_ADICIONAR_POSTO);
            }

        });

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(final View view) {
                new AlertDialog.Builder(view.getContext()).setTitle("VOCÊ QUER EXCLUIR?").setMessage("Essa ação não poderá ser desfeita e você está de acordo com isso.").setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        PostoDao.excluir(view.getContext(), objetoSendoExibido);
                        ((HistoricoActivity) view.getContext()).atualizaDatasetLista();
                    }
                }).setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).show();

                return false;
            }
        });

        this.tvData = itemView.findViewById(R.id.tvData);
        this.tvLitros = itemView.findViewById(R.id.tvLitros);
        this.tvKmLitros = itemView.findViewById(R.id.tvKMAtual);
        this.ivPosto = itemView.findViewById(R.id.ivPosto);

    }







    public void atualizaGaveta(Posto objetoPosto){
         this.objetoSendoExibido = objetoPosto;

         String km = "KM: " + String.valueOf(objetoPosto.getKm());
         String litros = String.valueOf(objetoPosto.getLitros());

         this.tvData.setText(objetoPosto.getData() );
         this.tvKmLitros.setText(km);
         this.tvLitros.setText(litros);

        if(objetoPosto.getPosto().equals("Ipiranga")){
            this.ivPosto.setImageDrawable(ContextCompat.getDrawable(App.getContext(), R.drawable.ipiranga));

        }else if(objetoPosto.getPosto().equals("Texaco")){
            this.ivPosto.setImageDrawable(ContextCompat.getDrawable(App.getContext(), R.drawable.texaco));

        }else if(objetoPosto.getPosto().equals("Petrobras")){
            this.ivPosto.setImageDrawable(ContextCompat.getDrawable(App.getContext(), R.drawable.petrobras));

        }else if(objetoPosto.getPosto().equals("Shell")){
            this.ivPosto.setImageDrawable(ContextCompat.getDrawable(App.getContext(), R.drawable.shell));

        }
    }


}
