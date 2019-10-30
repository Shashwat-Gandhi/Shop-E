package com.example.shop_e;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class product_activity extends AppCompatActivity {

    public Button[] button = new Button[5];
    int option = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_activity);

        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageResource(((MyApplication)this.getApplication()).getProduct((int)((MyApplication)this.getApplication()).charTypeIndexOfProduct).getSrc());

        //initialize buttons;
        button[0] = findViewById(R.id.size_S);
        button[1] = findViewById(R.id.size_M);
        button[2] =  findViewById(R.id.size_L);
        button[3] =  findViewById(R.id.size_XL);
        button[4] = findViewById(R.id.size_XXL);

        //coloring option buttons
        button[0].setBackgroundColor(Color.DKGRAY);
        for(int i=1;i < 5;i++) {
            button[i].setBackgroundColor(Color.GRAY);
        }

        //coloring other buttons
        Button addToCart = findViewById(R.id.addToCart);
        addToCart.setBackgroundColor(Color.GRAY);
        Button buyNow = findViewById(R.id.buyNow);
        buyNow.setBackgroundColor(Color.GRAY);

        //writing the price of product
        TextView priceText = findViewById(R.id.textView_price_of_product);
        int index =((MyApplication)this.getApplication()).charTypeIndexOfProduct;
        Product product = ((MyApplication)this.getApplication()).products.get(index);
        priceText.setText("Rs " + String.valueOf(product.getPrice()));
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
        /*********** don't forget to set the size of the product before showing the invoice         *********/

    }

    //when to add to cart is clicked
    public void addToCart(View view) {
        //just adds the product to the cart as many times you hit it
        ((MyApplication) this.getApplication()).cart.addProduct(((MyApplication) this.getApplication()).charTypeIndexOfProduct, this);
        switch (option) {
            case 0:
                ((MyApplication)this.getApplication()).cart.getProduct
                        (((MyApplication)this.getApplication()).cart.getNumProducts()-1).setSize("S");
                break;
            case 1:
                ((MyApplication)this.getApplication()).cart.getProduct
                        (((MyApplication)this.getApplication()).cart.getNumProducts()-1).setSize("L");
                break;
            case 2:
                ((MyApplication)this.getApplication()).cart.getProduct
                        (((MyApplication)this.getApplication()).cart.getNumProducts()-1).setSize("M");
                break;
            case 3:
                ((MyApplication)this.getApplication()).cart.getProduct
                        (((MyApplication)this.getApplication()).cart.getNumProducts()-1).setSize("XL");
                break;
            case 4:
                ((MyApplication)this.getApplication()).cart.getProduct
                        (((MyApplication)this.getApplication()).cart.getNumProducts()-1).setSize("XXL");
                break;
            default:
                break;
        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //updateCart();
    }


    public void optionSelected_S(View v) {
        button[option].setBackgroundColor(Color.GRAY);
        option = 0;
        button[option].setBackgroundColor(Color.DKGRAY);
    }
    public void optionSelected_M(View v) {
        button[option].setBackgroundColor(Color.GRAY);
        option = 1;
        button[option].setBackgroundColor(Color.DKGRAY);
    }
    public void optionSelected_L(View v) {
        button[option].setBackgroundColor(Color.GRAY);
        option = 2;
        button[option].setBackgroundColor(Color.DKGRAY);
    }
    public void optionSelected_XL(View v) {
        button[option].setBackgroundColor(Color.GRAY);
        option = 3;
        button[option].setBackgroundColor(Color.DKGRAY);
    }
    public void optionSelected_XXL(View v) {
        button[option].setBackgroundColor(Color.GRAY);
        option = 4;
        button[option].setBackgroundColor(Color.DKGRAY);
    }

    public void viewCart(View view) {
        Intent intent = new Intent(this,ShowCartActivity.class);
        startActivity(intent, new Bundle());
    }
}