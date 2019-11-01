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

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {
    List<Product>products;
    Context context;

    public OrderAdapter(List<Product> products, Context context) {
        this.products = products;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_layout,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.imageView.setImageResource(products.get(position).getSrc());
        holder.name.setText(products.get(position).getName());
        holder.price.setText("Rs " + String.valueOf(products.get(position).getPrice()));
        holder.size.setText("Size : " + products.get(position).getSize());
        holder.color.setText("Color : " + products.get(position).getColor());

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product product = products.get(position);
                Intent intent = new Intent(context,Invoice.class);
                intent.putExtra("com.example.shop_e.did_buy",true);
                intent.putExtra("com.example.shop_e.product.name",product.getName());
                intent.putExtra("com.example.shop_e.product.size",product.getSize());
                intent.putExtra("com.example.shop_e.product.color",product.getColor());
                intent.putExtra("com.example.shop_e.product.price",product.getPrice());

                startActivity(context,intent,new Bundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public Button button;
        public ImageView imageView;
        public TextView name;
        public TextView price;
        public TextView color;
        public TextView size;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            button = itemView.findViewById(R.id.order_view_invoice);
            name = itemView.findViewById(R.id.order_name);
            price = itemView.findViewById(R.id.order_price);
            imageView = itemView.findViewById(R.id.order_image);
            size = itemView.findViewById(R.id.order_size);
            color = itemView.findViewById(R.id.order_color);

        }
    }
}
