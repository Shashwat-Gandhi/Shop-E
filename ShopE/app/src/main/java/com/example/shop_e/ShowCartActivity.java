package com.example.shop_e;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ShowCartActivity extends AppCompatActivity {
    RecyclerView recyclerViewForCart;
    RecyclerView.Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_cart);

        //show the cart total
        TextView cartTotalText = findViewById(R.id.textView_cart_total_amount);
        int totalPrice = 0;
        for(int i=0;i < ((MyApplication)this.getApplication()).cart.getNumProducts();i++) {
            totalPrice += ((MyApplication)this.getApplication()).cart.getProducts().get(i).getPrice();
        }
        cartTotalText.setText(String.valueOf(totalPrice));

        //set up the recycler view
        recyclerViewForCart = findViewById(R.id.rec_show_cart_main);
        recyclerViewForCart.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewForCart.setHasFixedSize(true);
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("asf","asd",32,R.drawable.black_shirt_pos1,1,TypeOfProduct.Shirts,2));
        adapter = new showCartAdapter(this,((MyApplication)this.getApplication()).cart.getProducts());
        recyclerViewForCart.setAdapter(adapter);
    }

    //empty up the cart
    public void checkOut(View v) {
        Intent intent = new Intent(this,Invoice.class);

        ((MyApplication)this.getApplication()).cart.emptyAll();

        startActivity(intent);
    }
}
