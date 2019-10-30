package com.example.shop_e;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ShowCartActivity extends AppCompatActivity {
    RecyclerView recyclerViewForCart;
    RecyclerView.Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_cart);


        recyclerViewForCart = findViewById(R.id.rec_show_cart_main);
        recyclerViewForCart.setLayoutManager(new LinearLayoutManager(this));
      //  recyclerViewForCart.setHasFixedSize(true);
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("asf","asd",32,R.drawable.black_shirt_pos1,1,TypeOfProduct.Shirts,2));
        adapter = new showCartAdapter(this,((MyApplication)this.getApplication()).cart.products);
        recyclerViewForCart.setAdapter(adapter);
    }
}
