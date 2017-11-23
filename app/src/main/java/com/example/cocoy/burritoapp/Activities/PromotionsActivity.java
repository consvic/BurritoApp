package com.example.cocoy.burritoapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.cocoy.burritoapp.Adapters.RecyclerViewClickListener;
import com.example.cocoy.burritoapp.Adapters.RecyclerViewCustomAdapter2;
import com.example.cocoy.burritoapp.Adapters.RecyclerViewCustomAdapter3;
import com.example.cocoy.burritoapp.Product;
import com.example.cocoy.burritoapp.Promotions;
import com.example.cocoy.burritoapp.R;

import java.util.ArrayList;

public class PromotionsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    private RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotions);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewPromotions);
        recyclerView.setHasFixedSize(true);
        /*
            Un LayoutManager es el responsable de medir y saber la posición de los elementos dentro
            de un RecyclerView, así como determinar el momento en que los elementos se ocultan y muestran
         */
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        ArrayList<Promotions> promotions = new ArrayList<Promotions>();
        promotions.add(new Promotions(R.drawable.santorini2,"Viaje a Santorini 50% de descuento","12/11/17"));
        // TODO: 13.- Ingresamos a nuestro adaptador un nuevo listener para poder saber el elemento al que se le dio click
        RecyclerViewCustomAdapter3 adapter = new RecyclerViewCustomAdapter3(promotions, new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(PromotionsActivity.this, "Elemento " + position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(PromotionsActivity.this,ItemsActivity.class);
            }
        });
        recyclerView.setAdapter(adapter);
    }
}
