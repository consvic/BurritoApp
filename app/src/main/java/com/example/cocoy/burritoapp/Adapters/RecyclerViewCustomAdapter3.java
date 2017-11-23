/*
 * Copyright (C) 2017 Marcos Rivas Rojas
 *
 *
 */
package com.example.cocoy.burritoapp.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cocoy.burritoapp.Promotions;
import com.example.cocoy.burritoapp.R;

import java.util.ArrayList;


public class RecyclerViewCustomAdapter3 extends
        RecyclerView.Adapter<RecyclerViewCustomAdapter3.CustomViewHolder> {

    // TODO: (1) DECLARAR ESTRUCTURA DE DATOS
    private ArrayList<Promotions> promotions;

    // TODO: 11.- Creamos un miembro derivado de la interfaz creada
    private RecyclerViewClickListener listener;


    // TODO: (2) CONSTRUCTOR
    // TODO: 12.- SE AÑADE AL CONSTRUCTOR EL LISTENER COMO PARÁMETRO
    public RecyclerViewCustomAdapter3(ArrayList<Promotions> promotions, RecyclerViewClickListener listener) {
        this.promotions = promotions;
        this.listener = listener;
    }


    // TODO: (3) DEFINIMOS EL PATRÓN VIEWHOLDER CREANDO UNA CLASE ESTÁTICA PARA DEFINIR ELEMENTOS UI
    public static class CustomViewHolder extends RecyclerView.ViewHolder{
        private TextView tvPromo,tvDispo;
        private ImageView ivPromo;

        CustomViewHolder(View vista){
            super(vista);

            tvPromo = (TextView) vista.findViewById(R.id.tvPromo);
            tvDispo = (TextView) vista.findViewById(R.id.tvDispo);

            ivPromo = (ImageView) vista.findViewById(R.id.ivPromo);
        }
    }

    // TODO: (4) SE IMPLEMENTAN MÉTODOS REQUERIDOS
    @Override
    public int getItemCount() {
        return promotions.size();
    }

    // TODO: (5) EL MÉTODO SIRVE PARA COLOCAR VALORES
    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.ivPromo.setImageResource(promotions.get(position).getPhotoPromo());
        holder.tvPromo.setText(promotions.get(position).getPromotion());
        holder.tvDispo.setText("Promoción válida hasta el "+promotions.get(position).getDateAvailable());
    }


    // TODO: (6) SE USA EL INFLATER PARA LINKEAR EL XML Y ASIGNARLE LOS ELEMENTOS DEL VIEWHOLDER
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.filacustom3, parent, false);

        //CustomViewHolder customViewHolder = new CustomViewHolder(vista);
        //return customViewHolder;

        // TODO: 13.- Agregamos un objeto RowViewHolder y eliminamos las dos líneas anteriores
        return new RowViewHolder3(vista, listener);
    }

}
