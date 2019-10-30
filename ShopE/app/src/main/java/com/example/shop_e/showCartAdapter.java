package com.example.shop_e;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class showCartAdapter extends RecyclerView.Adapter<showCartAdapter.ViewHolder> {
    Context context;
    List<Product> products;

    public showCartAdapter(Context context, List<Product> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_image_layout,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(products.get(position).getName());
        holder.price.setText("Rs " + String.valueOf(products.get(position).getPrice()));
        holder.size.setText("Size : " + String.valueOf(products.get(position).getSize()));
        holder.color.setText("Color : " + products.get(position).getColor());
        holder.removeFromCartButton.setText("Remove From Cart");
        holder.buyButton.setText("Buy Now");
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView price;
        public TextView size;
        public TextView color;
        public ImageView image;
        public Button buyButton;
        public Button removeFromCartButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.textView_name_pro_in_cart);
            price = itemView.findViewById(R.id.textView_price_pro_in_cart);
            size = itemView.findViewById(R.id.textView_size_pro_in_cart);
            color = itemView.findViewById(R.id.textView_color_pro_in_cart);
            image = itemView.findViewById(R.id.imageView_cart_image);
            buyButton = itemView.findViewById(R.id.button_buy_in_cart);
            removeFromCartButton = itemView.findViewById(R.id.button_remove_in_cart);
        }
    }
}