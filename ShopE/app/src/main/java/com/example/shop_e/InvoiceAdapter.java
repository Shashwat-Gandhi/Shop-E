package com.example.shop_e;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class InvoiceAdapter extends RecyclerView.Adapter<InvoiceAdapter.ViewHolder> {

    Context context;
    List<Product>products;

    public InvoiceAdapter(Context context, List<Product> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.invoice_layout,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name_text.setText(products.get(position).getName());
        holder.price_text.setText(String.valueOf(products.get(position).getPrice()));
        holder.color_text.setText(products.get(position).getColor());
        holder.size_text.setText(products.get(position).getSize());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name_text;
        public TextView price_text;
        public TextView size_text;
        public TextView color_text;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name_text = itemView.findViewById(R.id.invoice_name_text_view);
            price_text = itemView.findViewById(R.id.invoice_price_text_view);
            size_text = itemView.findViewById(R.id.invoice_size_text_view);
            color_text = itemView.findViewById(R.id.invoice_color_text_view);
        }
    }
}
