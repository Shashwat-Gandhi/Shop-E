package com.example.shop_e;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class only_image_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_only_image_activity);

        ImageView imageView = findViewById(R.id.only_image_image_id);
        Intent intent = getIntent();
        int i = intent.getIntExtra("com.example.shop_e.only_image_image",R.drawable.shirt_white);
        imageView.setImageResource(i);
    }
}







