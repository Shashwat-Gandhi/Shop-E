package com.example.shop_e;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

//the adapter for the category button layout in the dashboard
//nothing new or special in it
public class CategoryLayoutAdaptor extends RecyclerView.Adapter<CategoryLayoutAdaptor.ViewHolder> {
    private List<CategoryList>categoryLists;
    private Context context;
    private RecyclerView recyclerViewForDash;

    public CategoryLayoutAdaptor(List<CategoryList> categoryLists, Context context, RecyclerView recyclerViewForDash) {
        this.categoryLists = categoryLists;
        this.context = context;
        this.recyclerViewForDash = recyclerViewForDash;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_layout,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
       CategoryList category = categoryLists.get(position);
       holder.imageButton.setImageResource(category.getImageSrc());
       holder.imageButton.setOnClickListener(new View.OnClickListener() {

           @Override
           public void onClick(View v) {
               recyclerViewForDash.smoothScrollToPosition(position);
           }
       });
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
