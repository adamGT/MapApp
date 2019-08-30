package com.example.mapapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mapapp.POJO.BackCardItem;
import com.example.mapapp.R;

import java.util.ArrayList;
import java.util.List;

public class BackCardAdapter extends RecyclerView.Adapter<BackCardAdapter.ViewHolder> {

    List<BackCardItem> backCardItems;
    private Context mContext;

    public BackCardAdapter(List<BackCardItem> backCardItems){
        this.backCardItems = backCardItems;
    }

    public BackCardAdapter(Context mContext){
        this.mContext = mContext;
        backCardItems = new ArrayList<>();
    }

    public void addToList(BackCardItem backCardItem){
        backCardItems.add(backCardItem);
    }


    public BackCardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.country_list_item, parent, false);

        return new BackCardAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final String itemName = this.backCardItems.get(position).getItemName();
        final int itemIcon = this.backCardItems.get(position).getItemIconId();
//        Toast.makeText(mContext,countries.get(1)+", "+countries.get(2)+", "+countries.get(3),Toast.LENGTH_LONG).show();

        holder.itemTextView.setText(itemName);
        holder.itemIcon.setImageDrawable(mContext.getResources().getDrawable(itemIcon));
    }

    @Override
    public int getItemCount() {
        return this.backCardItems != null ? this.backCardItems.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView itemTextView;
        public ImageView itemIcon;

        public ViewHolder(@NonNull View view) {
            super(view);
            itemTextView = view.findViewById(R.id.tv_country);
            itemIcon = view.findViewById(R.id.item_image);

        }


    }

}
