package com.example.shop_e;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class dashParentAdapter extends RecyclerView.Adapter<dashParentAdapter.ViewHolder> {
    private List<parentItemForDash>parentList;
    private Context context;
    private RecyclerView.Adapter adapterForcChild;
    List<childItemForDash>childList;


    public dashParentAdapter(List<parentItemForDash> headingText, Context context) {
        this.parentList = headingText;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dash_parent_layout,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        parentItemForDash parentItem = parentList.get(position);
        holder.headingTextView.setText(parentItem.getName());
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        holder.recyclerView.setHasFixedSize(true);

        childItemForDash childItem = new childItemForDash("Title",R.drawable.shirt_white);
        childList = new ArrayList<>();
        childList.add(childItem);
        childList.add(childItem);
        childList.add(childItem);

        adapterForcChild = new dashChildAdapter(childList,context);
        holder.recyclerView.setAdapter(adapterForcChild);

    }

    @Override
    public int getItemCount() {
        return parentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView headingTextView;
        public RecyclerView recyclerView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.dash_child_recview);
            headingTextView = itemView.findViewById(R.id.dash_head_text);
        }
    }
}
