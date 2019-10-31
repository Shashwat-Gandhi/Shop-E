package com.example.shop_e;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import static androidx.core.content.ContextCompat.startActivity;

public class DashboardActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    private List<CategoryList>categoryLists;

    RecyclerView recyclerViewForDash;
    RecyclerView.Adapter adapterForDash;
    List<parentItemForDash>parentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        /***************       for category view        ***************/
        recyclerView = findViewById(R.id.category_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        categoryLists = new ArrayList<>();

        categoryLists.add(new CategoryList(R.drawable.category_kurtas_button));
        categoryLists.add(new CategoryList(R.drawable.category_jeans_button));
        categoryLists.add(new CategoryList(R.drawable.category_shirts_button));
        categoryLists.add(new CategoryList(R.drawable.category_t_shirts_button));
        categoryLists.add(new CategoryList(R.drawable.category_tracks_button));


        recyclerViewForDash = findViewById(R.id.dash_main_recview);
        adapter = new CategoryLayoutAdaptor(categoryLists,this,recyclerViewForDash);
        recyclerView.setAdapter(adapter);

        /******************************************/
        /********       for dashboard    ***********/

       recyclerViewForDash.setHasFixedSize(true);
       recyclerViewForDash.setLayoutManager(new LinearLayoutManager(this));

       parentList = new ArrayList<>();

       parentList.add(new parentItemForDash("Kurtas"));
       parentList.add(new parentItemForDash("Jeans"));
       parentList.add(new parentItemForDash("Shirt"));
       parentList.add(new parentItemForDash("T-Shirt"));
       parentList.add(new parentItemForDash("Tracks"));

       adapterForDash = new dashParentAdapter(parentList,this);
       recyclerViewForDash.setAdapter(adapterForDash);

    }
    public void viewCart(View view) {
        Intent intent = new Intent(this,ShowCartActivity.class);
        startActivity(intent, new Bundle());
    }
    public void viewWishList(View view) {
        startActivity(new Intent(this,WishList.class));

    }
}
