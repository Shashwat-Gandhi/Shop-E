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

import java.io.File;


public class product_activity extends AppCompatActivity {

  //  boolean presenceInWishListChanged = false;
    //sorry but the presenceInWishList thing can't be because of the user being able to bypass onPause
    //so have to update it every time after changing it

    boolean isInWishList = false;int index;

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
        index =((MyApplication)this.getApplication()).charTypeIndexOfProduct;
        Product product = ((MyApplication)this.getApplication()).products.get(index);
        priceText.setText("Rs " + String.valueOf(product.getPrice()));

        //initialize the checkBox
        CheckBox checkBox = findViewById(R.id.checkBox_addToWishList);
        isInWishList = ((MyApplication)this.getApplication()).wishList.findProduct(index);
        if(isInWishList) {
            checkBox.setChecked(true);
            checkBox.setText("Added to Wish List");
        }
        else {
            checkBox.setText("Add to Wish List");
            checkBox.setChecked(false);
        }
    }

    //activated when add to wish list is pressed
    public void saveUnsave(View view) {
        isInWishList = !isInWishList;
        updateTheWishList();         //this way it might take some extra time but it is worth it
        ((MyApplication)this.getApplication()).wishList.saveProducts(this,"wishList");

        CheckBox checkBox = findViewById(R.id.checkBox_addToWishList);
        checkBox.setChecked(isInWishList);
        if(isInWishList) {checkBox.setText("Added to Wish List");}
        else {checkBox.setText("Add to Wish List");}
    }

    @Override
    protected void onResume() {
        super.onResume();

       //update your checkBox
        CheckBox checkBox = findViewById(R.id.checkBox_addToWishList);
        isInWishList = ((MyApplication)this.getApplication()).wishList.findProduct(index);
        if(isInWishList) {
            checkBox.setChecked(true);
        }
        else {
            checkBox.setChecked(false);
        }
    }

    //when buy now is clicked
    public void buy_click(View view) {
        //open buy activity
        Product product = ((MyApplication)this.getApplication()).products.get(index);

        //remove from wishlist and update its local file
        ((MyApplication)this.getApplication()).wishList.remove(index);
        ((MyApplication)this.getApplication()).wishList.saveProducts(this,"wishList");

        /*********** don't forget to set the size of the product before showing the invoice         *********/
        switch (option) {
            case 0:
                product.setSize("S");
                break;
            case 1:
                product.setSize("M");
                break;
            case 2:
                product.setSize("L");
                break;
            case 3:
                product.setSize("XL");
                break;
            case 4:
                product.setSize("XXL");
                break;
            default:
                break;
        }

        //update the user product list as promised
        ((MyApplication)this.getApplication()).userProducts.addProduct(product);
        ((MyApplication)this.getApplication()).userProducts.saveProducts(this,"userProducts");


        //there are other better ways but just why not!
        Intent intent = new Intent(this,Invoice.class);
        intent.putExtra("com.example.shop_e.did_buy",true);
        intent.putExtra("com.example.shop_e.product.name",product.getName());
        intent.putExtra("com.example.shop_e.product.size",product.getSize());
        intent.putExtra("com.example.shop_e.product.color",product.getColor());
        intent.putExtra("com.example.shop_e.product.price",product.getPrice());

        startActivity(intent);
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
                        (((MyApplication)this.getApplication()).cart.getNumProducts()-1).setSize("M");
                break;
            case 2:
                ((MyApplication)this.getApplication()).cart.getProduct
                        (((MyApplication)this.getApplication()).cart.getNumProducts()-1).setSize("L");
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

        ((MyApplication)this.getApplication()).cart.saveProducts(this,"userData");

        //shows the pop up window
        startActivity(new Intent(this,PopUpWindow.class));
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

    //never forget to set presence to false after updating the wish list
    private void updateTheWishList() {
        if(isInWishList) {
            ((MyApplication)this.getApplication()).wishList.addProduct(index,this);
        }
        else {
            ((MyApplication)this.getApplication()).wishList.remove(index);
        }
    }
    public void openSingleImage(View v) {
        Intent intent = new Intent(this,only_image_activity.class);
        intent.putExtra("com.example.shop_e.only_image_image",((MyApplication)this.getApplication()).products.get(index).getSrc());
        startActivity(intent);

    }
}