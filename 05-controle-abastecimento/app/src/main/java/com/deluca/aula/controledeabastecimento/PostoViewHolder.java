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

                return false;
            }
        });

        this.tvData = itemView.findViewById(R.id.tvDataGaveta);
        this.tvLitros=itemView.findViewById(R.id.tvLitrosGaveta);
        this.tvKilometros= itemView.findViewById(R.id.tvKmGaveta);
        this.ivPosto=itemView.findViewById(R.id.imageView);
    }

    public void atualizaGaveta(Posto objetoPosto){
        this.objetoSendoExibido = objetoPosto;

        String Kilmetros = "KM: " + String.valueOf(objetoPosto.getKilometros());
        String Litros = String.valueOf(objetoPosto.getLitros()+"L");


        this.tvData.setText(objetoPosto.getData());
        this.tvLitros.setText(Litros);
        this.tvKilometros.setText(Kilmetros);

        if(this.objetoSendoExibido.getPosto().equals("Ipiranga")){
            ivPosto.setImageResource(R.drawable.ipiranga);
        }else if(this.objetoSendoExibido.getPosto().equals("Petrobras")){
            ivPosto.setImageResource(R.drawable.petrobras);
        }else if(this.objetoSendoExibido.getPosto().equals("Shell")){
            ivPosto.setImageResource(R.drawable.shell);
        }else if(this.objetoSendoExibido.getPosto().equals("Texaco")){
            ivPosto.setImageResource(R.drawable.texaco);
        }

    }
}
