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
import com.example.cocoy.burritoapp.Product;
import com.example.cocoy.burritoapp.R;

import java.util.ArrayList;

public class ItemsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    private RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewItems);
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
        final ArrayList<Product> products = new ArrayList<Product>();
        products.add(new Product("Brownies","Grecia",15,40));

        // TODO: 13.- Ingresamos a nuestro adaptador un nuevo listener para poder saber el elemento al que se le dio click
        RecyclerViewCustomAdapter2 adapter = new RecyclerViewCustomAdapter2(products, new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(ItemsActivity.this, "Elemento " + position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ItemsActivity.this,PurchaseActivity.class);
                intent.putExtra("product",products.get(position).getProduct_name());
                intent.putExtra("seller",products.get(position).getSeller());
                intent.putExtra("price", products.get(position).getPrice());
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
    }
}
