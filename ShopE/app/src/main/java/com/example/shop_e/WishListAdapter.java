package com.example.shop_e;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static androidx.core.content.ContextCompat.startActivity;

public class WishListAdapter extends RecyclerView.Adapter<WishListAdapter.ViewHolder> {
    Context context;
    List<Product>products;

    public WishListAdapter(Context context, List<Product> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.wish_list_product,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.imageView.setImageResource(products.get(position).getSrc());
        holder.name.setText(products.get(position).getName());
        holder.price.setText("Rs " + String.valueOf(products.get(position).getPrice()));
        holder.button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context,product_activity.class);
                ((MyApplication)context.getApplicationContext()).setCurrentProduct(products.get(position).getIndex());
                startActivity(context,intent,new Bundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder {
        public Button button;
        public ImageView imageView;
        public TextView name;
        public TextView price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            button = itemView.findViewById(R.id.button_wl_toProduct);
            name = itemView.findViewById(R.id.textView_wl_name);
            price = itemView.findViewById(R.id.textView_wl_price);
            imageView = itemView.findViewById(R.id.imageView_wl_image);
        }
    }
}
