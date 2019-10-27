package com.example.shop_e;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import java.util.ArrayList;

public class product_activity extends AppCompatActivity {

    RecyclerView productRecyclerView;
    RecyclerView.Adapter singleproduct_adapter;
    private int[] imageSources;
    Intent intent;
       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_activity);
        intent = getIntent();

        productRecyclerView = findViewById(R.id.single_product_recycler_view);
        productRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        productRecyclerView.setHasFixedSize(true);
        int[] imagesSource = intent.getIntArrayExtra("dashdashdash");
        this.imageSources = imagesSource;
        singleproduct_adapter = new single_product_adapter(imageSources);
        productRecyclerView.setAdapter(singleproduct_adapter);
    }

    //activated when add to wish list is pressed
    public void saveUnsave(View view) {
        CheckBox checkBox = findViewById(R.id.checkBox_addToWishList);

        if(checkBox.isChecked()){
            checkBox.setText(R.string.saved);
        }
        else {
            checkBox.setText(R.string.notSaved);
        }
    }


    //when buy now is clicked
    public void buy_click(View view) {
        //open buy activity
    }

    //when to add to cart is clicked
    public void addToCart(View view) {
        // add to cart
    }

}
