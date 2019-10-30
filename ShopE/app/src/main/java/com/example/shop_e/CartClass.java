package com.example.shop_e;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CartClass {
    public List<Product>products = new ArrayList<>();

    //adds the product in the product list in cart
    void addProduct(int indexInProductList, Context context) {
        products.add(((MyApplication)context.getApplicationContext()).products.get(indexInProductList));
    }

    //removes the product from the product list in cart
    void removeProduct(int indexInProductList) {
        int indexInCart = -1;
        for(int i=0;i <products.size();i++) {
            if(products.get(i).getCharIndex() == (char)indexInProductList) {
                indexInCart = i;
            }
        }
        if(indexInCart != -1) {
            products.remove(indexInCart);
        }
    }
    //this write the cart products in a file so that the items are saved when app is exited
    void saveProducts(Context context,String fileName) {
        StringBuffer stringBuffer  = new StringBuffer();
        for(int i=0;i < products.size();i++) {
            stringBuffer.append(products.get(i).getCharIndex()).append('\n');
        }
        try {
            FileOutputStream outputStream = context.openFileOutput("userData",Context.MODE_PRIVATE);
            outputStream.write(stringBuffer.toString().getBytes());
            outputStream.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    boolean findProduct(int indexInProduct) {
        for(int i=0;i < products.size();i++) {
            if(products.get(i).getIndex() == indexInProduct) {
                return true;
            }
        }
        return false;
    }

    //this will fill the cart from the file saved on internal memory
    void fillCart(File file,Context context) {
        try(BufferedReader reader = new BufferedReader(new FileReader(new File("userData")))) {
            String line = reader.readLine();
            while(line != null) {
                for(int i=0;i < line.length();i++) {
                    if(line.charAt(i)!= ' ' && line.charAt(i)!= '\n') {
                        products.add(((MyApplication)context.getApplicationContext()).getProduct(line.charAt(i)));
                    }
                }
                line = reader.readLine();

            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    int getNumProducts() {
        return products.size();
    }
    Product getProduct(int indexInCart) {
        return products.get(indexInCart);
    }
    List<Product> getProducts() {
        return products;
    }
}