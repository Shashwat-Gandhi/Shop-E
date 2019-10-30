package com.example.shop_e;

import android.app.Application;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


/** This class is used for
 *
 * declaring all the data for the products and
 * all the user data
 *
 * **/
public class MyApplication extends Application {
    List<Product> products = new ArrayList<>();
    CartClass cart = new CartClass();
    void addProduct(String name,String color,int prize,int src,String size,TypeOfProduct type,int index) {
        Product product = new Product(name,color,prize,src,size,type,index);
        products.add(product);
    }
    Product getProduct(int position) {
        return products.get(position);
    }

    Product getCurrentProduct() { return  products.get((int)charTypeIndexOfProduct);}

    char charTypeIndexOfProduct = (char)(0);

    showCartAdapter cartAdapter;

}
