package com.example.shop_e;

import android.content.Context;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

//This class is like a parent class for wishlist ,cart and user orders,etc
//easies the process of storing and updating carts or bags as you say
public class CartClass {
    public List<Product>products = new ArrayList<>();

    void remove(int indexInProductList) {
        char index = (char)indexInProductList;
        for(int i=0;i < products.size();i++) {
            if(products.get(i).getCharIndex() == index) {
                products.remove(i);
                break;
            }
        }
    }
    void remove(int src,boolean isItIndexInProductList) {
        if(!isItIndexInProductList && products.size() > 0) {
            for(int i=0;i < products.size();i++) {
                if(products.get(i).getSrc() == src) {
                    products.remove(i);
                    break;
                }
            }
        }
    }

    //adds new instance and not a reference to the product in the product list in cart
    void addProduct(int indexInProductList, Context context) {
        Product pro = ((MyApplication)context.getApplicationContext()).products.get(indexInProductList);
        Product product = new Product(pro.getName(),pro.getColor(),pro.getPrice(),pro.getSrc(),pro.getSize(),pro.getType(),pro.getIndex());
        products.add(product);
    }

    //add new instance and not a reference to the product in the product list in cart
    void addProduct(Product product) {
        Product product1 = new Product(product.getName(),product.getColor(),product.getPrice(),product.getSrc(),
                                        product.getSize(),product.getType(),product.getIndex());
        products.add(product1);
    }
    //this write the cart products in a file so that the items are saved when app is exited
    void saveProducts(Context context,String fileName) {
        StringBuffer stringBuffer  = new StringBuffer();

        for(int i=0;i < this.products.size();i++) {
            stringBuffer.append(products.get(i).getCharIndex()).append('\n');
        }
        try {
            FileOutputStream outputStream = context.openFileOutput(fileName,Context.MODE_PRIVATE);
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
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            for(int i=0;i < line.length();i++) {
                if(line.charAt(i)!= ' ' && line.charAt(i)!= '\n') {
                    products.add(((MyApplication)context.getApplicationContext()).getProduct((int)line.charAt(i)));
                }
            }
            line = reader.readLine();
            while(line != null) {
                for(int i=0;i < line.length();i++) {
                    if(line.charAt(i)!= ' ' && line.charAt(i)!= '\n') {
                        products.add(((MyApplication)context.getApplicationContext()).getProduct((int)line.charAt(i)));
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
    void emptyAll() {
        products.clear();
    }
}