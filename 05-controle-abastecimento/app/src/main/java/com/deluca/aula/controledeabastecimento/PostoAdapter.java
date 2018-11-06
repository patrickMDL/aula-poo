package com.deluca.aula.controledeabastecimento;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class PostoAdapter extends RecyclerView.Adapter {
    public ArrayList<Posto> listaPostos;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View elementoPaiDoXML =
                LayoutInflater.from(
                        parent.getContext()
                ).inflate(
                        R.layout.gaveta,
                        parent,
                        false
                );
        PostoViewHolder minhaGaveta = new PostoViewHolder(elementoPaiDoXML);
        return minhaGaveta;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        PostoViewHolder minhaGaveta = (PostoViewHolder) holder;
        Posto daVez = listaPostos.get(position);
        minhaGaveta.atualizaGaveta(daVez);
    }

    @Override
    public int getItemCount() {
        return listaPostos.size();
    }
}
