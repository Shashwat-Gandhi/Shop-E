package com.example.shop_e;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class product_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_activity);
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
