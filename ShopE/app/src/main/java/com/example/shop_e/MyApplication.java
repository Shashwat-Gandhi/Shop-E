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
    /****Hint for later use -
     * *****since user can bypass onPause and onDestroy feature by swiping it out from recent apps
     * list make sure to save the products list,cart list,wish list, etc
     * in a local file every time you update it
     */

    List<Product> products = new ArrayList<>();     //all the original products that will be available for sale

    UserBoughtItems cart = new UserBoughtItems();   //well there is the size factor which i didn't add before and now i have
                                                    //already made the new class so ... why not!

    //for convenience in adding and removing or selecting products
    void addProduct(String name,String color,int prize,int src,String size,TypeOfProduct type,int index) {
        Product product = new Product(name,color,prize,src,size,type,index);
        products.add(product);
    }
    public void setCurrentProduct(int index) {
        this.charTypeIndexOfProduct = (char)index;
    }
    Product getProduct(int position) {
        return products.get(position);
    }

    Product getCurrentProduct() { return  products.get((int)charTypeIndexOfProduct);}

    char charTypeIndexOfProduct = (char)(-1);


    CartClass wishList = new CartClass();       //since the wish list is very similar to cart so this is what i did
    UserBoughtItems userProducts = new UserBoughtItems();   //UserBoughtItems is next gen of cart class because of the size factor

    //needed to update it from inside the adapter so this is the way around i found to store adapter
    // in application and access from within adapter because the cart adapter has remove from cart button
    //which changes the size of recycler view
    showCartAdapter cartAdapter;



}
