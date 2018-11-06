package com.deluca.aula.controledeabastecimento;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class PostoViewHolder extends RecyclerView.ViewHolder{
    private TextView tvData;
    private TextView tvLitros;
    private TextView tvKilometros;
    private ImageView ivPosto;

    private Posto objetoSendoExibido;

    public PostoViewHolder(View itemView) {
        super(itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abrirAtividade = new Intent( view.getContext(), NovoAbastecimentoActivity.class );
                abrirAtividade.putExtra("posto", (Serializable) PostoViewHolder.this.objetoSendoExibido);
                ((MainActivity) view.getContext()).startActivityForResult(abrirAtividade, HistoricoActivity.RC_ADICIONAR_ABASTECIMENTO);
            }
        });

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(final View view) {
                new AlertDialog.Builder(view.getContext())
                        .setTitle("VOCÊ QUER EXCLUIR???")
                        .setMessage("Essa ação não poderá ser desfeita e você está de acordo com isso...")
                        .setPositiveButton("Eu quero", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                PostoDAO.excluir(view.getContext(), objetoSendoExibido);
                                ((HistoricoActivity) view.getContext()).atualizaDatasetLista();
                            }
                        })
                        .setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .show();


                Toast.makeText(view.getContext(), "CLICOU LONGAMENTE", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        this.tvData = itemView.findViewById(R.id.tvDataGaveta);
        this.tvLitros=itemView.findViewById(R.id.tvLitrosGaveta);
        this.tvKilometros= itemView.findViewById(R.id.tvKmGaveta);
        this.ivPosto=itemView.findViewById(R.id.spPostos);
    }

    public void atualizaGaveta(Posto objetoPosto){
        this.objetoSendoExibido = objetoPosto;

        String Kilmetros = "KM: " + String.valueOf(objetoPosto.getKilometros());
        String Litros = String.valueOf(objetoPosto.getLitros()+"L");
        String posto = objetoPosto.getPosto();

        this.tvData.setText(objetoPosto.getData());
        this.tvLitros.setText(Litros);
        this.tvKilometros.setText(Kilmetros);

        if(posto.equals("Ipiranga")){
            ivPosto.setImageDrawable(ContextCompat.getDrawable(App.getContext(), R.drawable.ipiranga));
        }else if(posto.equals("Petrobras")){
            ivPosto.setImageDrawable(ContextCompat.getDrawable(App.getContext(), R.drawable.petrobras));
        }else if(posto.equals("Shell")){
            ivPosto.setImageDrawable(ContextCompat.getDrawable(App.getContext(), R.drawable.shell));
        }else{
            ivPosto.setImageDrawable(ContextCompat.getDrawable(App.getContext(), R.drawable.texaco));
        }

    }
}
