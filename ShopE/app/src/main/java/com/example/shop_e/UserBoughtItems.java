package com.example.shop_e;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

public class UserBoughtItems extends CartClass {

    @Override
    void fillCart(File file, Context context) {
        super.fillCart(file, context);

        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();

            //products.add(((MyApplication)context.getApplicationContext()).getProduct((int)line.charAt(0)));
            this.addProduct(((MyApplication)context.getApplicationContext()).getProduct((int)line.charAt(0)));

            //since size can be XL XXL also which is two nad three characters long
            String size = "";
            for(int i=2;i < line.length();i++) {
                if(line.charAt(i) != '\n' && line.charAt(i) != ' ') {
                    size += line.charAt(i);
                }
            }
            products.get(products.size()- 1).setSize(size);

            line = reader.readLine();
            while(line != null) {

                //products.add(((MyApplication)context.getApplicationContext()).getProduct((int)line.charAt(0)));
                this.addProduct(((MyApplication)context.getApplicationContext()).getProduct((int)line.charAt(0)));
                //since size can be XL XXL also which is two nad three characters long
                size = "";
                for(int i=2;i < line.length();i++) {
                    if(line.charAt(i) != '\n' && line.charAt(i) != ' ') {
                        size += line.charAt(i);
                    }
                }
                products.get(products.size()- 1).setSize(size);

                line = reader.readLine();

            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    void saveProducts(Context context, String fileName) {
        super.saveProducts(context, fileName);

        StringBuffer stringBuffer  = new StringBuffer();

        for(int i=0;i < this.products.size();i++) {
            stringBuffer.append(products.get(i).getCharIndex());
            stringBuffer.append((char)30);
            stringBuffer.append(products.get(i).getSize());
            stringBuffer.append('\n');
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
}

