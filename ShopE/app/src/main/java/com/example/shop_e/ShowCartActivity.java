package com.example.shop_e;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShowCartActivity extends Activity {
    RecyclerView recyclerViewForCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_cart);
        updateCartAndLayout();
    }

    //empty up the cart
    public void checkOut(View v) {
        Intent intent = new Intent(this,Invoice.class);

        ((MyApplication)this.getApplication()).cart.emptyAll();
        ((MyApplication)this.getApplication()).cartAdapter.notifyDataSetChanged();
        TextView cartTotalText = findViewById(R.id.textView_cart_total_amount);
        cartTotalText.setText("");
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    private void updateCartAndLayout() {
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

        ((MyApplication)this.getApplication()).cartAdapter = new showCartAdapter(this,((MyApplication)this.getApplication()).cart.getProducts(),cartTotalText);
        recyclerViewForCart.setAdapter(((MyApplication)this.getApplication()).cartAdapter);
    }
}
