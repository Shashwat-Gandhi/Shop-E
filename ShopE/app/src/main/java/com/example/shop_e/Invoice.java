package com.example.shop_e;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Invoice extends AppCompatActivity {

    InvoiceAdapter invoiceAdapter;
    RecyclerView invoiceRecView;

    boolean bought = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);

        invoiceRecView = findViewById(R.id.rec_invoice_main);
        invoiceRecView.setLayoutManager(new LinearLayoutManager(this));
        invoiceRecView.setHasFixedSize(true);

        Intent intent = getIntent();
        boolean did_buy = intent.getBooleanExtra("com.example.shop_e.did_buy",false);
        bought = did_buy;
        if(!did_buy) {
            List<Product>products = ((MyApplication)this.getApplication()).cart.getProducts();
            invoiceAdapter = new InvoiceAdapter(this,products);
            invoiceRecView.setAdapter(invoiceAdapter);

            TextView cart_total_text_view = findViewById(R.id.invoice_cart_total_text_view);
            int totalPrice = 0 ;
            for(int i=0;i < products.size();i++) {
                totalPrice += products.get(i).getPrice();
            }
            cart_total_text_view.setText(String.valueOf(totalPrice));
        }
        else{
            List<Product>products = new ArrayList<>();
            String name = intent.getStringExtra("com.example.shop_e.product.name");
            String size = intent.getStringExtra("com.example.shop_e.product.size");
            String color = intent.getStringExtra("com.example.shop_e.product.color");
            int price = intent.getIntExtra("com.example.shop_e.product.price",0);

            products.add(new Product(name,color,price,R.drawable.background_for_start_activity,size,TypeOfProduct.Shirts,0));
            invoiceAdapter = new InvoiceAdapter(this,products);
            invoiceRecView.setAdapter(invoiceAdapter);

            TextView cart_total_text_view = findViewById(R.id.invoice_cart_total_text_view);
            int totalPrice = 0 ;
            for(int i=0;i < products.size();i++) {
                totalPrice += products.get(i).getPrice();
            }
            cart_total_text_view.setText(String.valueOf(totalPrice));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(!bought){
            ((MyApplication)this.getApplication()).cart.emptyAll();
            ((MyApplication)this.getApplication()).cartAdapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(!bought){
            ((MyApplication)this.getApplication()).cart.emptyAll();
            ((MyApplication)this.getApplication()).cartAdapter.notifyDataSetChanged();
        }
    }
}
