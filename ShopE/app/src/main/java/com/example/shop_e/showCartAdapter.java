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

public class showCartAdapter extends RecyclerView.Adapter<showCartAdapter.ViewHolder> {
    final  public Context context;
    private   List<Product> products;
    TextView  cartTotalText;

    public showCartAdapter(Context context, List<Product> products,TextView cartTotalText) {
        this.context = context;
        this.products = products;
        this.cartTotalText = cartTotalText;
    }
    List<Product> getProducts() {
        return products;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_image_layout,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.name.setText(products.get(position).getName());
        holder.price.setText("Rs " + String.valueOf(products.get(position).getPrice()));
        holder.size.setText("Size : " + products.get(position).getSize());
        holder.color.setText("Color : " + products.get(position).getColor());
        holder.image.setImageResource(products.get(position).getSrc());
        holder.removeFromCartButton.setText("Remove From Cart");
        holder.buyButton.setText("Buy Now");

        holder.buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product product = products.get(position);

                //adds in the bought user products
                ((MyApplication)context.getApplicationContext()).userProducts.addProduct(product);
                ((MyApplication)context.getApplicationContext()).userProducts.saveProducts(context,"userProducts");

                Intent intent = new Intent(context,Invoice.class);
                intent.putExtra("com.example.shop_e.did_buy",true);
                intent.putExtra("com.example.shop_e.product.name",product.getName());
                intent.putExtra("com.example.shop_e.product.size",product.getSize());
                intent.putExtra("com.example.shop_e.product.color",product.getColor());
                intent.putExtra("com.example.shop_e.product.price",product.getPrice());

                //((MyApplication)context.getApplicationContext()).cart.products.remove(products.get(position));
                ((MyApplication)context.getApplicationContext()).cart.products.remove(product);
                ((MyApplication)context.getApplicationContext()).cart.saveProducts(context,"userData");

                //remove the product from wishList
                ((MyApplication) context.getApplicationContext()).wishList.remove(product.getSrc(), false);
                ((MyApplication)context.getApplicationContext()).wishList.saveProducts(context,"wishList");

                //notify that adapter that the dataset has changed
                ((MyApplication)context.getApplicationContext()).cartAdapter.notifyDataSetChanged();

                //update to other views
                int totalPrice = 0;
                for(int i=0;i < products.size();i++) {
                    totalPrice += products.get(i).getPrice();
                }
                cartTotalText.setText(String.valueOf(totalPrice));

                startActivity(context,intent,new Bundle());

            }
        });
        holder.removeFromCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MyApplication)context.getApplicationContext()).cart.products.remove(products.get(position));
                ((MyApplication)context.getApplicationContext()).cart.saveProducts(context,"userData");
                ((MyApplication)context.getApplicationContext()).cartAdapter.notifyDataSetChanged();
                int totalPrice = 0;
                for(int i=0;i < products.size();i++) {
                    totalPrice += products.get(i).getPrice();
                }
                cartTotalText.setText(String.valueOf(totalPrice));
            }
        });

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