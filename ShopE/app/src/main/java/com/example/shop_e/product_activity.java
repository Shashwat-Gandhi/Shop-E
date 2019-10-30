package com.example.shop_e;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

public class product_activity extends AppCompatActivity {

    RecyclerView productRecyclerView;
    RecyclerView.Adapter singleproduct_adapter;
    private boolean product_in_cart = false;
    private boolean cart_presence_changed = false;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_activity);
        intent = getIntent();

        //layout code

        productRecyclerView = findViewById(R.id.single_product_recycler_view);
        productRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        productRecyclerView.setHasFixedSize(true);
        int[] imagesSource = intent.getIntArrayExtra("dashdashdash");

        singleproduct_adapter = new single_product_adapter(imagesSource, this);
        productRecyclerView.setAdapter(singleproduct_adapter);


        //cart functionality
        Button addToCartButton = findViewById(R.id.addToCart);
        product_in_cart = ((MyApplication) this.getApplication()).cart.findProduct(((MyApplication) this.getApplication()).charTypeIndexOfProduct);
        if (product_in_cart) {
            addToCartButton.setText("Remove From Cart");
        } else {
            addToCartButton.setText("Add To Cart");
        }

    }

    //activated when add to wish list is pressed
    public void saveUnsave(View view) {
        CheckBox checkBox = findViewById(R.id.checkBox_addToWishList);

        if (checkBox.isChecked()) {
            checkBox.setText(R.string.saved);
        } else {
            checkBox.setText(R.string.notSaved);
        }
    }


    //when buy now is clicked
    public void buy_click(View view) {
        //open buy activity

    }

    //when to add to cart is clicked
    public void addToCart(View view) {
        Button button = (Button) view;
        cart_presence_changed = !cart_presence_changed;
        if (!product_in_cart) {
            product_in_cart = true;
            button.setText(R.string.remove_from_cart);
        } else if (product_in_cart) {
            product_in_cart = false;
            button.setText(R.string.add_to_cart_button_text);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        updateCart();
        //write to the file
       // ((MyApplication) this.getApplication()).cart.saveProducts(this, "userData");
    }

    @Override
    protected void onPause() {
        super.onPause();

        //updateCart();
    }

    @Override
    protected void onResume() {
        super.onResume();

        //cart functionality
        //Button addToCartButton = findViewById(R.id.addToCart);
        //product_in_cart = ((MyApplication) this.getApplication()).cart.findProduct(((MyApplication) this.getApplication()).charTypeIndexOfProduct);
       // if (product_in_cart) {
      //      addToCartButton.setText("Remove From Cart");
      //  } else {
     //       addToCartButton.setText("Add To Cart");
    //    }
    }

    private void updateCart() {
        if (cart_presence_changed) {
            if (product_in_cart) {
                ((MyApplication) this.getApplication()).cart.addProduct(((MyApplication) this.getApplication()).charTypeIndexOfProduct, this);

            } else {
                ((MyApplication) this.getApplication()).cart.removeProduct(((MyApplication) this.getApplication()).charTypeIndexOfProduct);

            }
        }
    }
}