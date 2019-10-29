package com.example.shop_e;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class start_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        //reads and sets the cart_prodcuts and stringBufferOfCartProducts
        StringBuffer stringBuffer = new StringBuffer();
        try(BufferedReader reader = new BufferedReader(new FileReader(new File(this.getFilesDir(),"userData")))) {
            String line = reader.readLine();
            while(line != null) {
                stringBuffer.append(line).append('\n');
                ((MyApplication)this.getApplication()).numProductInCart++;
                line = reader.readLine();
            }
            ((MyApplication)this.getApplication()).cart_products = stringBuffer.toString();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            ((MyApplication)this.getApplication()).stringBufferOfBuyedProducts = stringBuffer;
        }


        /********adding 15 temporary products for now *********/
        for(int i=0;i < 3;i++) {
            ((MyApplication)this.getApplication()).addProduct("Black T-Shirt","Black",320,R.drawable.black_shirt_pos1,1,TypeOfProduct.Kurtas);
        }
        for(int i=0;i < 3;i++) {
            ((MyApplication)this.getApplication()).addProduct("Black T-Shirt","Black",320,R.drawable.black_shirt_pos1,1,TypeOfProduct.Jeans);
        }
        for(int i=0;i < 3;i++) {
            ((MyApplication)this.getApplication()).addProduct("Black T-Shirt","Black",320,R.drawable.black_shirt_pos1,1,TypeOfProduct.Shirts);
        }
        for(int i=0;i < 3;i++) {
            ((MyApplication)this.getApplication()).addProduct("Black T-Shirt","Black",320,R.drawable.black_shirt_pos1,1,TypeOfProduct.TShirts);
        }
        for(int i=0;i < 3;i++) {
            ((MyApplication)this.getApplication()).addProduct("Black T-Shirt","Black",320,R.drawable.black_shirt_pos1,1,TypeOfProduct.Tracks);
        }
        /***************              *********/

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
