package com.example.shop_e;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void on(View view) {
        CheckBox checkBox = findViewById(R.id.checkBox_addToWishList);
        if(checkBox.isChecked()) {
            checkBox.setText(R.string.saved);
        }
        else {
            checkBox.setText(R.string.notSaved);
        }
    }
}
