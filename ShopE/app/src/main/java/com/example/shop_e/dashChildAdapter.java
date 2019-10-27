package com.example.shop_e;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class dashChildAdapter extends RecyclerView.Adapter<dashChildAdapter.ViewHolder> {

    List<childItemForDash>childList;
    Context context;

    public dashChildAdapter(List<childItemForDash> childList, Context context) {
        this.childList = childList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dash_child_layout,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        childItemForDash childItem = childList.get(position);
        holder.textView.setText(childItem.getTitle());
        holder.imageView.setImageResource(childItem.getSrc());
    }

    @Override
    public int getItemCount() {
        return childList.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder {
        public TextView textView;
        public ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.dash_child_image);
            textView = itemView.findViewById(R.id.dash_child_name_text);
        }
    }
}
