package com.example.shop_e;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    private List<CategoryList>categoryLists;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        recyclerView = findViewById(R.id.category_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        categoryLists = new ArrayList<>();

        categoryLists.add(new CategoryList(R.drawable.category_shirts));
        categoryLists.add(new CategoryList(R.drawable.category_t_shirts));
        categoryLists.add(new CategoryList(R.drawable.category_kurtas));
        categoryLists.add(new CategoryList(R.drawable.category_jeans));
        categoryLists.add(new CategoryList(R.drawable.category_tracks));

        adapter = new CategoryLayoutAdaptor(categoryLists,this);
        recyclerView.setAdapter(adapter);
    }
}
