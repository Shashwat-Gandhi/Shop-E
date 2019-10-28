package com.example.shop_e;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static androidx.core.content.ContextCompat.startActivity;

public class dashChildAdapter extends RecyclerView.Adapter<dashChildAdapter.ViewHolder> {
    private String str = "com.example.shop_e";
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
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        childItemForDash childItem = childList.get(position);
        holder.textView.setText(childItem.getTitle());
        holder.textView.setText(((MyApplication)context.getApplicationContext()).getString());
        holder.imageView.setImageResource(childItem.getSrc());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,product_activity.class);
                int[] image_sources = {R.drawable.black_shirt_pos1,
                        R.drawable.black_shirt_pos2,
                        R.drawable.black_shirt_pos3,
                        R.drawable.black_shirt_pos4};
                intent.putExtra("dashdashdash",image_sources);
                startActivity(context,intent,new Bundle());
            }
        });
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
