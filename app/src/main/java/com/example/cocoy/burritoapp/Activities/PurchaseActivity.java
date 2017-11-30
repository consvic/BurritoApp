package com.example.cocoy.burritoapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.cocoy.burritoapp.R;

public class PurchaseActivity extends AppCompatActivity {

    TextView tvPrice, tvQuantity;
    EditText etName, etPlace;
    ImageButton ibPlus,ibMinus;
    Button bCompra;
    String product, seller;
    String name_cus, place_cus;
    int price, quantity=0,total=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        getSupportActionBar().setTitle("ShopMart");
        Intent intent = getIntent();
        product = intent.getStringExtra("product");
        price = intent.getIntExtra("price",0);
        seller = intent.getStringExtra("seller");

        tvPrice = (TextView) findViewById(R.id.tvTotal);
        tvQuantity = (TextView) findViewById(R.id.tvNoItems);
        etName = (EditText) findViewById(R.id.input_name);
        etPlace = (EditText) findViewById(R.id.input_place);
        ibPlus = (ImageButton) findViewById(R.id.ibPlus);
        ibMinus = (ImageButton) findViewById(R.id.ibMinus);
        bCompra = (Button) findViewById(R.id.bHacerCompra);

        ibPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity +=1;
                total = price * quantity;
                tvQuantity.setText(String.valueOf(quantity));
                tvPrice.setText("$"+String.valueOf(total));
            }
        });

        ibMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quantity!=0) {
                    quantity -= 1;
                    total = price * quantity;
                    tvQuantity.setText(String.valueOf(quantity));
                    tvPrice.setText("$"+String.valueOf(total));
                }
            }
        });

        bCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name_cus = etName.getText().toString();
                place_cus = etPlace.getText().toString();
            }
        });

    }
}
