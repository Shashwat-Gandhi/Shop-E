package com.example.shop_e;

import android.app.Application;

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
    Product currentProduct;
    void addProduct(String name,String color,int prize,int src,int size,TypeOfProduct type) {
        Product product = new Product(name,color,prize,src,size,type);
        products.add(product);
    }
    Product getProduct(int position) {
        return products.get(position);
    }

    String cart_products;
    StringBuffer stringBufferOfBuyedProducts = new StringBuffer();
    int numProductInCart = 0;
    char charTypeIndexOfProduct = (char)(0);
}
