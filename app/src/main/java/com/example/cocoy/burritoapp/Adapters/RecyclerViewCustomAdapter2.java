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
import android.widget.TextView;

import com.example.cocoy.burritoapp.Product;
import com.example.cocoy.burritoapp.R;

import java.util.ArrayList;


public class RecyclerViewCustomAdapter2 extends
        RecyclerView.Adapter<RecyclerViewCustomAdapter2.CustomViewHolder> {

    // TODO: (1) DECLARAR ESTRUCTURA DE DATOS
    private ArrayList<Product> products;

    // TODO: 11.- Creamos un miembro derivado de la interfaz creada
    private RecyclerViewClickListener listener;


    // TODO: (2) CONSTRUCTOR
    // TODO: 12.- SE AÑADE AL CONSTRUCTOR EL LISTENER COMO PARÁMETRO
    public RecyclerViewCustomAdapter2(ArrayList<Product> products, RecyclerViewClickListener listener) {
        this.products = products;
        this.listener = listener;
    }


    // TODO: (3) DEFINIMOS EL PATRÓN VIEWHOLDER CREANDO UNA CLASE ESTÁTICA PARA DEFINIR ELEMENTOS UI
    public static class CustomViewHolder extends RecyclerView.ViewHolder{
        private TextView tvNameP,tvSellerP,tvPriceP,tvDispoP;

        CustomViewHolder(View vista){
            super(vista);

            tvNameP = (TextView) vista.findViewById(R.id.tvNameP);
            tvSellerP = (TextView) vista.findViewById(R.id.tvSellerP);
            tvPriceP = (TextView) vista.findViewById(R.id.tvPriceProduct);
            tvDispoP = (TextView) vista.findViewById(R.id.tvAvailableProduct);


        }
    }

    // TODO: (4) SE IMPLEMENTAN MÉTODOS REQUERIDOS
    @Override
    public int getItemCount() {
        return products.size();
    }

    // TODO: (5) EL MÉTODO SIRVE PARA COLOCAR VALORES
    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.tvNameP.setText(products.get(position).getProduct_name());
        holder.tvSellerP.setText(products.get(position).getSeller());
        holder.tvPriceP.setText("$"+products.get(position).getPrice());
        holder.tvDispoP.setText(products.get(position).getAvailable()+" de 20");

    }


    // TODO: (6) SE USA EL INFLATER PARA LINKEAR EL XML Y ASIGNARLE LOS ELEMENTOS DEL VIEWHOLDER
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.filacustom2, parent, false);

        //CustomViewHolder customViewHolder = new CustomViewHolder(vista);
        //return customViewHolder;

        // TODO: 13.- Agregamos un objeto RowViewHolder y eliminamos las dos líneas anteriores
        return new RowViewHolder2(vista, listener);
    }

}
