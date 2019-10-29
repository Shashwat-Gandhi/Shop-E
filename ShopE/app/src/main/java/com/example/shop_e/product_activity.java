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
        productRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        productRecyclerView.setHasFixedSize(true);
        int[] imagesSource = intent.getIntArrayExtra("dashdashdash");

        singleproduct_adapter = new single_product_adapter(imagesSource,this);
        productRecyclerView.setAdapter(singleproduct_adapter);


        //cart functionality
        Button addToCartButton = findViewById(R.id.addToCart);

        try(BufferedReader reader = new BufferedReader(new FileReader(new File(this.getFilesDir(),"userData")))) {
            String line = reader.readLine();
            while(line != null && !product_in_cart ) {
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == ((MyApplication) this.getApplication()).charTypeIndexOfProduct) {
                        addToCartButton.setText(R.string.remove_from_cart);
                        product_in_cart = true;
                    }
                }
                line = reader.readLine();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        if(!product_in_cart) {
            addToCartButton.setText(R.string.add_to_cart_button_text);
        }
        else {
            addToCartButton.setText(R.string.remove_from_cart);
        }

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
        Button button = (Button)view;
        cart_presence_changed = !cart_presence_changed;
        if(!product_in_cart) {
            product_in_cart = true;
            button.setText(R.string.remove_from_cart);
        }
        else if(product_in_cart) {
            product_in_cart =false;
            button.setText(R.string.add_to_cart_button_text);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(cart_presence_changed) {
            if(product_in_cart) {
                StringBuffer userStringBuffer = new StringBuffer();
               readIntoBuffer(userStringBuffer,this);
                String addition = (((MyApplication)this.getApplication()).charTypeIndexOfProduct + "");
                userStringBuffer.append(addition).append('\n');
               writeFromBuffer(userStringBuffer,this);
            }
            else {
                /**finds the line in which the product index is and removes it ***/
                StringBuffer userStringBuffer = new StringBuffer();
                try (BufferedReader reader = new BufferedReader(new FileReader(new File(this.getFilesDir(),"userData")))){
                    String line = reader.readLine();
                    boolean product_line = false;
                    while(line != null) {
                        for(int i=0;i < line.length();i++) {
                            if(line.charAt(i) == ((MyApplication)this.getApplication()).charTypeIndexOfProduct) {
                                product_line = true;
                            }
                        }
                        if(!product_line) {userStringBuffer.append(line).append('\n');}
                        line = reader.readLine();
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }

                //write to the file
                writeFromBuffer(userStringBuffer,this);
            }
        }
    }

    //read from the file into the string buffer
    void readIntoBuffer(StringBuffer stringBuffer,Context context) {
        try (BufferedReader reader =new BufferedReader(new FileReader(new File(context.getFilesDir(),"userData")))){
            String line = reader.readLine();
            while(line != null) {
                stringBuffer.append(line).append('\n');
                line = reader.readLine();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    void writeFromBuffer(StringBuffer stringBuffer,Context context) {
        try{
            FileOutputStream outputStream = openFileOutput("userData", Context.MODE_PRIVATE);

            outputStream.write(stringBuffer.toString().getBytes());
            outputStream.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
