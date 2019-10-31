package com.example.shop_e;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.io.File;

public class start_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);


        addAllProucts();

        //this wil fill the cart at the start
        ((MyApplication)this.getApplication()).cart.fillCart(new File(this.getFilesDir(),"userData"),this);

        //this will fill the wish list
        ((MyApplication)this.getApplication()).wishList.fillCart(new File(this.getFilesDir(),"wishList"),this);

        Thread thread = new Thread() {
            @Override
            public void run() {
                try{
                    sleep(2000);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                finally{
                    Intent mainIntent = new Intent(start_Activity.this,DashboardActivity.class);
                    startActivity(mainIntent);
                }
            }
        };


        thread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();

        finish();
    }
    void addProduct(String name,String color,int price,int src,String size,TypeOfProduct type,int index) {
        ((MyApplication)this.getApplication()).addProduct(name,color,price,src,size,type,index);
    }
    void addAllProucts() {
        //add kurtas
        int tempSize = ((MyApplication)this.getApplication()).products.size();

        //((MyApplication)this.getApplication()).addProduct("Black T-Shirt","Black",320,R.drawable.black_shirt_pos1,"S",TypeOfProduct.Kurtas,tempSize + i);
        addProduct("Blue Kurta","Blue",200,R.drawable.kurta_blue,"S",TypeOfProduct.Kurtas,tempSize + 0);
        addProduct("White Kurta","White",230,R.drawable.white_kurta,"S",TypeOfProduct.Kurtas,tempSize + 1);
        addProduct("Orange Kurta","Orange",230,R.drawable.orange_kurta,"S",TypeOfProduct.Kurtas,tempSize + 2);


        //add jeans
        tempSize = ((MyApplication)this.getApplication()).products.size();
        //for(int i=0;i < 3;i++) {
        // ((MyApplication)this.getApplication()).addProduct("Black T-Shirt","Black",320,R.drawable.black_shirt_pos1,"S",TypeOfProduct.Jeans,tempSize + i);
        addProduct("Black Jeans","Black",120,R.drawable.black_jeans,"S",TypeOfProduct.Jeans,tempSize);
        addProduct("Blue Kurta","Blue",230,R.drawable.blue_jeans,"S",TypeOfProduct.Jeans,tempSize + 1);
        addProduct("Grey Jeans","Grey",230,R.drawable.gey_jeans,"S",TypeOfProduct.Jeans,tempSize + 2);
        //  }

        //add shirts
        tempSize = ((MyApplication)this.getApplication()).products.size();
        //  for(int i=0;i < 3;i++) {
        //((MyApplication)this.getApplication()).addProduct("Black T-Shirt","Black",320,R.drawable.black_shirt_pos1,"S",TypeOfProduct.Shirts,tempSize + i);
        addProduct("White Shirt","White",250,R.drawable.shirt_white,"S",TypeOfProduct.Shirts,tempSize + 0);
        addProduct("Blue Shirt","Blue",300,R.drawable.blue_shirt,"S",TypeOfProduct.Shirts,tempSize + 1);
        addProduct("Black Shirt","Black",280,R.drawable.black_shirt_pos1,"S",TypeOfProduct.Shirts,tempSize + 2);
        //  }

        // add tshirts
        tempSize = ((MyApplication)this.getApplication()).products.size();
        // for(int i=0;i < 3;i++) {
        //  ((MyApplication)this.getApplication()).addProduct("Black T-Shirt","Black",320,R.drawable.black_shirt_pos1,"S",TypeOfProduct.TShirts,tempSize + i);
        //  }

        addProduct("Maroon TShirt","White",250,R.drawable.maroontshirt,"S",TypeOfProduct.TShirts,tempSize + 0);
        addProduct("Blue TShirt","Blue",300,R.drawable.bluetshirt,"S",TypeOfProduct.TShirts,tempSize + 1);
        addProduct("Black TShirt","Black",280,R.drawable.blacktshirt,"S",TypeOfProduct.TShirts,tempSize + 2);



        // add tracks
        tempSize = ((MyApplication)this.getApplication()).products.size();
        // for(int i=0;i < 3;i++) {
        //  ((MyApplication)this.getApplication()).addProduct("Black T-Shirt","Black",320,R.drawable.black_shirt_pos1,"S",TypeOfProduct.Tracks,tempSize + i);
        // }
        addProduct("Black Tracks","Black",120,R.drawable.black_tracks,"S",TypeOfProduct.Tracks,tempSize);
        addProduct("Blue Tracks","Blue",180,R.drawable.blue_tracks,"S",TypeOfProduct.Tracks,tempSize + 1);
        addProduct("Grey Tracks","Grey",190,R.drawable.grey_tracks,"S",TypeOfProduct.Tracks,tempSize + 2);

    }
}
