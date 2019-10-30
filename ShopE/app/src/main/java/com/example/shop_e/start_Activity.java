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


        /********adding 15 temporary products for now *********/
        for(int i=0;i < 3;i++) {
            ((MyApplication)this.getApplication()).addProduct("Black T-Shirt","Black",320,R.drawable.black_shirt_pos1,1,TypeOfProduct.Kurtas,i);
        }
        for(int i=0;i < 3;i++) {
            ((MyApplication)this.getApplication()).addProduct("Black T-Shirt","Black",320,R.drawable.black_shirt_pos1,1,TypeOfProduct.Jeans,3 + i);
        }
        for(int i=0;i < 3;i++) {
            ((MyApplication)this.getApplication()).addProduct("Black T-Shirt","Black",320,R.drawable.black_shirt_pos1,1,TypeOfProduct.Shirts,6 + i);
        }
        for(int i=0;i < 3;i++) {
            ((MyApplication)this.getApplication()).addProduct("Black T-Shirt","Black",320,R.drawable.black_shirt_pos1,1,TypeOfProduct.TShirts,9 + i);
        }
        for(int i=0;i < 3;i++) {
            ((MyApplication)this.getApplication()).addProduct("Black T-Shirt","Black",320,R.drawable.black_shirt_pos1,1,TypeOfProduct.Tracks,12 + i);
        }
        /***************              *********/


        //this wil fill the cart at the start
        ((MyApplication)this.getApplication()).cart.fillCart(new File(this.getFilesDir(),"userData"),this);




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
}
