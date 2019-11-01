package com.example.shop_e;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class YourOrders extends AppCompatActivity {
    RecyclerView recyclerView;
    OrderAdapter orderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_orders);

        recyclerView = findViewById(R.id.order_rec_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        orderAdapter = new OrderAdapter(((MyApplication)this.getApplication()).userProducts.getProducts(),this);
        recyclerView.setAdapter(orderAdapter);
    }

}
