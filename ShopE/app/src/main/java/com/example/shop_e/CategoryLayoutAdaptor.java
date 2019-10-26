package com.example.shop_e;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CategoryLayoutAdaptor extends RecyclerView.Adapter<CategoryLayoutAdaptor.ViewHolder> {
    private List<CategoryList>categoryLists;
    private Context context;

    public CategoryLayoutAdaptor(List<CategoryList> categoryLists, Context context) {
        this.categoryLists = categoryLists;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_layout,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       CategoryList category = categoryLists.get(position);
       holder.imageButton.setImageResource(category.getImageSrc());
    }

    @Override
    public int getItemCount() {
        return categoryLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageButton imageButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageButton = itemView.findViewById(R.id.category_button);
        }
    }

}
