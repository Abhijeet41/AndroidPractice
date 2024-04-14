package com.abhi41.demoproject.recylerview;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abhi41.demoproject.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Item> itemList;

    public MyAdapter(List<Item> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Item item = itemList.get(position);
            holder.title.setText(item.getItemName());
            holder.iv_item.setImageResource(item.getItemImg());
            holder.description.setText(item.getItemDesc());
    }

    @Override
    public int getItemCount() {
        Log.d("size",String.valueOf(itemList.size()));
        return itemList.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView iv_item;
        private TextView title,description;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_item = itemView.findViewById(R.id.iv_item);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);

        }
    }
}
