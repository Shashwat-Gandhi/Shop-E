package com.example.shop_e;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static androidx.core.content.ContextCompat.startActivity;

public class single_product_adapter extends RecyclerView.Adapter<single_product_adapter.ViewHolder> {
    int[] imageSources;
    Context context;

    public single_product_adapter(int[] imageSources,Context context) {
        this.imageSources = imageSources;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_product_image_layout,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.imageView.setImageResource(imageSources[position]);
        holder.imageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,only_image_activity.class);
                intent.putExtra("com.example.shop_e.only_image_image",imageSources[position]);
                startActivity(context,intent, new Bundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return imageSources.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.single_product_image);
        }
    }
}
